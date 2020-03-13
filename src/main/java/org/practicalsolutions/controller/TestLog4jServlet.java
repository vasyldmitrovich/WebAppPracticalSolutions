package org.practicalsolutions.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "TestLog4jServlet", urlPatterns = "/test")
public class TestLog4jServlet extends HttpServlet {

    public static final Logger log = LogManager.getLogger(TestLog4jServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("This is a logging statement from log4j2");

        String html = "<html><h2>Log4j2 has been initialized successfully!</h2></html>";
        response.getWriter().println(html);
    }
}
