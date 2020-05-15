package org.practicalsolutions.view;

import org.practicalsolutions.controller.IndexSingleton;
import org.practicalsolutions.dao.entity.Phone;
import org.practicalsolutions.dao.entity.Product;
import org.practicalsolutions.dao.entity.Television;

import java.util.List;

public class AdminView {

    public static IndexSingleton indexSingleton = IndexSingleton.getInstance();
    public static String reedIndexPage = indexSingleton.getIndex();
    public static String reedAdminPage = indexSingleton.getAdmin();

    public String pageAdmin (List<Product> productList) {
        StringBuilder sb = new StringBuilder();

        String indexPlusAdm = reedIndexPage.replace("<!--Admin-->",reedAdminPage);

        for (Product p: productList
             ) {

            /*Add another products
            what need add to Admin page*/

            if (p instanceof Phone) {
                sb.append("<tr>");
                sb.append("<td>"+p.getName()+"</td>");
                sb.append("<td>"+p.getPrice()+"</td>");
                sb.append("<td>"+p.getManufacturer()+"</td>");
                sb.append("<td>"+p.getYearOfManufacturer()+"</td>");
                sb.append("<td>"+p.getCategory()+"</td>");
                sb.append("<td>"+((Phone) p).getScreenDiagonal()+"</td>");
                sb.append("<td>"+((Phone) p).getRam()+"</td>");
                sb.append("<td>"+((Phone) p).getInternalMemory()+"</td>");
                sb.append("<td> <a href=\"#?id="+p.getId()+"&category="+p.getCategory()+"\">Edit</a></td>");
                sb.append("<td> <a href=\"#?id="+p.getId()+"&category="+p.getCategory()+"\">Delete</a></td>");
                sb.append("</tr>");
            } else if (p instanceof Television) {
                sb.append("<tr>");
                sb.append("<td>"+p.getName()+"</td>");
                sb.append("<td>"+p.getPrice()+"</td>");
                sb.append("<td>"+p.getManufacturer()+"</td>");
                sb.append("<td>"+p.getYearOfManufacturer()+"</td>");
                sb.append("<td>"+p.getCategory()+"</td>");
                sb.append("<td>"+((Television) p).getScreenDiagonal()+"</td>");
                sb.append("<td>-</td>");
                sb.append("<td>-</td>");
                sb.append("<td> <a href=\"#?id="+p.getId()+"&category="+p.getCategory()+"\">Edit</a></td>");
                sb.append("<td> <a href=\"#?id="+p.getId()+"&category="+p.getCategory()+"\">Delete</a></td>");
                sb.append("</tr>");
            } else {
                sb.append("<tr>");
                sb.append("<td>"+p.getName()+"</td>");
                sb.append("<td>"+p.getPrice()+"</td>");
                sb.append("<td>"+p.getManufacturer()+"</td>");
                sb.append("<td>"+p.getYearOfManufacturer()+"</td>");
                sb.append("<td>"+p.getCategory()+"</td>");
                sb.append("<td>-</td>");
                sb.append("<td>-</td>");
                sb.append("<td>-</td>");
                sb.append("<td> <a href=\"#?id="+p.getId()+"&category="+p.getCategory()+"\">Edit</a></td>");
                sb.append("<td> <a href=\"#?id="+p.getId()+"&category="+p.getCategory()+"\">Delete</a></td>");
                sb.append("</tr>");
            }
        }
        return indexPlusAdm.replace("<!--DataAllProducts-->",sb.toString());
    }
}
