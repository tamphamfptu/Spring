package org.tampvn.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.tampvn.hibernate.entity.Course;
import org.tampvn.hibernate.entity.Instructor;
import org.tampvn.hibernate.entity.InstructorDetail;
import org.tampvn.hibernate.entity.Review;


public class CreateCoursesAndReviewsDemo {
    public static void main(String[] args) {
        //create session Factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();
        try{


            // start a transaction
            session.beginTransaction();

           //create a course
            Course tempCourse = new Course("How to being kill");

            //add some reviews
            tempCourse.addReview(new Review("it's so cool"));
            tempCourse.addReview(new Review("Awesomeeee!!!"));
            tempCourse.addReview(new Review("Hell yehh"));

            //save the course ... and leverage the cascade all :-)
            System.out.println("saving the course");
            System.out.println(tempCourse);
            System.out.println(tempCourse.getReviews());

            session.save(tempCourse);
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
