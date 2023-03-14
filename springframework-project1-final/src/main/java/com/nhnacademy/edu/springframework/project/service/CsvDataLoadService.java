package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.annotation.Logging;
import com.nhnacademy.edu.springframework.project.repository.CsvScores;
import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Scores;
import com.nhnacademy.edu.springframework.project.repository.Students;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class CsvDataLoadService implements DataLoadService {

    private Students students;
    private Scores scores;

    public CsvDataLoadService(CsvStudents csvStudents, CsvScores csvScores){
        this.students = csvStudents;
        this.scores = csvScores;
    }
    @Override
    @Logging
    public void loadAndMerge() {
        scores.load();

        students.load();
        students.merge(scores.findAll());
    }

}
