package org.tampvn.hibernateEMP.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_employee_tracker?useSSL=false&serverTimezone=UTC";
        String user = "employee";
        String pass = "employee";
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