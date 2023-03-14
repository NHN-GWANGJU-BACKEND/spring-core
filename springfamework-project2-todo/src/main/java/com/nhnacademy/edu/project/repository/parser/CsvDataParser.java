package com.nhnacademy.edu.project.repository.parser;

import com.nhnacademy.edu.project.repository.Bill;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

@Component
public class CsvDataParser implements DataParser {
    @Override
    public Collection<Bill> readFile() {  // csv 파일을 파싱하는 스프링빈 (인터페이스 포함)

        Collection<Bill> waterBill = new ArrayList<>();

        String root = System.getProperty("user.dir");
        String path = "/src/main/resources/Tariff_20220331.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(root + path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                waterBill.add(
                        new Bill(
                                values[1], values[2],Integer.parseInt(values[4]),
                                Integer.parseInt(values[5]), Integer.parseInt(values[6]))
                );
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return waterBill;
    }

}
