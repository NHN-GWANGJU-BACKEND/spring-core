package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Score;
import com.nhnacademy.edu.springframework.project.repository.Students;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DefaultGradeQueryService implements GradeQueryService {

    @Override
    public List<Score> getScoreByStudentName(String name) {
        // TODO 5: 학생 이름으로 점수를 반환합니다. 동명이인 고려합니다.

        Students studentRepository = CsvStudents.getInstance();

        List<Score> result = new ArrayList<>();

        studentRepository.findAll().stream()
                .filter(student -> student.getName().equals(name))
                .forEach(student -> result.add(student.getScore()));

        return result;
    }

    @Override
    public Score getScoreByStudentSeq(int seq) {
        // TODO 6 : 학번으로 점수를 반환합니다. seq 인자가 학번입니다.
        Students studentRepository = CsvStudents.getInstance();

        return studentRepository.findAll().stream()
                .filter(student -> student.getSeq() == seq)
                .findAny().get().getScore();
    }
}
