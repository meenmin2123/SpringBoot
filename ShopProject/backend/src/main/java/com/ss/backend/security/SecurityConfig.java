package com.ss.backend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain fillter(HttpSecurity http) throws Exception {

        http.csrf().disable() // CSRF 보호 비활성화
                   .cors().and()     // CORS허용
                  .authorizeHttpRequests()
                  .antMatchers("/products/login", "/products/register").permitAll()
                  .anyRequest().authenticated();
        return http.build();
    }

    // 자격증명을 해주는 메서드
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        System.out.println("매니저 등록됨");
        
        return configuration.getAuthenticationManager(); // AuthenticationManager 빈 등록
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // 비밀번호 암호화 방식 설정
    }
}
