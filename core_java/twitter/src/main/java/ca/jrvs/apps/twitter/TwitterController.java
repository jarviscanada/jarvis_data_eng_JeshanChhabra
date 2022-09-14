package ca.jrvs.apps.twitter;

import ca.jrvs.apps.twitter.controller.Controller;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.service.Service;
import ca.jrvs.apps.twitter.utils.TweetUtil;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

@org.springframework.stereotype.Controller
public class TwitterController implements Controller {

    private static final String COORD_SEP = ":";
    private static final String COMMA = ",";


    private Service service;

    @Autowired
    public TwitterController(Service service) {
     this.service = service;

    }

    @Override
    public Tweet postTweet(String[] args) throws OAuthMessageSignerException, OAuthExpectationFailedException, IOException, OAuthCommunicationException {
       if (args.length != 3){
           throw new IllegalArgumentException("USAGE: TwitterCliApp post \"tweet_text\" " +
                   " \"latitude:longitude\" ");
       }
        String tweet_text = args[1];
        String coords = args[2];
        String[] coord_array = coords.split(COORD_SEP);
        if (coord_array.length !=2 || tweet_text.isEmpty()){
            throw new IllegalArgumentException("USAGE: TwitterCliApp post \"tweet_text\" " +
                    " \"latitude:longitude\" ");
        }
        Float lat = null;
        Float lon = null;
       try {
            lat = Float.parseFloat(args[2].split(COORD_SEP)[0]);
            lon =  Float.parseFloat(args[2].split(COORD_SEP)[1]);
       }catch(Exception e){
           throw new IllegalArgumentException("Invalid location format: TwitterCliApp post \"tweet_text\" " +
                   " \"latitude:longitude\" ");
       }
       Tweet postTweet = TweetUtil.buildTweet(tweet_text,lat,lon);
       return this.service.postTweet(postTweet);
    }

    @Override
    public Tweet showTweet(String[] args) throws OAuthMessageSignerException, OAuthExpectationFailedException, IOException, OAuthCommunicationException {
        String[] fields = {};
        String tweet_id = args[1];
        if(args.length == 3){
          fields = args[2].split(COMMA);
        }
        else if (args.length != 2){
            throw new IllegalArgumentException("USAGE: TwitterCliApp show \"tweet_id\" " +
                    " \"{options}\" ");
        }

        return this.service.showTweet(tweet_id,fields);
    }

    @Override
    public List<Tweet> deleteTweet(String[] args) {
        if (args.length != 2){
            throw new IllegalArgumentException("USAGE: TwitterCliApp delete \"[ids]\" ");
        }

        String[] tweet_ids = args[1].split(COMMA);

        return this.service.deleteTweets(tweet_ids);
    }
}
