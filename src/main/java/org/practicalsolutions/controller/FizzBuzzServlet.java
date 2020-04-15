package org.practicalsolutions.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.practicalsolutions.dao.entity.Phone;
import org.practicalsolutions.dao.entity.Product;
import org.practicalsolutions.dao.entity.Television;
import org.practicalsolutions.dao.repository.ProductDaoImp;
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
        String numberArray3Start = request.getParameter("numberStartForArray3");
        String numberArray3Finish = request.getParameter("numberFinishForArray3");
        String numberFizzBuzzStart = request.getParameter("numberStartForFizzBuzz");
        String numberFizzBuzzFinish = request.getParameter("numberFinishForFizzBuzz");

        Tasks tasks = new Tasks();
        FizzBuzzView fizzBuzzView = new FizzBuzzView();

        if (firstName != null && lastName != null){
            String fizzBuzzString = tasks.fizzBuzzString(firstName,lastName);
            out.println(fizzBuzzView.fizzString(fizzBuzzString));
        } else if (numberArray1 != null){
            try {
                int numbForArr1 = Integer.parseInt(numberArray1);
                int [] fizzArray = tasks.fizzArray1(numbForArr1);
                out.println(fizzBuzzView.fizzFirstArr(fizzArray));
            } catch (NumberFormatException e){
                log.error("Instead Integer we received another type: "+e);
            }
        } else if (numberArray3Start != null && numberArray3Finish != null){
            try {
                int numbForArr3Start = Integer.parseInt(numberArray3Start);
                int numbForArr3Finish = Integer.parseInt(numberArray3Finish);
                int [] fizzArray3 = tasks.fizzArray3(numbForArr3Start,numbForArr3Finish);
                out.println(fizzBuzzView.fizzThirdArr(fizzArray3));
            } catch (NumberFormatException e){
                log.error("Instead Integer we received another type: "+e);
            }
        } else if (numberFizzBuzzStart != null && numberFizzBuzzFinish != null){
            try {
                int numbForFizzBuzzStart = Integer.parseInt(numberFizzBuzzStart);
                int numbForFizzBuzzFinish = Integer.parseInt(numberFizzBuzzFinish);
                String [] fizzBuzz = tasks.fizzBuzz(numbForFizzBuzzStart,numbForFizzBuzzFinish);
                out.println(fizzBuzzView.fizzBuzz(fizzBuzz));
            } catch (NumberFormatException e){
                log.error("Instead Integer we received another type: "+e);
            }
        }
        else {
            doGet(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        FizzBuzzView fizzBuzzView = new FizzBuzzView();
        out.println(fizzBuzzView.pageFizzBuzz());
    }
}
