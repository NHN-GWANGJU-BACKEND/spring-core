package com.nhnacademy.edu.springframework.project.config;

import com.nhnacademy.edu.springframework.project.repository.CsvScores;
import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class JavaConfig {
    @Bean
    public CsvStudents csvStudents(){
        return new CsvStudents();
    }

    @Bean
    public CsvScores csvScores(){
        return new CsvScores();
    }
}
