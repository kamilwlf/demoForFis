package com.example.demoForFis.repository;

import com.example.demoForFis.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<Student, Long> {
}
