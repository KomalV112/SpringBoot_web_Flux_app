package com.assignment4.webfluxapp.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment4.webfluxapp.pojo.Member;
import com.assignment4.webfluxapp.service.MemberService;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@AllArgsConstructor
@RestController
@RequestMapping("members")
public class MemberController {
	
	private final MemberService memberService;
	
	public MemberController (MemberService memberService) {
		this.memberService=memberService;
	}

	@GetMapping 
	public Flux<Member> getAllMembers(){
		return memberService.getAllMember();
	}
	
	@GetMapping("{id}")
	public Mono<Member> getById(@PathVariable("id") final String id){
		return memberService.getMemberById(id);
	}
	
	@PostMapping
	public Mono<Member> addMember(@RequestBody Member member){
		return memberService.addMember(member);
	}
	
	
	@DeleteMapping("{id}")
	public Mono deleteMember(@PathVariable String id){
		return memberService.deleteMember(id);
	}
}
