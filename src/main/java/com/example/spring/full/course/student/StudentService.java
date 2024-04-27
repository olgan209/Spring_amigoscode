package com.example.spring.full.course.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<Student> getStudents(){
        return studentRepository.findAll(); //returns list to us
    }

    public void addNewStudent(Student student) throws IllegalAccessException {
        Optional<Student> studentOptional = studentRepository.findByEmail(student.getEmail());
        if(studentOptional.isPresent()) {
            throw new IllegalAccessException("email taken");
        }
        studentRepository.save(student);
    }
}
