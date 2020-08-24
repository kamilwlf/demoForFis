package com.example.demoForFis.repository;

import com.example.demoForFis.model.StudentGrade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentGradesRepository extends JpaRepository<StudentGrade, Long> {
}
