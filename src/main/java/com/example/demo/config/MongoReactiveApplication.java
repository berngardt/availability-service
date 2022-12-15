package com.example.demo.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@EntityScan("com.example.demo.repository")
@EnableReactiveMongoRepositories(basePackages = {"com.example.demo.repository"})
@Configuration
public class MongoReactiveApplication{
}
