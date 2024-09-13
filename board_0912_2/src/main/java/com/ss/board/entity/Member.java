package com.ss.board.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NO", unique = true, nullable = false)
    private Integer no;

    @Column(name="ID", unique = true, nullable = false)
    private String id;

    @Column(name="PASSWORD")
    private String password;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String hobby;



}
