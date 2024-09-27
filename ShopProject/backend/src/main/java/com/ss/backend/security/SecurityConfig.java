package com.ss.backend.security;

import com.ss.backend.google.CustomOauth2UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomOauth2UserService customOauth2UserService;

    public SecurityConfig(CustomOauth2UserService custOauthService) {
        System.out.println("생성자 Oauth2");
        this.customOauth2UserService = custOauthService;
    }

    @Bean
    public SecurityFilterChain fillter(HttpSecurity http) throws Exception {

        http.csrf().disable() // CSRF 보호 비활성화
                   .cors().and()     // CORS허용
                  .authorizeHttpRequests()
                  .antMatchers("/products/login", "/products/register","/login","/google/**").permitAll()
                  .anyRequest().authenticated()
                  .and().oauth2Login().loginPage("/login") // google, fackbook, github 등 OAuth2
                  .userInfoEndpoint() //로그인한 사용자의 정보(이메일, 이름 등)을 받아올 준비
                .userService(customOauth2UserService)
                .and().successHandler(successHandler())
                .failureHandler(failureHandler());

        return http.build();
    }

    //실패시!
    private AuthenticationFailureHandler failureHandler() {
        return (request, response, exception) -> {
            // 로그인 실패 후 "/login-failure"로 리다이렉트
            response.sendRedirect("/login-failure");
        };
    }

    //성공시
    private AuthenticationSuccessHandler successHandler() {
        return (request, response, authentication) -> {
            // 로그인 성공 후 "/login-success"로 리다이렉트
            response.sendRedirect("/login-success");
        };
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
