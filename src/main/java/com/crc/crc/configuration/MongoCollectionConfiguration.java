package com.crc.crc.configuration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoCollectionConfiguration {

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb://user:password@localhost:27017/admin");
    }

    @Bean
    public MongoDatabase mongoDatabase(MongoClient mongoClient) {
        return mongoClient.getDatabase("admin");
    }

    @Bean
    public MongoCollection<Document> mongoCollection(MongoDatabase mongoDatabase) {
        return mongoDatabase.getCollection("book");
    }

}
