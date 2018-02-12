package com.mycompany.twitteranalysis;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class Main {
    public static void main(String[] args) {
        MongoClient mongoClient = MongoConnection.getInstance();
        Tweets tweets = new Tweets();
        
        DB db = mongoClient.getDB("social_net");
        DBCollection collection = db.getCollection("tweets");
        
        String input = args[0];
        if(input != null) {
            switch(input) {
                case "TotalAmount":
                    System.out.println("\n" + "Total user amount: " + tweets.TwitUsers(collection));
                    break;
                case "Top10Linkers":
                    System.out.println("\n" + "Top 10 linkers: " + tweets.TopLink(collection));
                    break;
                case "Top5Mentioned":
                    System.out.println("\n" + "Top 5 mentioned: " + tweets.MentUser(collection));
                    break;
                case "Top10Active":
                    System.out.println("\n" + "Top 10 most active: " + tweets.MostActive(collection));
                    break;
                case "Top5Negative":
                    System.out.println("\n" + "Top 5 most grumpy: " + tweets.MostGrumpy(collection));
                    break;
                case "Top5Positive":
                    System.out.println("\n" + "Top 5 most happy: " + tweets.MostHappy(collection));
                    break;
                default:
                    System.out.println("\n" + "Error, not a viable command.");
                    break;
            }
        }
    }
}
