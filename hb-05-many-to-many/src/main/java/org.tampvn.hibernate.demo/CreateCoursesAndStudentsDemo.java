package org.tampvn.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.tampvn.hibernate.entity.*;


public class CreateCoursesAndStudentsDemo {
    public static void main(String[] args) {
        //create session Factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();
        try{


            // start a transaction
            session.beginTransaction();

            //create a course
            Course tempCourse = new Course("Rapping 101");

            //Save the course
            System.out.println("Saving the course...");
            session.save(tempCourse);
            System.out.println("Saved the course: " + tempCourse);

            //create teh students
            Student tempStudent1 = new Student("Tam", "Pham", "acwuy00899@yahoo.com");
            Student tempStudent2 = new Student("Tonoy", "Tran", "prada@halo.com");

            //add student to the course
            System.out.println("Adding student to course...");
            tempCourse.addStudent(tempStudent1);
            tempCourse.addStudent(tempStudent2);

            //save the students
            System.out.println("\nSaving students...");
            session.save(tempStudent1);
            session.save(tempStudent2);
            System.out.println("Saved students: " + tempCourse.getStudents());
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
