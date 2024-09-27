package com.ss.backend.google;

import com.ss.backend.entity.Role;
import com.ss.backend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

// DefaultOAuth2UserService : 스프링 시큐리티에서 제공하는 클래스
// OAuth2 인증 절차 사용자 정보를 가져오는 역할.
// 엑세스 토큰을 사용해서 정보를 가져오는 기능이 있음.



@Service
public class CustomOauth2UserService extends DefaultOAuth2UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2User oAuth2User = super.loadUser(userRequest);

        System.out.println(oAuth2User.getName());
        System.out.println(oAuth2User.getAttributes());
        System.out.println(oAuth2User.getName());

        // Google에서 반환된 사용자 정보를 출력
        String email = oAuth2User.getAttribute("email");
        String name = oAuth2User.getAttribute("name");
        String id = oAuth2User.getAttribute("id");

        System.out.println(email);
        System.out.println(name);
        System.out.println(id);

        // 사용자 정보가 DB에 있는지 확인
        User usertemp = userRepository.findByEmail(email);

        User user = null;
        Set<Role> roles = new HashSet<Role>();

        if (usertemp == null) {
            String provider = userRequest.getClientRegistration().getRegistrationId();
            System.out.println(provider);

            String providerId = provider + "_" + id;

            // 새 유저 등록
            user = new User(email, name, provider, providerId);

            // 기본 권한 설정
            Role userRole = new Role();
            userRole.setName("ROLE_USER");
            userRole.setUser(user);

            // 유저 권한을 새로 등록하는 사용자의 정보에 새로운 권한 정보를 넣어줌.
            user.setRole(Set.of(userRole));

            userRepository.save(user);

            // 새로 저장된 사용자의 권한 추가
            roles.add(userRole);

        } else {
            // 정보가 있음 -> 로그인
            // 권한 정보 반환
            roles = usertemp.getRole();

        }

        // 위에 생성한 사용자 정보랑 권한을 넘겨줌.
        // 시큐리티 세션에 저장하기 위해서 밑에 클래스 만듦.
        return new CustomOauth2User(oAuth2User,roles);
    }
}


