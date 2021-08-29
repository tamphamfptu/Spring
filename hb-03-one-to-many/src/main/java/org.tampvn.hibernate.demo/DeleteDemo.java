package org.tampvn.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.tampvn.hibernate.entity.Instructor;
import org.tampvn.hibernate.entity.InstructorDetail;


public class DeleteDemo {
    public static void main(String[] args) {
        //create session Factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();
        try{
            // start a transaction
            session.beginTransaction();

            //get instructor by primary key / id
            int theId = 1;
            Instructor tempInstructor = session.get(Instructor.class, theId);
            System.out.println("Found instructor:" + tempInstructor);

            //delete the instructor
            if(tempInstructor != null){
                System.out.println("Deleting: " + tempInstructor);
                //Note will ASLO delete associate "details" object
                //because of CascadeType.ALL
                //
                session.delete(tempInstructor);
            }

            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!!");
        }
        finally{
            factory.close();
        }
    }

}
