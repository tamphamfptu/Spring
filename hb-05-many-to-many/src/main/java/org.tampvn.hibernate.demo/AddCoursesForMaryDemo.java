package org.tampvn.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.tampvn.hibernate.entity.*;


public class AddCoursesForMaryDemo {
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

            //get the student mary from database
            int studentId = 2;
            Student tempStudent = session.get(Student.class, studentId);

            System.out.println("\n Loaded student: " + tempStudent);
            System.out.println("Courses:" + tempStudent.getCourses());

            //create more courses
            Course tempCourse1 = new Course("Dancing 101");
            Course tempCourse2 = new Course("Vibing 101");

            //add student to courses
            tempCourse1.addStudent(tempStudent);
            tempCourse2.addStudent(tempStudent);

            //save the courses
            System.out.println("Saving the courses...");

            session.save(tempCourse1);
            session.save(tempCourse2);

            //commit the transaction
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
