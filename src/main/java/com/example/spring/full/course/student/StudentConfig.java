package com.example.spring.full.course.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student noa = new Student(
                    1L,
                    "Noa",
                    "noa@gmail.com",
                    LocalDate.of(2005, Month.JULY, 9),
                    18
            );

            Student alex = new Student(
                    "Alex",
                    "alex@gmail.com",
                    LocalDate.of(2000, Month.JULY, 9),
                    18
            );
            repository.saveAll(
                    List.of(noa, alex)
            );
        };

    }
}
