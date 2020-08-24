package com.example.demoForFis.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * informacje na temat uczniów
 * (imię, nazwisko, klasa, adres zamieszkania, pesel, data urodzenia,
 * dysleksja (tak/nie)) oraz ich ocen (nazwa przedmiotu, ocena).
 */
@Entity
@Table(name = "students")
public class Student {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String firstName;

    @NotBlank
    @Column(nullable = false)
    private String secondName;

    private String className;
    private String address;
    private LocalDate dateOfBirth;
    private Boolean dyslexia;
    private Long pesel;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StudentGrade> studentGrades = new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        initializeAllNestedObjects();
    }

    @PreUpdate
    protected void onUpdate() {
        initializeAllNestedObjects();
    }

    public void initializeAllNestedObjects()
    {
        for (StudentGrade studentGrade : studentGrades) {
            if(Objects.isNull(studentGrade))
                studentGrade.setStudent(this);
        }
    }


    public void addStudent(StudentGrade studentGrade){
        studentGrade.setStudent(this);
        studentGrades.add(studentGrade);
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public List<StudentGrade> getStudentGrades() {
        return studentGrades;
    }

    public void setStudentGrades(List<StudentGrade> studentGrades) {
        this.studentGrades = studentGrades;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Boolean getDyslexia() {
        return dyslexia;
    }

    public void setDyslexia(Boolean dyslexia) {
        this.dyslexia = dyslexia;
    }



    public Long getPesel() {
        return pesel;
    }

    public void setPesel(Long pesel) {
        this.pesel = pesel;
    }


}
