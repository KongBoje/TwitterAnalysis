package com.mycompany.twitteranalysis;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import java.util.Arrays;



public class Tweets {
    
    public String rege = "(?<=^|(?<=[^a-zA-Z0-9-_\\.]))@([A-Za-z]+[A-Za-z0-9_]+)";
    
    public Tweets(){
    }
    
    //How many Twitter users are in the database?
    public long TwitUsers(DBCollection collection) {
        return collection.count();
    }
    
    //Which Twitter users link the most to other Twitter users? (Provide the top ten.)
    public Iterable<DBObject> TopLink(DBCollection collection) {
        Iterable<DBObject> ai = collection.aggregate(Arrays.asList(
                new BasicDBObject("$match", new BasicDBObject("text", new BasicDBObject("$regex", rege))),
                new BasicDBObject("$group", new BasicDBObject("_id", "$user").append("count", new BasicDBObject("$sum", 1))),
                new BasicDBObject("$sort", new BasicDBObject("count", -1)),
                new BasicDBObject("$limit",10)
        )).results();
        return ai;
    }
    
    //Who are the most mentioned Twitter users? (Provide the top five.)
    public Iterable<DBObject> MentUser(DBCollection collection) {
        Iterable<DBObject> ai = collection.aggregate(Arrays.asList(
                new BasicDBObject("$match", new BasicDBObject("text", new BasicDBObject("$regex", rege))),
                new BasicDBObject("$project", new BasicDBObject("user", "$user").append("texts", new BasicDBObject("$split", Arrays.asList("$text", " ")))),
                new BasicDBObject("$unwind", "$texts"),
                new BasicDBObject("$match", new BasicDBObject("texts", new BasicDBObject("$regex", rege))),
                new BasicDBObject("$group", new BasicDBObject("_id", "$texts").append("count", new BasicDBObject("$sum", 1))),
                new BasicDBObject("$sort", new BasicDBObject("count", -1)),
                new BasicDBObject("$limit", 5)
        )).results();
        return ai;
    }
    
    //Who are the most active Twitter users (top ten)?
    public Iterable<DBObject> MostActive(DBCollection collection) {
        Iterable<DBObject> ai = collection.aggregate(Arrays.asList(
                new BasicDBObject("$group", new BasicDBObject("_id", "$user").append("count", new BasicDBObject("$sum", 1))),
                new BasicDBObject("$sort", new BasicDBObject("count", -1)),
                new BasicDBObject("$limit", 10)
        )).results();
        return ai;
    }
    
    //Who are the five most grumpy (most negative tweets)?
    public Iterable<DBObject> MostGrumpy(DBCollection collection) {
        Iterable<DBObject> ai = collection.aggregate(Arrays.asList(
                new BasicDBObject("$match", new BasicDBObject("polarity", new BasicDBObject("$eq", 0))),
                new BasicDBObject("$group", new BasicDBObject("_id", "$user").append("count", new BasicDBObject("$sum", 1))),
                new BasicDBObject("$sort", new BasicDBObject("count", -1)),
                new BasicDBObject("$limit", 5)
        )).results();
        return ai;
    }
    
    //Who are the five most happy (most positive tweets)?
    public Iterable<DBObject> MostHappy(DBCollection collection) {
        Iterable<DBObject> ai = collection.aggregate(Arrays.asList(
                new BasicDBObject("$match", new BasicDBObject("polarity", new BasicDBObject("$eq", 4))),
                new BasicDBObject("$group", new BasicDBObject("_id", "$user").append("count", new BasicDBObject("$sum", 1))),
                new BasicDBObject("$sort", new BasicDBObject("count", -1)),
                new BasicDBObject("$limit", 5)
        )).results();
        return ai;
    }
}
