package com.ss.chatbot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // 여러 학생들이 속한 리스트
    @OneToMany(mappedBy = "school" ,cascade = CascadeType.ALL)

    private List<Student> students;

    // 서버 설정하는 파일
    // spring.jpa.hibernate.ddl-auto=update
    // JPA가 자동으로 테이블을 생성할 수 있도록
    // 업데이트 속성을 지정을 하면 된다.
    // 기존 테이블은 그대로 두고 , 새로운 ,변경된
    // 엔티티가 있으면 테이블을 업데이트 한다.

    // create 속성
    //  - 애플리케이션이 실행할 때마다 기존
    //   테이블을 삭제하고 새로운 테이블을 생성
    //   한다.
    //   기존 모든 데이터가 삭제된다.

    // validate 속성
    //  테이블이 엔티티클래스와 일치하는지 확인
    //  일치하지 않으면 오류가 발생,
    //  새로운 테이블이나 필드를 생성하지 않는다.


}
