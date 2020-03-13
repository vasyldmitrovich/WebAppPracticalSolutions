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

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        FizzBuzzView fizzBuzzView = new FizzBuzzView();
        Tasks tasks = new Tasks();
        String fizzBuzzString = tasks.fizzBuzzString("Fizz","Buzz");
        String fullPage = fizzBuzzView.formingPageIndex(fizzBuzzString);
        System.out.println(fullPage);
        out.println(fullPage);

    }
}
