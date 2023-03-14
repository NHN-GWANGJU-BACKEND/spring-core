package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.service.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class CsvStudents implements Students{
    private Collection<Student> studentList;

    public CsvStudents(){
        studentList = new ArrayList<>();
    }

    // TODO 7 : student.csv 파일에서 데이터를 읽어 클래스 멤버 변수에 추가하는 로직을 구현하세요.
    // 데이터를 적재하고 읽기 위해서, 적절한 자료구조를 사용하세요.

    @Override
    public void load() {
        String root = System.getProperty("user.dir");
        String path = "/src/main/resources/data/student.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(root+path))){
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                studentList.add(new Student(Integer.parseInt(values[0]),values[1]));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Collection<Student> findAll() {
        return studentList;
    }

    /**
     * TODO 8 : students 데이터에 score 정보를 추가하세요.
     * @param scores
     */
    @Override
    public void merge(Collection<Score> scores) {
        studentList.forEach(student ->
                student.setScore(scores.stream()
                        .filter(score -> student.getSeq() == score.getStudentSeq())
                        .findFirst().get()
                ));
    }
}
