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

@WebServlet(name = "AdminServlet", urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {

    public static final Logger log = LogManager.getLogger(IndexServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String manufacturer = request.getParameter("manufacturer");
        String year = request.getParameter("year");
        String category = request.getParameter("category");

        ProductDaoImp productDaoImp = new ProductDaoImp();

        //TODO verification correcting data from page

         if (category != null && category.trim().length() != 0) {
             if (category.equals("Product")) {
                 double priceD = Double.parseDouble(price);
                 int yearI = Integer.parseInt(year);

                 Product product = new Product(1,name,priceD,manufacturer,yearI,category);
                 productDaoImp.addProduct(product);
                 log.info("From AdminServlet add product -Product- to DB");
             } else if (category.equals("Phone")) {
                 try {
                     double priceD = Double.parseDouble(price);
                     int yearI = Integer.parseInt(year);
                     String screenDiagonal = request.getParameter("screenDiagonal");
                     double screenDiagonalD = Double.parseDouble(screenDiagonal);
                     String ram = request.getParameter("ram");
                     double rumD = Double.parseDouble(ram);
                     String internalMemory = request.getParameter("internalMemory");
                     double internalMemoryD = Double.parseDouble(internalMemory);

                     Product product = new Phone(name,priceD,manufacturer,yearI,category,
                             screenDiagonalD,rumD,internalMemoryD);
                     productDaoImp.addProduct(product);
                     log.info("From AdminServlet add product -Phone- to DB");
                 } catch (NumberFormatException e) {
                     log.error("Do not correct number format from page "+e);
                 }
                 doGet(request,response);
             } else if (category.equals("Television")) {
                 try {
                     double priceD = Double.parseDouble(price);
                     int yearI = Integer.parseInt(year);
                     String screenDiagonal = request.getParameter("screenDiagonal");
                     double screenDiagonalD = Double.parseDouble(screenDiagonal);

                     Product product = new Television(name,priceD,manufacturer,
                             yearI,category,screenDiagonalD);
                     productDaoImp.addProduct(product);
                     log.info("From AdminServlet add product -Television- to DB");
                 } catch (NumberFormatException e) {
                     log.error("Do not correct number format from page "+e);
                 }
                 doGet(request,response);
             }

         } else {
             log.info("method post is bad please repair that");
         }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        AdminView adminView = new AdminView();
        out.println(adminView.pageAdmin());
    }
}
