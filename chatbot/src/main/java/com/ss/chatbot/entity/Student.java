package com.ss.chatbot.entity;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // 테이블 조인
    // - 학생 테이블에서 외래키로 school_id가 추가됨.
    // - school_id 컬럼명에 School 대표값(기본 키)
    @JoinColumn(name="school_id")
    @ManyToOne(fetch = FetchType.LAZY) // 또는 @OneToOne
    private School school;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="passport_id")
    private Passport passport;

}
