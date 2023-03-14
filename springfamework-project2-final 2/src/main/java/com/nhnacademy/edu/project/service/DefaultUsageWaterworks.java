package com.nhnacademy.edu.project.service;

import com.nhnacademy.edu.project.repository.Bill;
import com.nhnacademy.edu.project.repository.FormatWaterBill;
import com.nhnacademy.edu.project.repository.WaterBill;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class DefaultUsageWaterworks implements IDefaultUsageWaterworks {
    //입력받은 사용량으로 요금표에서 구간을 찾아내고 요금을 계산해 주는 스프링빈
    private WaterBill csvWaterBill;
    public DefaultUsageWaterworks(FormatWaterBill formatWaterBill) {
        this.csvWaterBill = formatWaterBill;
    }

    public void setCsvWaterBill(WaterBill csvWaterBill) {
        this.csvWaterBill = csvWaterBill;
    }

    public List<Bill> calculateUsagePrice(long usage) { // 사용량에 적합한 자료를 불러오고 그 자료들의 totalPrice를 계산해주는 메소드
        List<Bill> ticketByUsage = csvWaterBill.findTicketByUsage(usage);
        ticketByUsage.stream()
                .forEach(bill -> bill.setTotalPrice(BigInteger.valueOf(bill.getUnitPrice() * usage)));
        ticketByUsage = ticketByUsage.stream().sorted(Comparator.comparing(Bill::getTotalPrice))
                .limit(5).collect(Collectors.toList());

        return ticketByUsage;
    }
}
