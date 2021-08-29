package com.tampvn.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
    public static void main(String[] args) {
        //load the Spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//retrieve bean from spring container
        Coach theCoach = context.getBean("myCoach", Coach.class);
//call methods in spring bean
        System.out.println(theCoach.getDailyWorkOut());
//close context
        context.close();
    }

}
