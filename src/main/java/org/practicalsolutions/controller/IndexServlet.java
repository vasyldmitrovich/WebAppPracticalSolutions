package org.practicalsolutions.controller;

import org.practicalsolutions.service.Tasks;
import org.practicalsolutions.view.IndexView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "IndexServlet", urlPatterns = "/", loadOnStartup = 1)
public class IndexServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        String patch = getServletContext().getRealPath("/view/html/");
        IndexSingleton indexSingleton = IndexSingleton.getInstance();
        indexSingleton.setPatch(patch);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        IndexView indexView = new IndexView();
        Tasks tasks = new Tasks();
        String fizzBuzzString = tasks.fizzBuzzString("Fizz","Buzz");
        out.println(indexView.formingPageIndex(fizzBuzzString));
    }
}
