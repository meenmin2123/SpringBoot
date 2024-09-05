package com.ss.jpa.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@Data
@RequiredArgsConstructor
// @Table(name = "memberTable")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NonNull
    // name 필수, 최대 길이 : 100
    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    // @Column(속성 key = value)
    @Column(updatable = false)
    private LocalDateTime createAt;     // update sql 명령이 실행할 때 제외

    @Column(insertable = false)
    private LocalDateTime updateAt;     // insert sql 명령이 실행할 때 제외.

    // @Column(name = "create_content")
//    @Column
//    private String createContent;
//
//    @Column(name="nick",nullable = false,length = 100,unique = true)
//    private String nickname;


}
