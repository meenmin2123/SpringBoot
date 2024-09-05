package com.ss.restful.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.restful.dto.MemberDTO;
import com.ss.restful.entity.Member;
import com.ss.restful.repository.MemberRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemberService {

	@Autowired
	private MemberRepository repository;
	
	public Member create(MemberDTO mem) {
		
		
		Member member = mem.toEntity();
		Member res = repository.save(member);
		
		return res;
	}

	public Member getMemberByUserID(Long userID) {
		return repository.findById(userID);
		
	}
	

}
