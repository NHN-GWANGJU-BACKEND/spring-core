package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.CsvScores;
import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Scores;
import com.nhnacademy.edu.springframework.project.repository.Students;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class DataLoadServiceTest {

    @InjectMocks
    private CsvScores csvScores;

    @InjectMocks
    private CsvStudents csvStudents;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void loadAndMerge() {
        csvScores.load();

        csvStudents.load();
        csvStudents.merge(csvScores.findAll());

        Student student = (Student) csvStudents.findAll().toArray()[0];

        Assertions.assertThat(student.getScore().getScore()).isEqualTo(30);
    }
}