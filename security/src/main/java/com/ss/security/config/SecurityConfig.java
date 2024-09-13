package com.ss.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // Spring Security를 이용해서 로그인 입력할 때에는 우리가 가입한 비밀번호를 넣으면 됨.
    // 비밀번호를 암호화하는 설정

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        // 비밀번호 암호화를 위한 설정
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityfilterchain(HttpSecurity http) throws Exception {
        // 회원가입, 로그인과 관련없는 경로는 인증 없이 접근할 수 있도록 설정
        http.csrf().disable().authorizeRequests().antMatchers("/user/**").authenticated()
                   .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                   .antMatchers("/manager/**").access("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
                   .anyRequest().permitAll()
                   .and()
                   .formLogin()             // 로그인 폼을 설정하는 것!
                   .loginPage("/login")     // 내가 만든 로그인 페이지로 이동 페이지명
                   .defaultSuccessUrl("/")  // 로그인 성공시 이동할 경로
                   .permitAll()
                   .and()
                   .logout() 
                   .logoutUrl("/login")    // 로그아웃 시, url 설정
                   .logoutSuccessUrl("/")  // 로그아웃 성공 시 이동할 페이지 url 설정
                   .permitAll();

        // 로그인 성공시 이동할 경로
        return http.build();
    }

    // - hasRole() : 특정 경로에 대해 사용자 권한을 확인하고 조건에 맞는 사용자만 접근을 할 수 있도록 설정

}
/*
// [기본으로 설정한 메서드]
// HttpSecurity Http 요청에 대한 보안 설정
// - http.csrf().disable() : 공격을 방지하는 보안 기능 비활성화(disable())
// - authorizeRequests() : 각 경로에 대한 권한 설정
// - antMatchers() : 특정 url에 대한 접근 권한을 설정
@Bean
public SecurityFilterChain securityfilterchain(HttpSecurity http) throws Exception {
    // 회원가입, 로그인과 관련없는 경로는 인증 없이 접근할 수 있도록 설정
    http.csrf().disable().authorizeRequests().antMatchers("/join", "/joinPro").permitAll()
            .antMatchers("/user", "/admin", "/manager").authenticated()
            .anyRequest().permitAll()
            .and().formLogin().loginPage("/login")      // 내가 만든 로그인 페이지(페이지명)(으)로 이동
            .defaultSuccessUrl("/index").permitAll();   // 로그인 성공시 이동할 경로
    return http.build();
}

// - loginPage("경로") : 경로에 있는 로그인 페이지로 리다이렉트하여 로그인 처리를 할 수 있도록 설정.
// - defaultSuccessUrl() : 성공 시 리다이렉트할 경로 설정!
*/
