package org.tampvn.hibernateEMP.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.tampvn.hibernateEMP.entity.Employee;

public class CreateEmployee {
    public static void main(String[] args) {
        //Create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        //Create session
        Session session = factory.getCurrentSession();
        try {
                //Create 3 employee object
            System.out.println("Creating employee....");
            Employee emp1 = new Employee("Tam", "Pham", "Logitech");
            Employee emp2 = new Employee("Tonoy", "Tran", "Intel");
            Employee emp3 = new Employee("Dang", "Nguyen", "Riot");
            //Start transaction
            session.beginTransaction();

            //Save employee
            System.out.println("Saving employee...");
            session.save(emp1);
            session.save(emp2);
            session.save(emp3);

            //Commit transaction
            session.getTransaction().commit();
            System.out.println("Done!!!");
        }
        finally {
            factory.close();
        }
    }
}
