package com.assignment4.webfluxapp.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.assignment4.webfluxapp.pojo.Member;

@Repository
public interface MemberRepository extends ReactiveMongoRepository<Member,String>{

}
