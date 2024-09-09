package com.ss.chatbot.entity;

import javax.persistence.*;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String product;

    @JoinColumn(name="customer_id")
    @ManyToOne // 또는 @OneToOne
    private Customer customer;
}
