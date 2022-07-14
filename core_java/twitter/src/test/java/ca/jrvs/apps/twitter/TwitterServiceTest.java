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
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TwitterServiceTest {

    TwitterDao dao;
    TwitterService service;
    @Before
    public void setup(){
        String CONSUMER_KEY = System.getenv("consumerKey");
        String CONSUMER_SECRET=System.getenv("consumerSecret");;
        String ACCESS_TOKEN=System.getenv("accessToken");;
        String TOKEN_SECRET=System.getenv("tokenSecret");;
        HttpHelper httpHelper = new TwitterHelper(CONSUMER_KEY,CONSUMER_SECRET,ACCESS_TOKEN,TOKEN_SECRET);
        this.dao = new TwitterDao(httpHelper);
        this.service = new TwitterService(dao);
    }

//    @Test
//    public void postTweet() throws OAuthMessageSignerException, OAuthExpectationFailedException, IOException, OAuthCommunicationException {
//        String text = "Nwe virat is here";
//        Tweet tweet = new Tweet();
//
//        tweet = TweetUtil.buildTweet(text,79.0f,178.7f);
//        tweet = this.service.postTweet(tweet);
//        assertEquals(text,tweet.getText());
//    }
//
//    @Test
//    public void showTweet() throws OAuthMessageSignerException, OAuthExpectationFailedException, IOException, OAuthCommunicationException {
//        String[] fields = {"id","id_str","entities"} ;
//        Tweet response = service.showTweet("1544823987582017536",fields);
//        assertEquals("1544823987582017536",response.getId());
//    }
//
//    @Test
//    public void deleteTweets() {
//        String[] ids = {"766692486022508544","1546544404768473089"};
//        List<Tweet> tweet;
//        tweet = this.service.deleteTweets(ids);
//        assertEquals(tweet.get(0).getId(),ids[0]);
//        assertEquals(tweet.get(0).getId(),ids[1]);
//
//
//    }
}