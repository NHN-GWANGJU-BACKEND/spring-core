package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.annotation.Logging;
import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.StudentService;
import com.nhnacademy.edu.springframework.project.repository.Students;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

@Component
public class DefaultStudentService implements StudentService {

    private Students students;

    public DefaultStudentService(CsvStudents csvStudents){
        this.students = csvStudents;
    }
    @Override
    @Logging
    public Collection<Student> getPassedStudents() {
        // TODO 1 : pass한 학생만 반환하도록 수정하세요.
        // Student 는 Score 를 갖고 있고 Score 에는 pass 여부를 알수 있는 메서드가 있습니다
        // Java stream api 의 filter() 를 사용하여 필터링된 Student 객체를 리턴 하세요. (Students 와 Student 는 다릅니다.)

        return students.findAll().stream().
                filter(student -> !student.getScore().isFail())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    @Logging
    public Collection<Student> getStudentsOrderByScore() {
        return students.findAll().stream().
                sorted(Comparator.comparing(Student::getScore))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
