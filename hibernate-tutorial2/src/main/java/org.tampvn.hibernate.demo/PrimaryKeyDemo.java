package org.tampvn.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.tampvn.hibernate.entity.Student;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        //create session Factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
//create session
        Session session = factory.getCurrentSession();
        try{
            //create 3 student objects
            System.out.println("Createing new 3 student objects ...");
            Student tempStudent1 = new Student("Tam", "Pham", "abc123@gmail.com");
            Student tempStudent2 = new Student("Tonoy", "Pham", "abc345@gmail.com");
            Student tempStudent3 = new Student("Lee", "Qy", "abc678@gmail.com");

                    // start a transaction
                    session.beginTransaction();

            // save the student object
            System.out.println("Saving the student....");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);
            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!!");
        }
        finally{
            factory.close();
        }
    }
}
