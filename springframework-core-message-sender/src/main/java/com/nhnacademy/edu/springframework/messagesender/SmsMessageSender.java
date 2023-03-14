package com.nhnacademy.edu.springframework.messagesender;

public class SmsMessageSender extends Main implements MessageSender {
    public SmsMessageSender() {
        System.out.println("SmsMessageSender initiated!");
    }

    public void init() {
        System.out.println("init method called in SmsMessageSender");
    }

    public void destroy() {
        System.out.println("destroy method called in EmailMessageSender");
    }

    @Override
    public boolean sendMessage(User user, String message) {
        return sendSmsMessage(user, message);
    }
}
