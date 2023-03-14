package com.nhnacademy.edu.project.repository.parser;

import com.nhnacademy.edu.project.repository.Bill;
import java.util.Collection;

public interface DataParser {
    public Collection<Bill> readFile(String path);
}
