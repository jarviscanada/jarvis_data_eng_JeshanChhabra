package ca.jrvs.apps.twitter;

import ca.jrvs.apps.twitter.dao.CrdDao;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.utils.JsonUtil;
import com.google.gdata.util.common.base.PercentEscaper;
import com.sun.jndi.toolkit.url.Uri;
import jdk.nashorn.internal.runtime.regexp.joni.exception.SyntaxException;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.rmi.RemoteException;

public class TwitterDao implements CrdDao<Tweet,String> {

 // URI constraints

    private static final String API_BASE_URL= "https://api.twitter.com";
    private static final String POST_PATH= "/1.1/statuses/update.json";
    private static final String SHOW_PATH = "/1.1/statuses/show.json";
    private static final String DELETE_PATH= "/1.1/statuses/destroy/";

    //URI SYMBOLS
    private static final String QUERY_SYM= "?";
    private static final String AMPERSAND= "&";
    private static final String EQUAL= "=";

    //Response code
    private static final int HTTP_OK = 200;

    private HttpHelper httpHelper;

    @Autowired
    public TwitterDao(HttpHelper httpHelper) {
        this.httpHelper = httpHelper;
    }

    @Override
    public Tweet create(Tweet entity) throws OAuthMessageSignerException, OAuthExpectationFailedException, IOException, OAuthCommunicationException {
      // Construct uri
        URI uri;
        try {
            uri = getPostUri(entity);
           // System.out.println(uri);
        }catch(URISyntaxException e) {
            throw new RuntimeException("Invalid URI syntax");
        }
        HttpResponse response = httpHelper.httpPost(uri);
        System.out.println("RESPONSE");

        return parseResponseBody(response,HTTP_OK);
    }

    @Override
    public Tweet findById(String s) throws OAuthMessageSignerException, OAuthExpectationFailedException, IOException, OAuthCommunicationException {
        //Construct uri
        URI uri;
    try{
        uri = getGetUri(s);
    }catch(URISyntaxException e){
    throw new RuntimeException("Invalid URI Syntax",e);
}
        HttpResponse res = httpHelper.httpGet(uri);

        return parseResponseBody(res,HTTP_OK);
    }

    private URI getGetUri(String s) throws URISyntaxException {
        return new URI(API_BASE_URL + SHOW_PATH + QUERY_SYM + "id" + EQUAL + s );
    }

    @Override
    public Tweet deleteById(String s) throws OAuthMessageSignerException, OAuthExpectationFailedException, IOException, OAuthCommunicationException {

        //construct uri
        URI uri;
        try {
            uri = getDeleteUri(s);
        }catch(URISyntaxException e){
            throw new RuntimeException("Invalid URI  syntax");
        }

        HttpResponse res = httpHelper.httpPost(uri);

        return parseResponseBody(res,HTTP_OK);
    }

    private URI getDeleteUri(String s) throws URISyntaxException {

        return new URI(API_BASE_URL + DELETE_PATH + s +".json");
    }

    private Tweet parseResponseBody(HttpResponse res, Integer expectedCode) throws IOException {
        Tweet tweet;
       // checking response status

        int status = res.getStatusLine().getStatusCode();
        if (status != expectedCode){
            try{
                System.out.println(EntityUtils.toString(res.getEntity()));
            }catch(IOException e){
                throw new RuntimeException("No response body");
            }
        }
        if (res.getEntity() == null){
            throw new RuntimeException("Empty response");
        }
        String jsonStr;
        // converting entity to string
     try {
         jsonStr = EntityUtils.toString(res.getEntity());
         System.out.println(jsonStr);
     }catch(IOException e){
         e.printStackTrace();
         throw new RuntimeException("Cannot convert entity to str");
     }
        // deserializing str to  tweet obj
try {
      tweet = JsonUtil.toObjectFromJson(jsonStr, Tweet.class);
}catch (IOException e){
    throw new RuntimeException("Unable to convert object from jsonString",e);
}
        return tweet;
 }

    private URI getPostUri(Tweet entity) throws URISyntaxException {
        PercentEscaper escaper = new PercentEscaper("",false);

        return new URI(API_BASE_URL + POST_PATH + QUERY_SYM + "status" + EQUAL + escaper.escape(entity.getText())
        + AMPERSAND + "lat" + EQUAL + entity.getCoordinates().getCoordinates()[0]
                + AMPERSAND + "long" + EQUAL + entity.getCoordinates().getCoordinates()[1]
        );
    }
}
