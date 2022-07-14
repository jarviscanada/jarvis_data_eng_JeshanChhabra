package ca.jrvs.apps.twitter;

import ca.jrvs.apps.twitter.dao.CrdDao;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.service.Service;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IllformedLocaleException;
import java.util.List;

@org.springframework.stereotype.Service
public class TwitterService implements Service {

    CrdDao dao;

    @Autowired
    public TwitterService(CrdDao dao) {
        System.out.println("servics");
        this.dao = dao;

    }

    @Override
    public Tweet postTweet(Tweet tweet) throws OAuthMessageSignerException, OAuthExpectationFailedException, IOException, OAuthCommunicationException {

        Tweet postTweet = validateTweet(tweet);

        return (Tweet) this.dao.create(postTweet);
    }

    @Override
    public Tweet showTweet(String id, String[] fields) throws OAuthMessageSignerException, OAuthExpectationFailedException, IOException, OAuthCommunicationException {
        validateTweetId(id);
         Tweet response = (Tweet) this.dao.findById(id);

         if (fields.length == 0 || fields == null){
             return response;
         }
    Tweet modifiedTweet = new Tweet();
        Arrays.stream(fields).forEach(property -> {

            if (property.equals("id") ){
                modifiedTweet.setId(response.getId());
            }
            else if (property.equals("id_str")){
                modifiedTweet.setId(response.getId());
            }
            else if (property.equals("created_at")){
                modifiedTweet.setCreated_at(response.getCreated_at());
            }
            else if (property.equals("text")){
                modifiedTweet.setText(response.getText());
            }
            else if (property.equals("entities")){
                modifiedTweet.setEntities(response.getEntities());
            }
            else if (property.equals("coordinates")){
                modifiedTweet.setCoordinates(response.getCoordinates());
            }
            else if (property == "retweet_count"){
                modifiedTweet.setRetweet_count(response.getRetweet_count());
            }
            else if (property.equals("favorite_count")){
                modifiedTweet.setFavorite_count(response.getFavorite_count());
            }
            else if (property.equals("favorited")){
                modifiedTweet.setFavorited(response.isFavorited());
            }
            else if (property.equals("retweeted")){
                modifiedTweet.setRetweeted(response.isRetweeted());
            }
        });

      return modifiedTweet;
    }

    private void validateTweetId(String id) {
        if (!(id.trim().length() > 0 && id.trim().length() < Math.pow(2,64) - 1 )){
            throw new IllegalArgumentException("Tweet id is not valid");
        }
    }

    @Override
    public List<Tweet> deleteTweets(String[] ids) {
        List<Tweet> deletedTweetList = new ArrayList<>();
        Arrays.stream(ids).forEach(id -> {
            validateTweetId(id);
        });
        Arrays.stream(ids).forEach(id-> {
            try {
                deletedTweetList.add((Tweet) this.dao.deleteById(id));
            }catch(OAuthException | IOException e){
                throw new RuntimeException("Tweet does not exists");
            }
        });

        return deletedTweetList;
    }

    private Tweet validateTweet(Tweet tweet){

        if(tweet.getText().length() > 140 ){
            throw new IllegalArgumentException("Tweet text cannot exceed ");
        }
        //checking lat bounds
        if (tweet.getCoordinates().getCoordinates()[0] < -90 || tweet.getCoordinates().getCoordinates()[0] > 90 ){
            throw new IllegalArgumentException("Latitude should be in range [-90,90]");
        }
        //checking longitude bounds
        if (tweet.getCoordinates().getCoordinates()[1] < -180 || tweet.getCoordinates().getCoordinates()[1] > 180 ){
            throw new IllegalArgumentException("Latitude should be in range [-180,180]");
        }
        return tweet;
    }

}
