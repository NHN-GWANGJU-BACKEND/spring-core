package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GradeQueryServiceTest {

    @Test
    void getScoreByStudentName() {
        Students csvStudents = CsvStudents.getInstance();
        Scores csvScore = CsvScores.getInstance();

        csvScore.load();
        csvStudents.load();

        csvStudents.merge(csvScore.findAll());

        DefaultGradeQueryService studentService = new DefaultGradeQueryService();
        List<Score> students = studentService.getScoreByStudentName("A");

        org.assertj.core.api.Assertions.assertThat(students.size()).isPositive();
    }

    @Test
    void getScoreByStudentSeq() {
        Students csvStudents = CsvStudents.getInstance();
        Scores csvScore = CsvScores.getInstance();

        csvScore.load();
        csvStudents.load();

        csvStudents.merge(csvScore.findAll());

        DefaultGradeQueryService studentService = new DefaultGradeQueryService();
        Score studentScore = studentService.getScoreByStudentSeq(1);

        org.assertj.core.api.Assertions.assertThat(studentScore.getScore()).isPositive();
    }
}