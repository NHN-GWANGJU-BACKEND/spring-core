package com.nhnacademy.edu.springframework.project;

import com.nhnacademy.edu.springframework.project.service.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Collection;

public class Main {

    // TODO 9 - 성공적으로 실행되어야 합니다.
    public static void main(String[] args) {
        String basePackage = "com.nhnacademy.edu.springframework.project";
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(basePackage);

        DataLoadService dataLoadService = context.getBean("csvDataLoadService",CsvDataLoadService.class);
        dataLoadService.loadAndMerge();

        DefaultStudentService studentService = context.getBean("defaultStudentService",DefaultStudentService.class);
        Collection<Student> passedStudents = studentService.getPassedStudents();
        System.out.println(passedStudents);

        Collection<Student> orderedStudents = studentService.getStudentsOrderByScore();
        System.out.println(orderedStudents);
    }
}
