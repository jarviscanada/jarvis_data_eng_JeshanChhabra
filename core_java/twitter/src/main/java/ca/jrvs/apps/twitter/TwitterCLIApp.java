package ca.jrvs.apps.twitter;

import ca.jrvs.apps.twitter.controller.Controller;
import ca.jrvs.apps.twitter.dao.CrdDao;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.service.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Locale;
@Component
public class TwitterCLIApp {

    private final  String USAGE = "USAGE: TwitterCLIApp post|show|delete [options]";

   private Controller controller;

   @Autowired
    public TwitterCLIApp(Controller controller) {
       this.controller = controller;
    }
//    public static void main(String[] args) throws OAuthMessageSignerException, OAuthExpectationFailedException, IOException, OAuthCommunicationException {
//        // getting all the secrets from environment variables
//        String CONSUMER_KEY = System.getenv("consumerKey");
//        String CONSUMER_SECRET=System.getenv("consumerSecret");;
//        String ACCESS_TOKEN=System.getenv("accessToken");;
//        String TOKEN_SECRET=System.getenv("tokenSecret");;
//
//        // creating all the dependencies
//        HttpHelper httpHelper = new TwitterHelper(CONSUMER_KEY,CONSUMER_SECRET,ACCESS_TOKEN,TOKEN_SECRET);
//        CrdDao dao = new TwitterDao(httpHelper);
//        Service service = new TwitterService(dao);
//        Controller controller = new TwitterController(service);
//
//        TwitterCLIApp app = new TwitterCLIApp(controller);
//
//        // start the app
//        app.run(args);
//
//    }

    public void run(String[] args) throws OAuthMessageSignerException, OAuthExpectationFailedException, IOException, OAuthCommunicationException {
        if (args.length == 0){
            throw new IllegalArgumentException(USAGE);
        }
        switch (args[0].toLowerCase()){
            case "post":
                printTweet(this.controller.postTweet(args));
                break;
            case "show":
                printTweet(this.controller.showTweet(args));
                break;
            case "delete":
                this.controller.deleteTweet(args).forEach(this::printTweet);
                break;
            default:
                throw new IllegalArgumentException(USAGE);
        }



    }

    private void printTweet(Tweet tweet) {
        try {
            System.out.println(tweet);
        }catch(Exception e){
            throw new RuntimeException("Unable to convert object to string");
        }
    }


}
