package com.example.datavisualizationdashboard;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

    public static String url = "jdbc:mysql://localhost:3306/data_visualization";
    public static String user = "root";
    public static String password = "root";
    public static String driver = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection()
    {
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("connection successful");
            return conn;
        } catch (Exception e) {
            System.out.println("Class not found " + e);
            return null;
        }
    }
}
