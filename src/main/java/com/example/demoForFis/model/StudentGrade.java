package com.example.demoForFis.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * oraz ich ocen (nazwa przedmiotu, ocena).
 */
@Entity
@Table(name = "student_grades")
public class StudentGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @NotNull
    Float grade;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "student_id", nullable = false)
    @JsonIgnore
    Student student;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
