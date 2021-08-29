package org.tampvn.hibernateEMP.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.tampvn.hibernateEMP.entity.Employee;

public class UpdateEmployee {
    public static void main(String[] args) {
        //create factory session
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();


        try {
            int empId = 1;
          //create transaction
          session = factory.getCurrentSession();
          session.beginTransaction();

            //retrieved student based on id
            System.out.println("Getting student with id: " + empId);
            Employee myEmp = session.get(Employee.class, empId);

            System.out.println("Updating employee...");
            myEmp.setFirstName("Jhin");

            //commit transaction
            session.getTransaction().commit();

            //NEW CODE
            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Updating company for Employee");
            session.createQuery("update Employee set company='Garena'")
                    .executeUpdate();

            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!!!");
          }
          finally{
              factory.close();
          }

    }
}
