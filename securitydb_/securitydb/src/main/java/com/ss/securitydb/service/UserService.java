package com.ss.securitydb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ss.securitydb.entity.Role;
import com.ss.securitydb.entity.Users;
import com.ss.securitydb.repository.RoleRepository;
import com.ss.securitydb.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	
	// 회원가입 하는 함수
	public void joinUserwithRole(Users user, String role) {
		
		// 1. 비밀번호 암호화
		String password = passwordEncoder
							.encode(
							user.getPassword());
		user.setPassword(password);
						
		// 2. 사용자 정보 저장
		userRepository.save(user);
		
		// 3. 선택한 역할에 따라 admin -> ROLE_ADMIN저장
		Role userRole = new Role();
		userRole.setRole(role);
		
		// 테이블끼리 연결  joinColumn()
		//   setUserId(user.getId())
		//   setUserName(user.getName())
		userRole.setUsername(user.getUsername());
		
		if((role.equals("ADMIN"))) {
			userRole.setRole("ROLE_ADMIN");
		}else { //USER
			userRole.setRole("ROLE_USER");
		}		
		
		// 4. role 디비에 저장
		roleRepository.save(userRole);
	}
	
	
	// username으로 조회 함수
	
	// DB에 저장된 암호화된 비밀번호 와 비교함수
	// 첫번쨰 매개변수: 데이터베이스에 저장된 사용자 객체
	//          비밀번호는 이미 암호화!
	public boolean checkPassword(Users user,String loginPassword) {
		
		// 로그인 할 때 입력한 비밀번호를
		// 암호화하여 데이터베이스에 저장된 비밀번호
		// 를 비교해서 같으면 true,다르면 false
		return passwordEncoder.matches(loginPassword, user.getPassword());
	}
	
	// role을 조회하는 함수
	public boolean hasRole(String name,String role) {
		
		// 1. 사용자 정보를 가져오는 것
		Users user = userRepository.findByUsername(name);
		
		// 2. 해당 사용자의 역할 목록을 반복하면
		//    서 특정 역할이 있는지 확인
		for(Role r : user.getRoles()) {
			if(r.getRole().equals(role)) {
				return true;
			}
		}
		/*
		 *  자바 스트림 API
		 * 
		 * user.getRoles()
		 * 	   .strame()
		 *     .anyMatch(r->r.getRole().equals(role))
		 * 
		 */
		
		
		// 권한이 없으면 false반환
		return false;
	}
}
