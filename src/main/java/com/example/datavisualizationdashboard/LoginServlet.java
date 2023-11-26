package com.example.datavisualizationdashboard;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
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
                System.out.println("username: "+resultSet.getString("user_name"));

                String user_code = resultSet.getString("user_code");

                String query2 = "select user_type from users_types where user_code=" + user_code;
                ResultSet resultSet1 = statement.executeQuery(query2);
                while (resultSet1.next()){
                    String user_type = resultSet1.getString("user_type");
                    if(user_type.equals("admin")){
                        resp.sendRedirect("dashboard.html");
                    }
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}