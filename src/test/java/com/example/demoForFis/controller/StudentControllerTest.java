package com.example.demoForFis.controller;

import com.example.demoForFis.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StudentControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void shouldCreateNewStudent() {
        //given
        Student given = new Student();
        given.setFirstName("first");
        given.setSecondName("second");
        given.setPesel(12345678912l);

        //when
        ResponseEntity<Student> result = testRestTemplate.
                postForEntity("/student", given, Student.class);

        //then
        assertEquals(given.getPesel(), result.getBody().getPesel());
    }
}