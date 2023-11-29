package com.example.datavisualizationdashboard;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/excel")
public class DashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            try {
                // Create object of filereader
                // class with csv file as parameter.
                FileReader filereader = new FileReader("E:\\Projects\\data_visualization_dashboard\\Data.csv");

                // create csvParser object with
                // custom separator semi-colon
                CSVParser parser = new CSVParserBuilder().withSeparator(';').build();

                // create csvReader object with
                // parameter filereader and parser
                CSVReader csvReader = new CSVReaderBuilder(filereader)
                        .withCSVParser(parser)
                        .build();

                // Read all data at once
                List<String[]> allData = csvReader.readAll();

                // print Data
                for (String[] row : allData) {
                    for (String cell : row) {
                        PrintWriter writer = resp.getWriter();
                        writer.println(cell + "\t");
                        System.out.print(cell + "\t");
                    }
                    System.out.println();
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }

        }
}
