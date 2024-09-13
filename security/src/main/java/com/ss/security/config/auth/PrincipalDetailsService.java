package com.ss.security.config.auth;

import com.ss.security.entity.Users;
import com.ss.security.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PrincipalDetailsService implements UserDetailsService {
    // UserDetailsService : 사용자 인증 정보 제공하는 인터페이스
    // - 사용자의 요청을 처리하기 위해서 데이터베이스에서 사용자의 정보를 가지고 오는 것

    @Autowired
    private UserRepository userRepository ;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username);

        // 데이터가 없을 경우
        if(user == null) {
            log.info(user + "는 없음.");
            return null;
        }
        // Spring Security에서 사용할 수 있는 UserDetails 객체로 변환.
        // 인증된 사용자 정보를 다루기 위해서 필요한 객체
        // - Spring Security가 사용자 정보에 접근할 수 있도록 함.
        return new PrincipalDetails(user);
    }
}
