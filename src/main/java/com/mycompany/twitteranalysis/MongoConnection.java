package com.mycompany.twitteranalysis;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class MongoConnection {
    
    private static MongoClient instance = null;
    private MongoConnection() {
        //Compiler can't make a default constructor and stops instantiation.
    }
    
    public static synchronized MongoClient getInstance() {
        if (instance == null) {
            MongoClientURI connectionString = new MongoClientURI("mongodb://localhost:27017");
            instance = new MongoClient(connectionString);
        }
        return instance;
    }
    
}
