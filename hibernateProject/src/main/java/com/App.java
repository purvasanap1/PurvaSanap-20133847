package com;

 

import org.hibernate.Session;

import org.hibernate.SessionFactory;

import org.hibernate.Transaction;

import org.hibernate.cfg.Configuration;

 

import java.util.Scanner;

 

public class App {

 

    public static void main(String[] args) {

      

        Configuration cfg = new Configuration();

        cfg.configure("hibernate.cfg.xml");

 

        SessionFactory factory = cfg.buildSessionFactory();

 

        Session session = factory.openSession();

 

        Transaction tx = session.beginTransaction();

 

        Customer cus = new Customer();

 

        Scanner scanner = new Scanner(System.in);

        


        System.out.println("Enter Name: ");

        String name = scanner.next();

        cus.setName(name);

 

        System.out.println("Enter Place: ");

        String place = scanner.next();

        cus.setPlace(place);

        
        System.out.println("Enter Pan: ");

        String pan = scanner.next();

        cus.setPan(pan);
 

        session.save(cus);

        tx.commit();

 

        System.out.println("Data inserted successfully");

    }

 

}
