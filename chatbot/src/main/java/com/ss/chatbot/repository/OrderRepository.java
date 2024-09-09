package com.ss.chatbot.repository;

import com.ss.chatbot.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
