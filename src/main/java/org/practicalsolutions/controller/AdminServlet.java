package org.practicalsolutions.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.practicalsolutions.dao.entity.Phone;
import org.practicalsolutions.dao.entity.Product;
import org.practicalsolutions.dao.entity.Television;
import org.practicalsolutions.dao.repository.ProductDaoImp;
import org.practicalsolutions.view.AdminView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "AdminServlet", urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {

    public static final Logger log = LogManager.getLogger(IndexServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String message = request.getParameter("message");

        PrintWriter out = response.getWriter();

        ProductDaoImp productDaoImp = new ProductDaoImp();
        List<Product> productList = productDaoImp.getAllProducts();

        AdminView adminView = new AdminView();

        if (message != null && message.trim().length() !=0) {
            String fullPage = adminView.pageAdmin(productList);
            out.println(adminView.addMessageForUser(message,fullPage));
        } else {
            out.println(adminView.pageAdmin(productList));
        }

    }
}
