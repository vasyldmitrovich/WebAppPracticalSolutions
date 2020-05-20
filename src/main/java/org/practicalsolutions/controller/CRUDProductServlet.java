package org.practicalsolutions.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.practicalsolutions.dao.entity.Phone;
import org.practicalsolutions.dao.entity.Product;
import org.practicalsolutions.dao.entity.Television;
import org.practicalsolutions.dao.repository.ProductDaoImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit/*")
public class CRUDProductServlet extends HttpServlet {

    public static final Logger log = LogManager.getLogger(IndexServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String pathInfo = request.getPathInfo();

        if (pathInfo == null || pathInfo.equals("/")) {
            response.sendRedirect("/admin");
        } else if (pathInfo.equals("/add")) {
            addProduct(request,response);
        } else if (pathInfo.equals("/delete")) {
            deleteProduct(request,response);
        } else {
            response.sendRedirect("/admin");
        }

    }

    public void addProduct (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String manufacturer = request.getParameter("manufacturer");
        String year = request.getParameter("year");
        String category = request.getParameter("category");

        ProductDaoImp productDaoImp = new ProductDaoImp();

        /*Add product to DB*/
        if (category != null && category.trim().length() != 0) {
            if (category.equals("Product")) {
                double priceD = Double.parseDouble(price);
                int yearI = Integer.parseInt(year);

                Product product = new Product.Builder()
                        .setName(name)
                        .setPrice(priceD)
                        .setManufacturer(manufacturer)
                        .setYearOfManufacturer(yearI)
                        .setCategory(category)
                        .build();

                productDaoImp.addProduct(product);

            } else if (category.equals("Phone")) {
                try {
                    double priceD = Double.parseDouble(price);
                    int yearI = Integer.parseInt(year);
                    String screenDiagonal = request.getParameter("screenDiagonal");
                    double screenDiagonalD = Double.parseDouble(screenDiagonal);
                    String ram = request.getParameter("ram");
                    double ramD = Double.parseDouble(ram);
                    String internalMemory = request.getParameter("internalMemory");
                    double internalMemoryD = Double.parseDouble(internalMemory);

                    Product product = new Phone.Builder()
                            .setName(name)
                            .setPrice(priceD)
                            .setManufacturer(manufacturer)
                            .setYearOfManufacturer(yearI)
                            .setCategory(category)
                            .setScreenDiagonal(screenDiagonalD)
                            .setRam(ramD)
                            .setInternalMemory(internalMemoryD)
                            .build();

                    productDaoImp.addProduct(product);

                } catch (NumberFormatException e) {
                    log.error("Do not correct number format from page "+e);
                    //TODO send message to admin and show in admin page that not correct number format
                }
                response.sendRedirect("/admin");

            } else if (category.equals("Television")) {
                try {
                    double priceD = Double.parseDouble(price);
                    int yearI = Integer.parseInt(year);
                    String screenDiagonal = request.getParameter("screenDiagonal");
                    double screenDiagonalD = Double.parseDouble(screenDiagonal);

                    Product product = new Television.Builder()
                            .setName(name)
                            .setPrice(priceD)
                            .setManufacturer(manufacturer)
                            .setYearOfManufacturer(yearI)
                            .setCategory(category)
                            .setScreenDiagonal(screenDiagonalD)
                            .build();

                    productDaoImp.addProduct(product);

                } catch (NumberFormatException e) {
                    log.error("Do not correct number format from page "+e);
                    //TODO send message to admin and show in admin page that not correct number format
                }
                response.sendRedirect("/admin");
            }

        } else {
            log.info("Data in method post from user do not correct, please repair that");
            //TODO send message to admin and show in admin page that do not correct data from user
            response.sendRedirect("/admin");
        }
    }

    public void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        ProductDaoImp productDaoImp = new ProductDaoImp();

        if (id != null && id.trim().length() != 0) {
            try {
                long idL = Long.parseLong(id);

                productDaoImp.removeProduct(idL);

            } catch (NumberFormatException e) {
                log.error("Do not correct number format from page "+e);
                //TODO send message to admin and show in admin page that not correct number format
            }
            response.sendRedirect("/admin");
        } else {
            log.error("Parameter id is null");
            //TODO send message to admin and show in admin page that not correct number format
            response.sendRedirect("/admin");
        }

    }

}
