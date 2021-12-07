package com.test.staffcomtrue.email;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class EmailSend {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("Email Sending Started [" + new Date() + "]");
        EmailConfig ec = (EmailConfig) context.getBean("emailSend");
        ec.sendMail("HR", "This is the current staff list");
    }
}
