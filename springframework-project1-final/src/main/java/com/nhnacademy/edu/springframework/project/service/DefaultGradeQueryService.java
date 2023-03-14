package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.annotation.Logging;
import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Score;
import com.nhnacademy.edu.springframework.project.repository.Students;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class DefaultGradeQueryService implements GradeQueryService {

    private Students students;

    public DefaultGradeQueryService(CsvStudents csvStudents){
        this.students = csvStudents;
    }

    @Override
    @Logging
    public List<Score> getScoreByStudentName(String name) {
        // TODO 5: 학생 이름으로 점수를 반환합니다. 동명이인 고려합니다.
        List<Score> result = new ArrayList<>();

        students.findAll().stream()
                .filter(student -> student.getName().equals(name))
                .forEach(student -> result.add(student.getScore()));

        return result;
    }


    @Override
    @Logging
    public Score getScoreByStudentSeq(int seq) {
        // TODO 6 : 학번으로 점수를 반환합니다. seq 인자가 학번입니다.

        return students.findAll().stream()
                .filter(student -> student.getSeq() == seq)
                .findAny().get().getScore();
    }
}
