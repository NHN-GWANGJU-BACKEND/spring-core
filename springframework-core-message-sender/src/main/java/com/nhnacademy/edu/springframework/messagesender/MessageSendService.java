package com.nhnacademy.edu.springframework.messagesender;

import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;
import com.nhnacademy.edu.springframework.messagesender.annotation.Logging;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@PropertySource("classpath:send.properties")
@Component
public class MessageSendService{
    @Value("${from}")
    private String name;
    @Value("${hookUrl}")
    private String hookUrl;
    private MessageSender messageSender;

    public MessageSendService() {
    }

    public MessageSendService(@Qualifier("smsMessageSender") MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void setMessageSender(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public boolean sendMessage(User user, String message) {
        new DoorayHookSender(new RestTemplate(), hookUrl)
                .send(DoorayHook.builder()
                        .botName("임태원")
                        .text("화이팅")
                        .build());
        return messageSender.sendMessage(user, message);
    }
    @Logging
    public boolean sendMessage(String name){
        new DoorayHookSender(new RestTemplate(), hookUrl)
                .send(DoorayHook.builder()
                        .botName(name)
                        .text("화이팅")
                        .build());
        return messageSender.sendMessage(new User(name,"010-4358-0106"), "final training");
    }
}
