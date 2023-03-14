package com.nhnacademy.edu.project.service;

import com.nhnacademy.edu.project.repository.Bill;

import java.util.List;

public interface IReportResult {
    public boolean showResult(List<Bill> waterBill);
}
