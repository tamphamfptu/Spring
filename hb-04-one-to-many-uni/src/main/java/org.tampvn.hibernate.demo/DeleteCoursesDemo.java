package org.tampvn.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.tampvn.hibernate.entity.Course;
import org.tampvn.hibernate.entity.Instructor;
import org.tampvn.hibernate.entity.InstructorDetail;


public class DeleteCoursesDemo {
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

            // get a course
            int theId = 10;
            Course tempCourse = session.get(Course.class, theId);

            // delete course
            System.out.println("Deleting course: " + tempCourse);
            session.delete(tempCourse);

            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!!");
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
