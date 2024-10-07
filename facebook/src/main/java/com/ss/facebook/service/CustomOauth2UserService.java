package com.ss.facebook.service;

import com.ss.facebook.entity.Role;
import com.ss.facebook.entity.User;
import com.ss.facebook.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class CustomOauth2UserService extends DefaultOAuth2UserService {

    @Autowired
    private UserRepository userResp;

    // Oauth2 로그인 요청이 들어왔을 때 사용자의 인정 정보를 가져오는 역할
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        log.info("loadUser 실행");    // aop 변경

        OAuth2User oauth = super.loadUser(userRequest);

        String email = oauth.getAttribute("email");

        // 회사 정보를 출력하기
        String provider = userRequest.getClientRegistration().getRegistrationId();
        System.out.println("회사명 : " + provider);
        System.out.println("userRequest : " + oauth);
        System.out.println("id : " + oauth.getAttribute("id"));
        System.out.println("email : " + email);

        // 사용자 정보가 db에 있는지 확인
        User temp = userResp.findByEmail(email);

        Set<Role> roles = new HashSet<Role>();

        // 사용자 정보와 권한을 저장
        return new CustomOauth2User(oauth, roles);
    }
}


