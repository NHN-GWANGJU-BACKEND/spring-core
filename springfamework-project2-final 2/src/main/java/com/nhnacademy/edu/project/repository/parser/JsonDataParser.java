package com.nhnacademy.edu.project.repository.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.edu.project.repository.Bill;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;


@Component
public class JsonDataParser implements DataParser {

    private final ObjectMapper mapper = new ObjectMapper();
    private Collection<Bill> waterBill;
    private final String root = System.getProperty("user.dir");

    public JsonDataParser(){
        waterBill = new ArrayList<>();
    }
    @Override
    public Collection<Bill> readFile(String path) {
        try {
            Object[] test = mapper.readValue(new FileReader(root + path), Object[].class);
            ArrayList<String> arr;

            // 코드가 안좋은 것 같다.. 고쳐 볼 계획
            for (int i = 0; i < test.length; i++) {
                String[] list = test[i].toString().split(",");
                arr = new ArrayList();
                for (int j = 0; j < list.length; j++) {
                    if (j == 0 || j == 3 || j == 7) continue;
                    String value = list[j].split("=")[1];
                    arr.add(value);
                }
                waterBill.add(
                        new Bill(
                                arr.get(0), arr.get(1), Integer.parseInt(arr.get(2)),
                                Integer.parseInt(arr.get(3)), Integer.parseInt(arr.get(4)))
                );
            }
        } catch (IOException e) {
            System.out.println("jsonFileReader error occurred!");
        }
        return waterBill;
    }
}
