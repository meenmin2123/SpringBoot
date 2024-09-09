package com.ss.chatbot.repository;

import com.ss.chatbot.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Long> {
}
