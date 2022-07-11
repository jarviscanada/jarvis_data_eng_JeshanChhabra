package ca.jrvs.apps.twitter;

import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.model.Coordinates;
import ca.jrvs.apps.twitter.model.Tweet;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.assertj.core.internal.Floats;
import org.junit.Test;

import java.lang.reflect.Array;
import java.net.URI;
import java.util.Arrays;

import static org.junit.Assert.*;

public class TwitterHelperTest {
    private String CONSUMER_KEY = System.getenv("consumerKey");
    private String CONSUMER_SECRET=System.getenv("consumerSecret");;
    private String ACCESS_TOKEN=System.getenv("accessToken");;
    private String TOKEN_SECRET=System.getenv("tokenSecret");;
    HttpHelper httpHelper = new TwitterHelper(CONSUMER_KEY,CONSUMER_SECRET,ACCESS_TOKEN,TOKEN_SECRET);

    int id ;

    @Test
    public void httpPost() throws Exception{
        HttpResponse response = httpHelper.httpPost(new URI("https://api.twitter.com/1.1/statuses/update.json?status=My_tweet&coordinates=1,-1"));
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    @Test
    public void httpGet() throws Exception{
        HttpResponse res = httpHelper.httpGet(new URI("https://api.twitter.com/1.1/statuses/show.json?id=1544537250377121792"));
       System.out.println(EntityUtils.toString(res.getEntity()));
    }
}