package com.ss.facebook.security;

import com.ss.facebook.service.CustomOauth2UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Slf4j
@Configuration
public class SecurityConfig {
    
    private final CustomOauth2UserService customService;
    
    public SecurityConfig(CustomOauth2UserService cu) {
        log.info("SecurityConfig 생성자 실행");
        this.customService = cu;
    }

    // 시큐리티 보안 설정 후 SecurityFilterChain타입으로 객체 생성
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().and().authorizeRequests()
                .antMatchers("/index").permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login().loginPage("/index").permitAll()
                .userInfoEndpoint() //로그인한 사용자의 정보
                .userService(customService);

        return http.build();
    }

}
