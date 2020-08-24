package com.example.demoForFis.controller;

import com.example.demoForFis.model.Student;
import com.example.demoForFis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * metody zapisujące dane oraz odczytujące dane ucznia powinny być
 * wystawione również jako API Rest’owe pod adresem /student.
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("")
    ResponseEntity<Student> addStudent(@Valid @RequestBody Student student) {
        Student created = studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(created);
    }

    @GetMapping("")
    List<Student> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/{id}")
    Student getStudent(@PathVariable("id") Long id) {
        return studentService.getStudent(id);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
