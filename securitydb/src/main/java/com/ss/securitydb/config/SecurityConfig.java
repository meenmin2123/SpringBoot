package com.ss.securitydb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()               // CSRF 보호 비활성화
                   .authorizeRequests()     // 권한 설정
                   .antMatchers("/security/admin").hasRole("ADMIN")     // 관리자 페이지 권한 부여
                   .antMatchers("/security/user").hasAnyRole("USER", "ADMIN")   // user 페이지는 user, admin 둘 다 접근 가능.
                   .antMatchers("/login","/security","/join").permitAll()        // 특정 url은 누구나 접근 가능
                   .antMatchers("/h2-console/**").permitAll()
                   .anyRequest().authenticated()
                   .and()
                   .formLogin().loginPage("/login")    // 로그인 페이지 경로 설정
                   .loginProcessingUrl("/loginPro")   // 로그인 페이지 처리하는 경로 설정
                   .successHandler(successHandler())   // 로그인 성공 시 실행할 문장
                   .permitAll()
                   .and()
                   .logout().logoutUrl("/logout")
                   .logoutSuccessUrl("/security/admin")    // 로그아웃 성공 시 이동할 경로
                   .permitAll();

        return http.build();
    }

    // 로그인 성공 시 역할에 따라 다른 페이지로 리다이렉트 이동하는 로직
    @Bean
    public AuthenticationSuccessHandler successHandler() {
        // AuthenticationSuccessHandler : 인증 성공 시 호출되는 핸들러

        return new AuthenticationSuccessHandler() {
            // 요청이 성공적으로 인증되었을 때 실행되는 코드

            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                // 사용자 권한을 확인하여 역할에 따라 리다이렉트

                // 1. 사용자 권한을 확인하여 역할에 따라 리다이렉트할 URL을 결정
                String redirectUrl;
                if (authentication.getAuthorities().stream().anyMatch(g -> g.getAuthority().equals("ROLE_ADMIN"))) {
                    redirectUrl = "/security/admin";
                } else {
                    redirectUrl = "/security/user";
                }
                response.sendRedirect(redirectUrl);
            }
        };
    }

/*
    * 실행 순서
    1. 로그인 페이지 접속
    2. 로그인 처리 loginpro spring security
    3. 로그인 성공 시, successHandler()
    4. 로그아웃
 */
}
