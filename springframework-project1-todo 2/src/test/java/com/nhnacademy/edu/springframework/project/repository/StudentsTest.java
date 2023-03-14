package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.service.Student;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class StudentsTest {

    @Test
    void load() {
        Students csvStudents = CsvStudents.getInstance();

        csvStudents.load();
        Collection<Student> test = csvStudents.findAll();

        org.assertj.core.api.Assertions.assertThat(test.size()).isEqualTo(15);
    }

    @Test
    void findAll() {
        Students csvStudents = CsvStudents.getInstance();
        org.assertj.core.api.Assertions.assertThat(csvStudents.findAll()).isEmpty();
    }

    @Test
    void merge() {
        Students csvStudents = CsvStudents.getInstance();
        Scores csvScore = CsvScores.getInstance();

        csvScore.load();
        csvStudents.load();

        csvStudents.merge(csvScore.findAll());
        Student student = (Student) csvStudents.findAll().toArray()[0];


        Assertions.assertThat(student.getScore().getScore()).isEqualTo(30);
    }
}