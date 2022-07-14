package ca.jrvs.apps.twitter;

import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.utils.TweetUtil;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.annotation.Order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TwitterControllerTest {

    TwitterDao dao;
    TwitterService service;

    TwitterController controller;

    String check_id;

    @Before
    public void setup(){
        String CONSUMER_KEY = System.getenv("consumerKey");
        String CONSUMER_SECRET=System.getenv("consumerSecret");;
        String ACCESS_TOKEN=System.getenv("accessToken");;
        String TOKEN_SECRET=System.getenv("tokenSecret");;
        HttpHelper httpHelper = new TwitterHelper(CONSUMER_KEY,CONSUMER_SECRET,ACCESS_TOKEN,TOKEN_SECRET);
        this.dao = new TwitterDao(httpHelper);
        this.service = new TwitterService(dao);
        this.controller = new TwitterController(service);
    }

    @Test
    @Order(1)
    public void postTweet() throws OAuthMessageSignerException, OAuthExpectationFailedException, IOException, OAuthCommunicationException {
        String text = "i kkk lokijuhy";
        float lat = 45.0f;
        float lon = 90.8f;
        String[] str = {"post",text,"45:170"};
        Tweet tweet = this.controller.postTweet(str);
        System.out.println(tweet);

        check_id = tweet.getId_str();
        System.out.println(check_id);

        assertEquals(text,tweet.getText());

    }


    @Test
    @Order(2)
    public void showTweet() throws OAuthMessageSignerException, OAuthExpectationFailedException, IOException, OAuthCommunicationException {
        System.out.println(check_id);
        //System.out.println(id);
//        String[] str = {"show",id};
//        Tweet response = this.controller.showTweet(str);
//        assertEquals("1546918338219106306",response.getId_str());
    }

    @Test
    @Order(3)
    public void deleteTweet() {
//        String delete_Tweet_ids = id;
//        String[] str = {"delete",delete_Tweet_ids};
//        List<Tweet> deleted_tweets;
//
//        deleted_tweets = this.controller.deleteTweet(str);
//
//        assertEquals(deleted_tweets.get(0).getId(),id);
//       // assertEquals(deleted_tweets.get(0).getId(),"1546921531649015809");

    }
}