package com.ss.backend.entity;

import lombok.*;
import com.ss.backend.entity.User;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(of = "id")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;    // 권한 이름 role_user

    // LAZY : 데이터베이스 호출을 필요할 때만 호출
    // EAGER : 즉시 데이터를 불러오는 방식
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id") // 외래키를 이용해서 User와
    @ToString.Exclude   // 순환 참조 방지
    private User user;



}
