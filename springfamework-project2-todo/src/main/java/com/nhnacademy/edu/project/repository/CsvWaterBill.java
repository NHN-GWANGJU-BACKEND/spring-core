package com.nhnacademy.edu.project.repository;

import com.nhnacademy.edu.project.repository.parser.DataParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CsvWaterBill implements WaterBill {
    Collection<Bill> waterBill;
    DataParser csvDataParser;

    public CsvWaterBill() {
        this.waterBill = new ArrayList<>();
    }

    @Autowired
    public void setCsvDataParser(DataParser csvDataParser) {
        this.csvDataParser = csvDataParser;
    }

    @Override
    public List<Bill> findTicketByUsage(long usage) {
        return waterBill.stream().filter(bill -> bill.getSectionEnd() >= usage &&
                usage >= bill.getSectionStart()).collect(Collectors.toList());
    }

    @Override
    public boolean load() {
        this.waterBill = csvDataParser.readFile();
        return true;
    }
}
