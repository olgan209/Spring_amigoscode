package com.example.spring.full.course.student;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {
    public List<Student> getStudents(){
        return List.of(
                new Student(1L,
                        "Noa",
                        "noa@gmal.com",
                        LocalDate.of(2005, Month.JULY, 9),
                        18
                )
        );
    }
}
