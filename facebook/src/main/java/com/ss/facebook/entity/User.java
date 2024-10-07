package com.ss.facebook.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode(of="id")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @NonNull
    @Column(nullable = false)
    private String email;

    @NonNull
    private String provider; // 회사명
    @NonNull
    private String providerId; // 회사명 기준으로 고유한 id

    // 양방향 매핑
    @OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL)
    private Set<Role> roles;


}
