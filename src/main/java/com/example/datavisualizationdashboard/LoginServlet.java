package com.example.datavisualizationdashboard;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "LoginServlet", value = "/loginservlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String id=req.getParameter("userID");
        String p=req.getParameter("password");
        try{
            Connection connection = DBConnect.getConnection();
            Statement statement = connection.createStatement();

            String query ="Select user_name from users;";


            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next())
            {
                System.out.println("username "+resultSet.getString("user_name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}