package com.ss.facebook.service;

import com.ss.facebook.entity.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CustomOauth2User implements OAuth2User {

    private OAuth2User oauth2User;
    private Set<Role> roles;

    public CustomOauth2User(OAuth2User oauth2User, Set<Role> roles) {
        this.oauth2User = oauth2User;
        this.roles = roles;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return Map.of();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getName() {
        return "";
    }
}
