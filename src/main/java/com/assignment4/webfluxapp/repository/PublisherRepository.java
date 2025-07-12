package com.assignment4.webfluxapp.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.assignment4.webfluxapp.pojo.Publisher;

@Repository
public interface PublisherRepository extends ReactiveMongoRepository<Publisher, String>{

}
