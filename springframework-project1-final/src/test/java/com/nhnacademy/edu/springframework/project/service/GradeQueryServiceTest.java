package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.List;

class GradeQueryServiceTest {

    @InjectMocks
    private CsvScores csvScores;

    @InjectMocks
    private CsvStudents csvStudents;

    private DefaultGradeQueryService defaultGradeQueryService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        csvScores.load();
        csvStudents.load();

        csvStudents.merge(csvScores.findAll());

        defaultGradeQueryService = new DefaultGradeQueryService(csvStudents);
    }

    @Test
    void getScoreByStudentName() {
        List<Score> students = defaultGradeQueryService.getScoreByStudentName("A");
        org.assertj.core.api.Assertions.assertThat(students.size()).isPositive();
    }

    @Test
    void getScoreByStudentSeq() {
        Score studentScore = defaultGradeQueryService.getScoreByStudentSeq(1);
        org.assertj.core.api.Assertions.assertThat(studentScore.getScore()).isPositive();
    }
}