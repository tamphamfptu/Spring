package org.tampvn.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.tampvn.hibernate.entity.Student;

public class CreateStudentDemo {
    public static void main(String[] args) {
        //create session Factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();
        try{
            //create a student object
            System.out.println("Createing new student object...");
            Student tempStudent = new Student("Tam", "Pham", "abc123@gmail.com");

            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the student....");
            session.save(tempStudent);
            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!!");
        }
        finally{
            factory.close();
        }
    }

}
