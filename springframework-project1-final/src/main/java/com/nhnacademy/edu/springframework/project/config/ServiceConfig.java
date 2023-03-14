package com.nhnacademy.edu.springframework.project.config;

import com.nhnacademy.edu.springframework.project.service.CsvDataLoadService;
import com.nhnacademy.edu.springframework.project.service.DefaultGradeQueryService;
import com.nhnacademy.edu.springframework.project.service.DefaultStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@ComponentScan
@Configuration
public class ServiceConfig {
    @Autowired
    private JavaConfig javaConfig;

    @Bean
    public CsvDataLoadService csvDataLoadService(){
        return new CsvDataLoadService(javaConfig.csvStudents(),javaConfig.csvScores());
    }

    @Bean
    public DefaultGradeQueryService defaultGradeQueryService(){
        return new DefaultGradeQueryService(javaConfig.csvStudents());
    }

    @Bean
    public DefaultStudentService defaultStudentService(){
        return new DefaultStudentService(javaConfig.csvStudents());
    }
}
