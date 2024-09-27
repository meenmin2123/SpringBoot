package com.ss.backend.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(nullable = false)
    private String email;

    @NonNull
    @Column(nullable = false)
    private String name;

    @NonNull
    private String provider;    // 회사 명

    @NonNull
    private String providerId;

    // User 입장에서는 여러 개의 role를 가질 수 있음.
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<Role> role;

}
