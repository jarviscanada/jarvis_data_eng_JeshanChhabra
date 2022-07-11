package ca.jrvs.apps.twitter;

import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
@Component
public class TwitterHelper implements HttpHelper {

    private OAuthConsumer consumer;
    private HttpClient httpClient;

    /**
     * Constructor
     *
     *
     * @param consumerKey
     * @param consumerSecret
     * @param accessToken
     * @param tokenSecret
     */
    public TwitterHelper(String consumerKey, String consumerSecret, String accessToken, String tokenSecret) {
        consumer= new CommonsHttpOAuthConsumer(consumerKey,consumerSecret);
        consumer.setTokenWithSecret(accessToken,tokenSecret);
        httpClient= new DefaultHttpClient();
    }

    @Override
    public HttpResponse httpPost(URI uri) {
        try{
            return executeHttpRequest(HttpMethod.POST,uri);
        }
        catch(OAuthException | IOException e){
            throw new RuntimeException("Failed to excecute" , e);
        }
    }

    @Override
    public HttpResponse httpGet(URI uri)  {
       try{
           return executeHttpRequest(HttpMethod.GET,uri);
       }
       catch(OAuthException | IOException e){
           throw new RuntimeException("Failed to excecute" , e);
       }

    }
    private HttpResponse executeHttpRequest(HttpMethod method, URI uri ) throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, IOException {
        if (method == HttpMethod.GET){
            HttpGet request = new HttpGet(uri);

            consumer.sign(request);  // adding headers

            return httpClient.execute(request);
        }
        else if(method == HttpMethod.POST){
            HttpPost request = new HttpPost(uri);

            consumer.sign(request);  // adding headers

            return httpClient.execute(request);
        }else {
            throw new IllegalArgumentException("Unknown http method" + method.name());
        }

    }


}
