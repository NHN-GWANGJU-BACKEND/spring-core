package com.nhnacademy.edu.springframework.messagesender;

public class EmailMessageSender extends Main implements MessageSender {
    public EmailMessageSender() {
        System.out.println("EmailMessageSender initiated!");
    }

    public void destroy() {
        System.out.println("destroy method called in EmailMessageSender");
    }

    @Override
    public boolean sendMessage(User user, String message) {
       return sendEmailMessage(user, message);
    }
}
