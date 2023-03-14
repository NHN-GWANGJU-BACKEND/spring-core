package com.nhnacademy.edu.springframework.project.repository;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collection;

class ScoresTest {

    @InjectMocks
    private CsvScores csvScores;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void load() {
        csvScores.load();
        Collection<Score> test = csvScores.findAll();

        org.assertj.core.api.Assertions.assertThat(test.size()).isEqualTo(15);
    }

    @Test
    void findAll() {
        org.assertj.core.api.Assertions.assertThat(csvScores.findAll()).isEmpty();
    }
}