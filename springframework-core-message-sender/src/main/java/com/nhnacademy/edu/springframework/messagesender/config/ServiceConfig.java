package com.nhnacademy.edu.springframework.messagesender.config;

import com.nhnacademy.edu.springframework.messagesender.MessageSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
    @Autowired
    MainConfig mainConfig;

    @Bean
    public MessageSendService messageSendService() {
        return new MessageSendService(mainConfig.smsMessageSender());
    }
}
