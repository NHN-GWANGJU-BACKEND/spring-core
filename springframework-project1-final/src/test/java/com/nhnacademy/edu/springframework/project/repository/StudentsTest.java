package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.service.Student;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collection;


class StudentsTest {

    @InjectMocks
    private CsvStudents csvStudents;

    @InjectMocks
    private CsvScores csvScores;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void load() {
        csvStudents.load();
        Collection<Student> test = csvStudents.findAll();

        org.assertj.core.api.Assertions.assertThat(test.size()).isEqualTo(15);
    }

    @Test
    void findAll() {
        org.assertj.core.api.Assertions.assertThat(csvStudents.findAll()).isEmpty();
    }

    @Test
    void merge() {
        csvScores.load();
        csvStudents.load();

        csvStudents.merge(csvScores.findAll());
        Student student = (Student) csvStudents.findAll().toArray()[0];


        Assertions.assertThat(student.getScore().getScore()).isEqualTo(30);
    }
}