package com.assignment4.webfluxapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment4.webfluxapp.pojo.Publisher;
import com.assignment4.webfluxapp.repository.PublisherRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PublisherService {
	@Autowired
	
	private final PublisherRepository publisherRepository;
	
	public PublisherService(PublisherRepository publisherRepository) {
		this.publisherRepository = publisherRepository;
	}
	
	public Mono<Publisher> addPublisher(Publisher publisher){
		return publisherRepository.save(publisher);
	}

	public Flux<Publisher> getAllPublisher(){
		return publisherRepository.findAll();
	}
	
	public Mono<Publisher> getPublissherById(String pubId){
		return publisherRepository.findById(pubId);
	}
	
	public Mono<Publisher> updatePublisher(String pubId, Publisher updatePublisher){
		return publisherRepository.findById(pubId)
				.flatMap(existingPublisher -> {
					existingPublisher.setName(updatePublisher.getName());
					existingPublisher.setAddress(updatePublisher.getAddress());
					return publisherRepository.save(existingPublisher);
				});
	}
	
	public Mono<Void> deletePublisher(String pubId){
		return publisherRepository.deleteById(pubId);
	}
	
}
