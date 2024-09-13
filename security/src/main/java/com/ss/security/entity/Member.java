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
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int memId;

    private String password;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String kindOf;

    @CreationTimestamp
    private Timestamp registrationDate; // 회원가입 일자
}
