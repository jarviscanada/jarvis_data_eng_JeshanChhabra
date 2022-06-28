package ca.jrvs.apps.twitter.example;

import com.google.gdata.util.common.base.PercentEscaper;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.util.Arrays;

public class TwitterApiTest {
    private static String CONSUMER_KEY = "qSSUipKbiSkfnyxENuPtIm7ov";
    
    private static String CONSUMER_SECRET="XOmpuuzgPUcnZ17RRsTbZKGt1uakT76oKjhsZCedvrxO5bAAUl";
    private static String ACCESS_TOKEN="764879745590829056-otYyQRNVwKLvl4IT6gp4zmdsgfapDhC";
    
    private static String TOKEN_SECRET="35hYK3ForVj1Nsh8sTL0U8ksUUT6FxcLwQJcxUIn43HQV";

    public static void main(String[] args) throws Exception {

        //seting up OAUTH
        OAuthConsumer consumer = new CommonsHttpOAuthConsumer(CONSUMER_KEY,CONSUMER_SECRET);
        consumer.setTokenWithSecret(ACCESS_TOKEN,TOKEN_SECRET);

        // create http get req

        String status = "today is a good day";
        PercentEscaper percentEscaper = new PercentEscaper("",false);
        HttpPost request = new HttpPost("https://api.twitter.com/1.1/statuses/update.json?status=" + percentEscaper.escape(status));

        // sign the request(add headers)
        consumer.sign(request);

        System.out.println("http request headers: ");

        Arrays.stream(request.getAllHeaders()).forEach(System.out::println);

        //send the request

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpResponse response = httpClient.execute(request);
        System.out.println(EntityUtils.toString(response.getEntity()));

    }
    
}
