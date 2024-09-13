package com.ss.security.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Data
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int usersId;
    private String username;
    private String password;
    private String email;
    private String role;

    // 엔티티가 생성될 때마다 자동으로 현재 시간을 기록함.
    // 데이터베이스 생성(삽입)
    @CreationTimestamp
    private Timestamp createDate;

}
