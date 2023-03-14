package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.service.Student;
import org.junit.jupiter.api.Test;

import java.util.Collection;


class ScoresTest {

    @Test
    void load() {
        Scores csvScore = CsvScores.getInstance();

        csvScore.load();
        Collection<Score> test = csvScore.findAll();

        org.assertj.core.api.Assertions.assertThat(test.size()).isEqualTo(15);
    }

    @Test
    void findAll() {
        Scores csvScore = CsvScores.getInstance();
        org.assertj.core.api.Assertions.assertThat(csvScore.findAll().contains(new Score(1,30))).isFalse();
    }
}