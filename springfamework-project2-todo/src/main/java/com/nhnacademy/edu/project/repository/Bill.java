package com.nhnacademy.edu.project.repository;

import org.springframework.stereotype.Component;

import java.math.BigInteger;

public class Bill {
    private int sectionEnd,unitPrice,sectionStart;
    private String city,sectors;
    private BigInteger totalPrice;

    public Bill(String city, String sectors,int sectionStart, int sectionEnd, int unitPrice) {
        this.city = city;
        this.sectors = sectors;
        this.sectionEnd = sectionEnd;
        this.unitPrice = unitPrice;
        this.sectionStart=sectionStart;
    }
    public int getSectionEnd() {
        return sectionEnd;
    }

    public int getUnitPrice() {
        return unitPrice;
    }
    public BigInteger getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigInteger totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getSectionStart() {
        return sectionStart;
    }

    @Override
    public String toString() {
        return "WaterBill{" +
                "city=" + city +
                ", sector='" + sectors +
                ", unitPrice=" + unitPrice +
                ", totalPrice=" + totalPrice +
                '}'+'\n';
    }

}
