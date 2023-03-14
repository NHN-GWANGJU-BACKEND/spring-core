package com.nhnacademy.edu.project.repository.parser;

import com.nhnacademy.edu.project.repository.Bill;

import java.util.Collection;
import java.util.List;

public interface DataParser {
    public Collection<Bill> readFile();
}
