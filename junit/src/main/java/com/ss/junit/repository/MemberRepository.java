package com.ss.junit.repository;

import com.ss.junit.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    void deleteById(Long id);
    List<Member> findAll();
    List<Member> findByName(String name);
}
