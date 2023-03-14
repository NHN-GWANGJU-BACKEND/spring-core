package com.nhnacademy.edu.project.service;

import com.nhnacademy.edu.project.repository.Bill;

import java.util.List;

public interface IDefaultUsageWaterworks {
    public List<Bill> calculateUsagePrice(long usage);
}
