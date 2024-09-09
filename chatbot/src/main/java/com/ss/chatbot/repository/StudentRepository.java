package com.ss.chatbot.repository;

import com.ss.chatbot.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
