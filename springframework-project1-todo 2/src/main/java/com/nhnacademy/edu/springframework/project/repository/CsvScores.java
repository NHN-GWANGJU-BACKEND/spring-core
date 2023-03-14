package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.service.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CsvScores implements Scores {

    private static final CsvScores csvScores = new CsvScores();
    private List<Score> scoreList; // csv파일에서 불러온 원본 점수리스트

    private CsvScores(){
        scoreList = new ArrayList<>();
    }

    /** TODO 2 :
     * Java Singleton 패턴으로 getInstance() 를 구현하세요.
     **/
    public static Scores getInstance() {
        return csvScores;
    }

    // TODO 5 : score.csv 파일에서 데이터를 읽어 멤버 변수에 추가하는 로직을 구현하세요.
    @Override
    public void load() {
        String root = System.getProperty("user.dir");
        String path = "/src/main/resources/data/score.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(root+path))){
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                scoreList.add(new Score(Integer.parseInt(values[0]),Integer.parseInt(values[1])));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Score> findAll() {
        return scoreList;
    }
}
