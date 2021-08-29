package org.tampvn.hibernateEMP.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.tampvn.hibernateEMP.entity.Employee;

import java.sql.SQLOutput;

public class ReadEmployee {
    public static void main(String[] args) {
        //create factory session
        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Employee.class)
                                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();
        try{

             //create employee
            System.out.println("Creating employee...");
            Employee emp = new Employee("David", "Ti Em", "Tay Cu Nieng");

            //star transaction
            session.beginTransaction();

            //save employee
            System.out.println("saving employee...");
            session.save(emp);

            //commit transaction
            session.getTransaction().commit();
            //find out student's id: primary key
            System.out.println("Saved employee. Generated id: " + emp.getId());

            //start transaction
            session =factory.getCurrentSession();
            session.beginTransaction();

            //retreive employee by id: primary key
            System.out.println("Getting id: " + emp.getId());

            Employee myEmployee = session.get(Employee.class, emp.getId());

            System.out.println("Get complete " + myEmployee);

            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!!!");
        }
        finally {
            factory.close();
        }
    }
}
