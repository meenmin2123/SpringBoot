package com.ss.backend.google;

import com.ss.backend.entity.Role;
import com.ss.backend.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.*;

public class CustomOauth2User implements OAuth2User {

    private OAuth2User oauth2User;
    private Set<Role> roles;

    public CustomOauth2User(OAuth2User oAuth, Set<Role> roles) {
        System.out.println("CustomOauth2User()");
        oauth2User = oAuth;
        this.roles = roles;
    }


    @Override
    public Map<String, Object> getAttributes() {
        return oauth2User.getAttributes();
//                Collections.singletonList( new SimpleGrantedAuthority("ROLE_USER"));;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 1. 먼저 권한 생성
        // 2. 세션에 저장될 수 있도록 객체를 생성
        Set<GrantedAuthority> authorities = new HashSet<>();

        for(Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    @Override
    public String getName() {
        return "";
    }

    // hashCode 및 equals 메서드 추가 (ID를 기준으로)
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return Objects.equals(id, user.getId());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
}
