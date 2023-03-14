package com.nhnacademy.edu.project.repository;

import com.nhnacademy.edu.project.repository.parser.DataParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class FormatWaterBill implements WaterBill {
    Collection<Bill> waterBill;
    @Autowired //DataParser bean을 전부 불러와서 처리
    List<DataParser> dataParsers;

    public FormatWaterBill() {
        this.waterBill = new ArrayList<>();
    }

    public void setDataParsers(List<DataParser> dataParsers) {
        this.dataParsers = dataParsers;
    }

    public Collection<Bill> getWaterBill() {
        return waterBill;
    }

    @Override     // 사용량에 따른 요금표 가져오는 메소드
    public List<Bill> findTicketByUsage(long usage) {
        return waterBill.stream().filter(bill -> bill.getSectionEnd() >= usage &&
                usage >= bill.getSectionStart()).collect(Collectors.toList());
    }

    @Override // DataParser에서 csv,json으로 불러온 자료를 Collection<Bill> waterBill에 넣어주는 메소드
    public boolean load(String path,String format) {
        Optional<DataParser> dataParse = dataParsers.stream()
                .filter(dataParser -> dataParser.getClass().getSimpleName().toLowerCase().contains(format))
                .findFirst();

        if(waterBill.isEmpty()) {
            dataParse.ifPresent(dataParser -> this.waterBill = dataParser.readFile(path));
        }

        if(waterBill.isEmpty()) return false;
        else return true;
    }
}
