package ca.jrvs.apps.twitter.utils;

import ca.jrvs.apps.twitter.model.Coordinates;
import ca.jrvs.apps.twitter.model.Tweet;

public class TweetUtil {

    public static Tweet buildTweet(String text,Float lat,Float lon){
        Tweet tweet = new Tweet();
        tweet.setText(text);
        Coordinates coordinates = new Coordinates();
        coordinates.setCoordinates(new float[]{lat, lon});
        tweet.setCoordinates(coordinates);
        return tweet;
    }

}
