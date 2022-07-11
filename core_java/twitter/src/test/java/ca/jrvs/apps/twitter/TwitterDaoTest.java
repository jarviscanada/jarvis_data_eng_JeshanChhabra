package ca.jrvs.apps.twitter;

import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.utils.TweetUtil;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class TwitterDaoTest {
    static Tweet postTweet = new Tweet();
    TwitterDao dao;
    @Before
    public void setup(){
         String CONSUMER_KEY = System.getenv("consumerKey");
         String CONSUMER_SECRET=System.getenv("consumerSecret");;
         String ACCESS_TOKEN=System.getenv("accessToken");;
         String TOKEN_SECRET=System.getenv("tokenSecret");;
         HttpHelper httpHelper = new TwitterHelper(CONSUMER_KEY,CONSUMER_SECRET,ACCESS_TOKEN,TOKEN_SECRET);
     this.dao = new TwitterDao(httpHelper);
    }

//    @Test
//    public void create() throws OAuthMessageSignerException, OAuthExpectationFailedException, IOException, OAuthCommunicationException {
//        String hashtag = " #abc ";
//        String text = "@mention hell09ijj32134"+ hashtag + System.currentTimeMillis();
//        float lat = 1.1f;
//        float lon = -1.1f;
//        Tweet postTweet = TweetUtil.buildTweet(text,lat,lon);
//        Tweet tweet = this.dao.create(postTweet);
//
//         // to test the recently created tweet
//        this.postTweet.setId_str(tweet.getId_str());
//
//        System.out.println(tweet);
//        assertEquals(text,tweet.getText());
//
//        assertNotNull(tweet.getCoordinates());
//        assertEquals(2,tweet.getCoordinates().getCoordinates().length);
//        //assertEquals(lat,tweet.getCoordinates().getCoordinates()[0]);
//
//       // assertTrue(hashtag.contains(tweet.getEntities().getHashtags().get(0).getText()));
//
//
//    }

    @Test
    public void findById() throws OAuthMessageSignerException, OAuthExpectationFailedException, IOException, OAuthCommunicationException {
//    Tweet tweet = this.dao.findById(TwitterDaoTest.postTweet.getId_str() );

        Tweet tweet = this.dao.findById("1544912144965279744");
        System.out.println("kida /n"+tweet);


    }

//    @Test
//    public void deleteById() throws OAuthMessageSignerException, OAuthExpectationFailedException, IOException, OAuthCommunicationException {
//        // deleting the same tweet created above...
//        Tweet tweet = this.dao.deleteById(TwitterDaoTest.postTweet.getId_str() );
//
//    }



}