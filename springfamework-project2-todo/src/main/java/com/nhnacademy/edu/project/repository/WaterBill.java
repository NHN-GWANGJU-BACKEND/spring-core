package com.nhnacademy.edu.project.repository;

import java.util.Collection;
import java.util.List;

public interface WaterBill {
    public List<Bill> findTicketByUsage(long usage);
    public boolean load();
}
