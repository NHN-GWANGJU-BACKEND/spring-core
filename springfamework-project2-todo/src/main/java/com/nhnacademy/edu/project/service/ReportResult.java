package com.nhnacademy.edu.project.service;

import com.nhnacademy.edu.project.repository.Bill;
import com.nhnacademy.edu.project.service.log.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportResult implements IReportResult{ //결과를 화면에 표시하는 스프링빈 (인터페이스 포함)
    LogService logService = new LogService();

    @Override
    public boolean showResult(List<Bill> waterBill) {
        System.out.println(waterBill);
        logService.info("\n"+waterBill.toString());
        return true;
    }
}
