package com.assignment4.webfluxapp.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment4.webfluxapp.pojo.Publisher;
import com.assignment4.webfluxapp.service.PublisherService;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@AllArgsConstructor
@RestController
@RequestMapping("publishers")
public class PublisherController {

	private final PublisherService publisherService;
	
	public PublisherController (PublisherService publisherService) {
		this.publisherService = publisherService;
	}
	
	@GetMapping
	public Flux<Publisher> getAllPublisher(){
		return publisherService.getAllPublisher();
	}
	
	@PostMapping
	public Mono<Publisher> addPublisher (@RequestBody Publisher publisher){
		return publisherService.addPublisher(publisher);
		
	}
	
	@DeleteMapping("/{id}")
	public Mono<Void> deletePublisher(@PathVariable String id)
	{
		return publisherService.deletePublisher(id);
	}
}
