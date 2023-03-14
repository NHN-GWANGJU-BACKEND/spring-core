package com.nhnacademy.edu.springframework.project.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CsvScores implements Scores {
    private static final CsvScores csvScores = new CsvScores();
    private List<Score> scoreList;

    public CsvScores(){
        scoreList = new ArrayList<>();
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
