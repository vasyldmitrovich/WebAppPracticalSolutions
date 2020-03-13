package org.practicalsolutions.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.practicalsolutions.service.Tasks;
import org.practicalsolutions.view.FizzBuzzView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FizzBuzzServlet", urlPatterns = "/fizzBuzz")
public class FizzBuzzServlet extends HttpServlet {

    public static final Logger log = LogManager.getLogger(IndexServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String numberArray1 = request.getParameter("numberForArray1");


        if (firstName != null && lastName != null){
            Tasks tasks = new Tasks();
            String fizzBuzzString = tasks.fizzBuzzString(firstName,lastName);

            FizzBuzzView fizzBuzzView = new FizzBuzzView();
            String fullPage = fizzBuzzView.formingPageIndex(fizzBuzzString);
            out.println(fullPage);
        }
        if (numberArray1 != null){

        }
        else {
            doGet(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        FizzBuzzView fizzBuzzView = new FizzBuzzView();

        String fizzBuzzString = request.getParameter("fizzBuzzString");

        if (fizzBuzzString != null){
            String fullPage = fizzBuzzView.formingPageIndex(fizzBuzzString);
            out.println(fullPage);
        } else {
            String fullPage = fizzBuzzView.formingPageIndex(" ");
            out.println(fullPage);
        }


    }
}
