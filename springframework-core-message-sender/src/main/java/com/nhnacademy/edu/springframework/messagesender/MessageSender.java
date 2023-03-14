package com.nhnacademy.edu.springframework.messagesender;

public interface MessageSender {
    boolean sendMessage(User user, String message);
}
