package com.example.spring.full.course.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    //will have all our resources for our API

    @GetMapping
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
