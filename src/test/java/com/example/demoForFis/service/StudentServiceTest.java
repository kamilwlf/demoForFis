package com.example.demoForFis.service;

import com.example.demoForFis.model.Student;
import com.example.demoForFis.repository.StudentsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static java.util.Optional.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    StudentsRepository studentsRepository;

    @InjectMocks
    StudentService studentService;



    @Test
    void calculateAddressLengthForStudentShouldReturnValeThree() {
        //given
        Student student = new Student();
        student.setAddress("abc");

        //when
        when(studentsRepository.findById(any())).thenReturn(of(student));
        int result = studentService.calculateAddressLengthForStudent(any());

        //then
        assertEquals(3, result);
    }

    @Test
    void calculateAddressLengthForStudentAsNull() {
        //given
        Student student = new Student();
        student.setAddress(null);

        //when
        when(studentsRepository.findById(any())).thenReturn(of(student));
        int result = studentService.calculateAddressLengthForStudent(any());

        //then
        assertEquals(0, result);
    }
}