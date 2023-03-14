package com.nhnacademy.edu.springframework.messagesender;

public class Main {
    public static void main(String[] args) {
        User user = new User("tagkdj1", "010-4358-0106");
//        new MessageSendService(new SmsMessageSender()).sendMessage(user, "message");
//        new MessageSendService(new EmailMessageSender()).sendMessage(user, "message");
    }

    boolean sendSmsMessage(User user, String message) {
        System.out.println("SMS Message Sent to " + user.getPhoneNumber() + " : " + message);
        return true;
    }

    boolean sendEmailMessage(User user, String message) {
        System.out.println("Email Message Sent to " + user.getEmail() + " : " + message);
        return true;
    }
}
