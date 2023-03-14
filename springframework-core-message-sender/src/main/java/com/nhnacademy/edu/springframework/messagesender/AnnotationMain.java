package com.nhnacademy.edu.springframework.messagesender;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationMain {
    public static void main(String[] args) {
//        User user = new User("tagkdj1@naver.com", "010-4358-0106");
        String baseLine = "com.nhnacademy.edu.springframework";

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(baseLine);

        MessageSendService mss = context.getBean("messageSendService",MessageSendService.class);
        mss.sendMessage("임태원");
    }
}