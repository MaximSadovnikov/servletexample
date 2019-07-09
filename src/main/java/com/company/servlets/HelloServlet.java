package com.company.servlets;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // http://localhost/hourse/rest/count?width=10&height=14&start=B1&end=A3

        String widthAsString = request.getParameter("width");
        String heightAsString = request.getParameter("height");
        String startAsString = request.getParameter("start");
        String endAsString = request.getParameter("end");

        int width = Integer.parseInt(widthAsString);
        int height = Integer.parseInt(heightAsString);

        Chessboard chessboard = new Chessboard(width, height);
        Horse horse = new Horse(startAsString, chessboard);
        EndSquare endSquare = new EndSquare(endAsString, chessboard);
        PrintWriter printWriter = response.getWriter();
        printWriter.write(Integer.toString(CountSteps.count(horse, endSquare)));

    }
}
