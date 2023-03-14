package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.CsvScores;
import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.Collection;


class StudentServiceTest {
    @InjectMocks
    private CsvScores csvScores;

    @InjectMocks
    private CsvStudents csvStudents;

    private DefaultStudentService defaultStudentService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        csvScores.load();
        csvStudents.load();

        csvStudents.merge(csvScores.findAll());

        defaultStudentService = new DefaultStudentService(csvStudents);
    }
    @Test
    void getPassedStudents() {
        Collection<Student> passedStudents = defaultStudentService.getPassedStudents();
        org.assertj.core.api.Assertions.assertThat(passedStudents).isNotEmpty();
    }

    @Test
    void getStudentsOrderByScore() {

        Collection<Student> orderedStudents = defaultStudentService.getStudentsOrderByScore();
        org.assertj.core.api.Assertions.assertThat(orderedStudents).isNotEmpty();
    }
}