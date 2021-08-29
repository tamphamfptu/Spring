package org.tampvn.hibernateEMP.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.tampvn.hibernateEMP.entity.Employee;

public class DeleteEmployee {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try{
            int empId = 2;
            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Deleting employee: " + empId);
            session.createQuery("delete from Employee where id=2").executeUpdate();

            session.getTransaction().commit();
            System.out.println("Done!!!");
        }
        finally{
            factory.close();
        }
    }

}

