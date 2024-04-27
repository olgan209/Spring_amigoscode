package com.example.spring.full.course.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void addNewStudent(Student student) throws IllegalStateException {
        Optional<Student> studentOptional = studentRepository.findByEmail(student.getEmail());
        if(studentOptional.isPresent()) {
            throw new IllegalStateException("This email taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        studentRepository.findById(studentId);{
            boolean exists = studentRepository.existsById(studentId);
            if(!exists) {
                throw new IllegalStateException("This student does not exist" + studentId);
            }
            studentRepository.deleteById(studentId);
        }
    }
}
