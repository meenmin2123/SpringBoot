package com.ss.securitydb.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class SecurityConfig {

	// 비밀번호 암호화 객체 등록
	@Bean
	public PasswordEncoder passwordEncode() {
		return new BCryptPasswordEncoder();
	}

	// 시큐리티 설정 객체를 등록!
	// 인증과 인가 설정
	// SecurityFilterChain
	// 스프링시큐리티에서 요청이 들어올 때
	// 어떻게 처리할 지 작성하는 필터 체인
	// filterChain 함수명
	// 매개변수 HttpSecurity 클래스
	// - 시큐리티 핵심 클래스
	// - 요청에 대한 인증,인가 보안 설정

	// 인증
	// - 사용자가 시스템에 접근 할 수있는 사용자인지
	// 확인 과정

	// 인가
	// - 인증된 사용자가 어떤 권한을 가지고 어떤
	// 작업을 할 수있는지 확인 과정
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.csrf().disable() // CSRF 보호 비활성화
				.authorizeRequests() // 권한 설정
				.antMatchers("/security/admin").hasRole("ADMIN") // 관리자 페이지는 ADMIN권한 필요
				.antMatchers("/security/user").hasAnyRole("USER", "ADMIN")// 유저페이지는 ADMIN또는 사용자 권한이 있으면 접근 가능
				.antMatchers("/login", "/join", "/security").permitAll() // 특정 url은 누구나 접근 가능
				.antMatchers("/h2-console/**").permitAll()
				.anyRequest().authenticated() // 인증된~사용자만
				.and()
					.formLogin()
					.loginPage("/login") // 로그인 페이지 경로설정
					.loginProcessingUrl("/loginPro") // 로그인 요청을 처리할 url설정
					.successHandler(successHandler()) // 로그인 성공시 실행할 문장
					.permitAll()

				.and().logout().logoutUrl("/logout").logoutSuccessUrl("/login").permitAll();

		return http.build();
	}
	// 실행 순서
	// 1. 로그인 페이지 접속
	// 2. 로그인 처리 loginpro spring security
	// 3. 로그인 성공시 successHandler()
	// 4. 로그아웃

	// 로그인 성공시 역할에 따라 다른 페이지로 리다이렉트
	// 이동하는 명령문 (로직)
	@Bean
	public AuthenticationSuccessHandler successHandler() {
	    return new AuthenticationSuccessHandler() {
	        @Override
	        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
	                Authentication authentication) throws IOException, ServletException {
	            // 사용자의 권한에 따라 다른 페이지로 리다이렉트
	            if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
	                response.sendRedirect("/security/admin");
	            } else {
	                response.sendRedirect("/security/user");
	            }
	        }
	    };
	}


}
