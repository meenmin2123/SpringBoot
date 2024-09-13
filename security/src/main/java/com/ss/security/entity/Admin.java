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
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int adminId;
    private String name;
    private String password;
    private String email;

    private String adminLevel; // 관리자의 수준 (예: SUPER, MODERATOR 등)
    private String department;

    @CreationTimestamp
    private Timestamp createDate;
}
