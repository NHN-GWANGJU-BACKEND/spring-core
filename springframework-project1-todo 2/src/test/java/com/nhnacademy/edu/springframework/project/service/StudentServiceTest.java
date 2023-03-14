package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.CsvScores;
import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Scores;
import com.nhnacademy.edu.springframework.project.repository.Students;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @Test
    void getPassedStudents() {
        Students csvStudents = CsvStudents.getInstance();
        Scores csvScore = CsvScores.getInstance();

        csvScore.load();
        csvStudents.load();

        csvStudents.merge(csvScore.findAll());

        DefaultStudentService studentService = new DefaultStudentService();
        Collection<Student> passedStudents = studentService.getPassedStudents();

        org.assertj.core.api.Assertions.assertThat(passedStudents).isNotEmpty();
    }

    @Test
    void getStudentsOrderByScore() {
        Students csvStudents = CsvStudents.getInstance();
        Scores csvScore = CsvScores.getInstance();

        csvScore.load();
        csvStudents.load();

        csvStudents.merge(csvScore.findAll());

        DefaultStudentService studentService = new DefaultStudentService();
        Collection<Student> orderedStudents = studentService.getStudentsOrderByScore();

        org.assertj.core.api.Assertions.assertThat(orderedStudents).isNotEmpty();

    }
}