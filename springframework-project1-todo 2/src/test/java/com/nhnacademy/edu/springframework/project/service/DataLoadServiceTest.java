package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.CsvScores;
import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Scores;
import com.nhnacademy.edu.springframework.project.repository.Students;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataLoadServiceTest {

    @Test
    void loadAndMerge() {
        Students csvStudents = CsvStudents.getInstance();
        Scores csvScore = CsvScores.getInstance();

        csvScore.load();
        csvStudents.load();

        csvStudents.merge(csvScore.findAll());
        Student student = (Student) csvStudents.findAll().toArray()[0];


        Assertions.assertThat(student.getScore().getScore()).isEqualTo(30);;
    }
}