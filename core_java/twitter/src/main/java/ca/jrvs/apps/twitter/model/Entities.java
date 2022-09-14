package ca.jrvs.apps.twitter.model;


import java.util.ArrayList;

public class Entities {

    private ArrayList<Hashtag> hashtags = new ArrayList<>();

    private ArrayList<UserMention> user_mentions = new ArrayList<>();

    public ArrayList<Hashtag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(ArrayList<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }

    public ArrayList<UserMention> getUser_mentions() {
        return user_mentions;
    }

    public void setUser_mentions(ArrayList<UserMention> user_mentions) {
        this.user_mentions = user_mentions;
    }

    @Override
    public String toString() {
        return "Entities{" +
                "hashtags=" + hashtags +
                ", user_mentions=" + user_mentions +
                '}';
    }
}
