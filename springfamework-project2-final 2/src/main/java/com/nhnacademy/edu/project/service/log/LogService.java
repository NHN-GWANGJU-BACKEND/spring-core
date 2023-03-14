package com.nhnacademy.edu.project.service.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;


@Service
public class LogService {
    private static final Logger log = LoggerFactory.getLogger(LogService.class);
    public void info(String message){
        log.info(message);
    }
}
