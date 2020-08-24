package com.example.demoForFis.service;

import com.example.demoForFis.model.Student;
import com.example.demoForFis.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;


@Service
public class StudentService {
    @Autowired
    StudentsRepository studentsRepository;


    public Student addStudent(Student student) {
        return studentsRepository.saveAndFlush(student);
    }

    public Student getStudent(Long id) {
        return studentsRepository.findById(id).orElse(null);
    }

    public List<Student> getStudents() {
        return studentsRepository.findAll();
    }

    public void deleteStudentById(Long id) {
        studentsRepository.deleteById(id);
    }

    /**
     * Dummy custom logic
     *
     * @return
     */
    public int calculateAddressLengthForStudent(Long id) {
        String address = studentsRepository.findById(id).orElse(null).getAddress();
        return isNull(address) ? 0 : address.length();
    }
}
