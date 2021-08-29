package org.tampvn.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.tampvn.hibernate.entity.Course;
import org.tampvn.hibernate.entity.Instructor;
import org.tampvn.hibernate.entity.InstructorDetail;


public class EagerLazyDemo {
    public static void main(String[] args) {
        //create session Factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();
        try{


            // start a transaction
            session.beginTransaction();

            //get the instructor from db
            int theId = 1;
            Instructor tempInstructor = session.get(Instructor.class, theId);

            System.out.println("Tamdeptrai: Instructor: " + tempInstructor);

            System.  out.println("Tamdeptrai: Courses: " + tempInstructor.getCourses());

            //commit transaction
            session.getTransaction().commit();
            //close the session
            session.close();

            System.out.println("\nThe session is now closed\n");
            //option 1: call getter method while session is open

            //since courses are lazy loaded ... this should fail

            System.out.println("Tamdeptrai: Done!!");
            // get courses for the instructor
            System.  out.println("Tamdeptrai: Courses: " + tempInstructor.getCourses());




        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally{
            //add clean up
            session.close();

            factory.close();
        }
    }

}
