package com.ss.backend.security;

import com.ss.backend.entity.Member;
import com.ss.backend.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MemberDetailService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("loadUser : " + email);

        Member member = memberRepository.findByEmail(email);
        System.out.println("member : " + member);

        if(member != null) {
            return new MemberDetails(member);
        }

        return null;
    }
}
