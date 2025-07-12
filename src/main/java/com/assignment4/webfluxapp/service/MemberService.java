package com.assignment4.webfluxapp.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assignment4.webfluxapp.pojo.Member;
import com.assignment4.webfluxapp.repository.MemberRepository;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
@AllArgsConstructor
public class MemberService {
	
	@Autowired
	private final MemberRepository memberRepository;
	

	public MemberService(MemberRepository memberRepository) {
		this.memberRepository=memberRepository;
	}
	
	public Mono<Member> addMember(final Member member){
		return memberRepository.save(member);
	}
	
	public Flux<Member> getAllMember(){
		return memberRepository.findAll();
	}
	
	
	public Mono<Member> getMemberById(final String id){
		return memberRepository.findById(id);
	}
	
	
    public Mono<Member> updateMember(final String membId, final Member updatedMember) {
        return memberRepository.findById(membId)
                .flatMap(existingMember -> {
                    existingMember.setName(updatedMember.getName());
                    existingMember.setAddress(updatedMember.getAddress());
                    existingMember.setMembType(updatedMember.getMembType());
                    existingMember.setMembDate(updatedMember.getMembDate());
                    existingMember.setExpiryDate(updatedMember.getExpiryDate());
                    return memberRepository.save(existingMember);
                });
    }
    
    public Mono deleteMember(final String id){
    	final Mono<Member> dbMember = getMemberById(id);
    	if(Objects.isNull(dbMember)) {
    		return Mono.empty();
    	}
    	return getMemberById(id).switchIfEmpty(Mono.empty()).filter(Objects::nonNull).flatMap(memberToBeDeleted-> memberRepository.delete(memberToBeDeleted).then(Mono.just(memberToBeDeleted)));
    }
	
	
	

}
