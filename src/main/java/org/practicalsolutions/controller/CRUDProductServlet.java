package org.practicalsolutions.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.practicalsolutions.dao.ProductDao;
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

    public static final Logger log = LogManager.getLogger(CRUDProductServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        String pathInfo = request.getPathInfo();

        if (pathInfo == null || pathInfo.equals("/")) {
            response.sendRedirect("/admin");
        } else if (pathInfo.equals("/add")) {
            addProduct(request, response);
        } else if (pathInfo.equals("/delete")) {
            deleteProduct(request, response);
        } else if (pathInfo.equals("/update")) {
            updateProduct(request, response);
        } else {
            response.sendRedirect("/admin");
        }

    }

    public void addProduct(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String manufacturer = request.getParameter("manufacturer");
        String year = request.getParameter("year");
        String category = request.getParameter("category");

        ProductDaoImp productDaoImp = new ProductDaoImp();
        String messageForUser;

        if (category != null && category.trim().length() != 0) {
            String categoryLowerC = category.toLowerCase();

            if (categoryLowerC.equals("product")) {
                try {
                    double priceD = Double.parseDouble(price);
                    int yearI = Integer.parseInt(year);

                    Product product = new Product.Builder()
                            .setName(name)
                            .setPrice(priceD)
                            .setManufacturer(manufacturer)
                            .setYearOfManufacturer(yearI)
                            .setCategory(categoryLowerC)
                            .build();

                    productDaoImp.addProduct(product);
                    messageForUser = "Product added to DB successful";
                } catch (NumberFormatException e) {
                    log.error("Do not correct number format from page " + e);
                    messageForUser = "Product did not added to DB because not correct number format data from page";
                }
                response.sendRedirect("/admin?message=" + messageForUser);
            }

            if (categoryLowerC.equals("phone")) {
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
                            .setCategory(categoryLowerC)
                            .setScreenDiagonal(screenDiagonalD)
                            .setRam(ramD)
                            .setInternalMemory(internalMemoryD)
                            .build();

                    productDaoImp.addProduct(product);
                    messageForUser = "Phone added to DB successful";
                } catch (NumberFormatException e) {
                    log.error("Do not correct number format from page " + e);
                    messageForUser = "Phone did not added to DB because not correct number format data from page";
                }
                response.sendRedirect("/admin?message=" + messageForUser);
            }

            if (categoryLowerC.equals("television")) {
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
                            .setCategory(categoryLowerC)
                            .setScreenDiagonal(screenDiagonalD)
                            .build();

                    productDaoImp.addProduct(product);
                    messageForUser = "Television added to DB successful";
                } catch (NumberFormatException e) {
                    log.error("Do not correct format data from page " + e);
                    messageForUser = "Television did not add to DB because not correct format data from page";
                }
                response.sendRedirect("/admin?message=" + messageForUser);
            }

            /*Add
             * logic
             * for
             * another
             * products*/

        } else {
            log.info("Data in method post do not correct, please repair that");
            messageForUser = "Data in form do not correct, please repair that";
            response.sendRedirect("/admin?message=" + messageForUser);
        }
    }

    public void deleteProduct(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String id = request.getParameter("id");

        ProductDaoImp productDaoImp = new ProductDaoImp();
        String messageForUser;
        if (id != null && id.trim().length() != 0) {
            try {
                long idL = Long.parseLong(id);
                productDaoImp.removeProduct(idL);
                messageForUser = "Product deleted from DB successful";
            } catch (NumberFormatException e) {
                log.error("Do not correct format data from page " + e);
                messageForUser = "Product did not delete from DB because not correct format data from page";
            }
            response.sendRedirect("/admin?message=" + messageForUser);
        } else {
            log.error("Parameter id is null");
            messageForUser = "Product did not delete from DB because has not been added id product";
            response.sendRedirect("/admin?message=" + messageForUser);
        }
    }

    public void updateProduct(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String manufacturer = request.getParameter("manufacturer");
        String year = request.getParameter("year");
        String category = request.getParameter("category");

        ProductDao productDao = new ProductDaoImp();
        String messageForUser;

        if (category != null && category.trim().length() != 0) {
            String categoryLowerC = category.toLowerCase();

            if (categoryLowerC.equals("product")) {
                try {
                    long idL = Long.parseLong(id);
                    double priceD = Double.parseDouble(price);
                    int yearI = Integer.parseInt(year);

                    Product product = new Product.Builder()
                            .setId(idL)
                            .setName(name)
                            .setPrice(priceD)
                            .setManufacturer(manufacturer)
                            .setYearOfManufacturer(yearI)
                            .setCategory(categoryLowerC)
                            .build();

                    productDao.updateProduct(product);
                    messageForUser = "Product updated successful";
                } catch (NumberFormatException e) {
                    log.error("Do not correct number format from page " + e);
                    messageForUser = "Product did not update to DB because not correct number format data from page";
                }
                response.sendRedirect("/admin?message=" + messageForUser);
            }

            if (categoryLowerC.equals("phone")) {
                try {
                    long idL = Long.parseLong(id);
                    double priceD = Double.parseDouble(price);
                    int yearI = Integer.parseInt(year);
                    String screenDiagonal = request.getParameter("screenDiagonal");
                    double screenDiagonalD = Double.parseDouble(screenDiagonal);
                    String ram = request.getParameter("ram");
                    double ramD = Double.parseDouble(ram);
                    String internalMemory = request.getParameter("internalMemory");
                    double internalMemoryD = Double.parseDouble(internalMemory);

                    Product product = new Phone.Builder()
                            .setId(idL)
                            .setName(name)
                            .setPrice(priceD)
                            .setManufacturer(manufacturer)
                            .setYearOfManufacturer(yearI)
                            .setCategory(categoryLowerC)
                            .setScreenDiagonal(screenDiagonalD)
                            .setRam(ramD)
                            .setInternalMemory(internalMemoryD)
                            .build();

                    productDao.updateProduct(product);
                    messageForUser = "Phone updated successful";
                } catch (NumberFormatException e) {
                    log.error("Do not correct number format from page " + e);
                    messageForUser = "Phone did not update to DB because not correct number format data from page";
                }
                response.sendRedirect("/admin?message=" + messageForUser);
            }

            if (categoryLowerC.equals("television")) {
                try {
                    long idL = Long.parseLong(id);
                    double priceD = Double.parseDouble(price);
                    int yearI = Integer.parseInt(year);
                    String screenDiagonal = request.getParameter("screenDiagonal");
                    double screenDiagonalD = Double.parseDouble(screenDiagonal);

                    Product product = new Television.Builder()
                            .setId(idL)
                            .setName(name)
                            .setPrice(priceD)
                            .setManufacturer(manufacturer)
                            .setYearOfManufacturer(yearI)
                            .setCategory(categoryLowerC)
                            .setScreenDiagonal(screenDiagonalD)
                            .build();

                    productDao.updateProduct(product);
                    messageForUser = "Television updated successful";
                } catch (NumberFormatException e) {
                    log.error("Do not correct format data from page " + e);
                    messageForUser = "Television did not update to DB because not correct format data from page";
                }
                response.sendRedirect("/admin?message=" + messageForUser);
            }

            /*Add
             * logic
             * for
             * another
             * products*/

        } else {
            log.info("Data in method post do not correct, please repair that");
            messageForUser = "Data in form do not correct, please repair that";
            response.sendRedirect("/admin?message=" + messageForUser);
        }
    }


}
