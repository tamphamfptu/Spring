package org.tampvn.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.tampvn.hibernate.entity.Student;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        //create session Factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();
        try{

            // start a transaction
            session.beginTransaction();
            // query student
            List<Student> theStudents = session.createQuery("from Student").getResultList();


            //display the students
            displayStudents(theStudents);

            //query students: lastName='Pham'
            theStudents = session.createQuery("from Student s where s.lastName='Pham'").getResultList();

            //display the student have last name 'Pham'
            System.out.println("\n\n Students who have last name of Pham");
            displayStudents(theStudents)  ;

            //query students: lastNam='Pham' or firstName='Tam'
            theStudents = session.createQuery("from Student s where "
                    + "s.lastName='Pham' OR s.firstName='Tam'").getResultList();
            System.out.println("\n\nStudents who have lastNam Pham or firstName Tam");
            displayStudents(theStudents);

            //query student where email like 'gmail.com'
            theStudents = session.createQuery("from Student s where "
                    + "s.email LIKE '%gmail.com'").getResultList();
            System.out.println("\n\nStudents who have email end with gmail.com ");
            displayStudents(theStudents);
            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!!");
        }
        finally{
            factory.close();
        }
    }

    private static void displayStudents(List<Student> theStudents) {
        for (Student tempStudent : theStudents){
            System.out.println(tempStudent);
        }
    }

}
