package org.tampvn.hibernate.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
        String user = "hbstudent";
        String pass = "hbstudent";
        try {
            System.out.println("Connecting to database:" + jdbcUrl);
            Connection conn = DriverManager.getConnection(jdbcUrl,user,pass);
            System.out.println("Connection succesful!!!");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}