package com.ss.backend.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3001") // 허용할 출처 설정
                .allowedMethods("GET", "POST", "PUT", "DELETE") // 허용할 HTTP 메서드
                .allowCredentials(true)//인증 정보 허용(쿠키 등)
                .allowedHeaders("*") //모든 헤더 허용
                .maxAge(3600);  // 캐시설정시간 설정
        //한시간동안은 어떤 요청CORS 설정 확인
        // 안하고 그대로 허용한다.
    }


}
