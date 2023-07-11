package com;

 

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

 
public class App {

    public static void main(String[] args) {

        ApplicationContext con = new ClassPathXmlApplicationContext("applicationContext.xml");

 

        Employee e = (Employee)con.getBean("employee");

        System.out.println(e);

    }

}