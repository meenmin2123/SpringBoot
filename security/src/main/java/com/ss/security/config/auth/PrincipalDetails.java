package com.ss.security.config.auth;

// Authentication 객체에 저장할 수 있는 유일한 타입 생성

import com.ss.security.entity.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PrincipalDetails implements UserDetails {
    // UserDetails
    // - spring security에서 인증된 사용자의 정보를 나타내는 인터페이스
    // - 사용자 이름, 비밀번호, 권한, 계정 상태 등의 정보를 포함함.


    private Users user;

    // 생성자를 이용한 주입 방식
    public PrincipalDetails(Users user) {
        super();
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 사용자 권한을 처리할 때 호출되는 메서드
        // 사용자에게 부여된 권한(role/authorities) 목록을 반환  ex)ROLE_ADMIN, ROLE_USER ...
        // 권한들은 GrantedAuthority 인터페이스를 구현한 객체로 구성된 콜렉션 형태로 반환
        Collection<GrantedAuthority> collet = new ArrayList<GrantedAuthority>();
        collet.add(()->{return user.getRole();});

        return collet;
    }

    @Override
    public String getPassword() {

        // 인증 과정에서 비밀번호를 검증하기 위해서 실제 user 정보를 가져옴.
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        // 계정의 유효기간이 만료되었는지 확인
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // 계정이 잠겼는지 확인하는 메서드 - false(잠김) / true(잠기지 않음)
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // 사용자 인증 정보가 만료되었는지 확인
        return true;
    }

    @Override
    public boolean isEnabled() {
        // 인증이 가능한 상태(활성화)
        return true;
    }
}
