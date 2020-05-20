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
            if (p instanceof Phone) {
                sb.append(addPhone(p));
            } else if (p instanceof Television) {
                sb.append(addTelevision(p));
            } else {
                sb.append(addProduct(p));
            }
        }
        return indexPlusAdm.replace("<!--DataAllProducts-->",sb.toString());
    }

    public String addMessageForUser (String bodyMessage, String fullPage) {
        String result = "<div class=\"toast shadow-lg mb-2\" id='toast3'  data-autohide=\"false\" style=\"position: absolute; top: 10px; right: 10px;\">\n" +
                "        <div class=\"toast-header bg-primary p-2\">\n" +
                "            <strong class=\"mr-auto text-light\">Info message for sender</strong>\n" +
                "            <button type=\"button\" class=\"mb-1 close\" data-dismiss=\"toast\" aria-label=\"Close\">\n" +
                "                <span aria-hidden=\"true\">&times;</span>\n" +
                "            </button>\n" +
                "        </div>\n" +
                "        <div class=\"toast-body p-2\">\n" +
                "            "+bodyMessage+"\n" +
                "        </div>\n" +
                "    </div>";
        return fullPage.replace("<!--MessageForSender-->",result);
    }

    /*Add
    method
    for
    another
    product*/

    public String addProduct (Product p) {
        StringBuilder sb = new StringBuilder();
        sb.append("<tr>");
        sb.append("<td>"+p.getName()+"</td>");
        sb.append("<td>"+p.getPrice()+"</td>");
        sb.append("<td>"+p.getManufacturer()+"</td>");
        sb.append("<td>"+p.getYearOfManufacturer()+"</td>");
        sb.append("<td>"+p.getCategory()+"</td>");
        sb.append("<td>-</td>");
        sb.append("<td>-</td>");
        sb.append("<td>-</td>");
        sb.append("<td> <button type=\"button\" data-toggle=\"modal\" data-target=\"#updateModal"+p.getId()+"\">Edit</button></td>");
        sb.append("<td> <a href=\"/edit/delete?id="+p.getId()+"\">Delete</a></td>");
        sb.append("<div class=\"modal fade\" id=\"updateModal"+p.getId()+"\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\n" +
                "        <div class=\"modal-dialog\" role=\"document\">\n" +
                "            <div class=\"modal-content\">\n" +
                "                <div class=\"modal-header\">\n" +
                "                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n" +
                "                        <span aria-hidden=\"true\">&times;</span>\n" +
                "                    </button>\n" +
                "                </div>\n" +
                "                <div class=\"modal-body\">\n" +
                "                    <form method=\"post\" action=\"/edit/update\">\n" +
                "                        FORM EDIT PRODUCT\n" +
                "                        <input class=\"form-control\" type=\"hidden\" name=\"id\" value=\""+p.getId()+"\"><br>\n" +
                "                        <input class=\"form-control\" type=\"text\" maxlength=\"30\" name=\"name\" value=\""+p.getName()+"\"\n" +
                "                               placeholder=\"Input Name here...\"><br>\n" +
                "                        <input class=\"form-control\" type=\"number\" step=\"0.1\" name=\"price\" value=\""+p.getPrice()+"\"\n" +
                "                               placeholder=\"Input Price here...\"><br>\n" +
                "                        <input class=\"form-control\" type=\"text\" maxlength=\"60\" name=\"manufacturer\" value=\""+p.getManufacturer()+"\"\n" +
                "                               placeholder=\"Input Manufacturer here...\"><br>\n" +
                "                        <input class=\"form-control\" type=\"number\" maxlength=\"4\" name=\"year\" value=\""+p.getYearOfManufacturer()+"\"\n" +
                "                               placeholder=\"Input Year here...\"><br>\n" +
                "                        <input class=\"form-control\" type=\"hidden\" maxlength=\"30\" name=\"category\" value=\""+p.getCategory()+"\"><br>\n" +
                "                        \n" +
                "                        <button type=\"submit\" class=\"btn btn-primary\">Save changes</button>\n" +
                "                    </form>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>");
        sb.append("</tr>");
        return sb.toString();
    }

    public String addPhone (Product p) {
        StringBuilder sb = new StringBuilder();
        sb.append("<tr>");
        sb.append("<td>"+p.getName()+"</td>");
        sb.append("<td>"+p.getPrice()+"</td>");
        sb.append("<td>"+p.getManufacturer()+"</td>");
        sb.append("<td>"+p.getYearOfManufacturer()+"</td>");
        sb.append("<td>"+p.getCategory()+"</td>");
        sb.append("<td>"+((Phone) p).getScreenDiagonal()+"</td>");
        sb.append("<td>"+((Phone) p).getRam()+"</td>");
        sb.append("<td>"+((Phone) p).getInternalMemory()+"</td>");
        sb.append("<td> <button type=\"button\" data-toggle=\"modal\" data-target=\"#updateModal"+p.getId()+"\">Edit</button></td>");
        sb.append("<td> <a href=\"/edit/delete?id="+p.getId()+"\">Delete</a></td>");
        sb.append("<div class=\"modal fade\" id=\"updateModal"+p.getId()+"\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\n" +
                "        <div class=\"modal-dialog\" role=\"document\">\n" +
                "            <div class=\"modal-content\">\n" +
                "                <div class=\"modal-header\">\n" +
                "                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n" +
                "                        <span aria-hidden=\"true\">&times;</span>\n" +
                "                    </button>\n" +
                "                </div>\n" +
                "                <div class=\"modal-body\">\n" +
                "                    <form method=\"post\" action=\"/edit/update\">\n" +
                "                        FORM EDIT PHONE\n" +
                "                        <input class=\"form-control\" type=\"hidden\" name=\"id\" value=\""+p.getId()+"\"><br>\n" +
                "                        <input class=\"form-control\" type=\"text\" maxlength=\"30\" name=\"name\" value=\""+p.getName()+"\"\n" +
                "                               placeholder=\"Input Name here...\"><br>\n" +
                "                        <input class=\"form-control\" type=\"number\" step=\"0.1\" name=\"price\" value=\""+p.getPrice()+"\"\n" +
                "                               placeholder=\"Input Price here...\"><br>\n" +
                "                        <input class=\"form-control\" type=\"text\" maxlength=\"60\" name=\"manufacturer\" value=\""+p.getManufacturer()+"\"\n" +
                "                               placeholder=\"Input Manufacturer here...\"><br>\n" +
                "                        <input class=\"form-control\" type=\"number\" maxlength=\"4\" name=\"year\" value=\""+p.getYearOfManufacturer()+"\"\n" +
                "                               placeholder=\"Input Year here...\"><br>\n" +
                "                        <input class=\"form-control\" type=\"hidden\" maxlength=\"30\" name=\"category\" value=\""+p.getCategory()+"\"><br>\n" +
                "                        <input class=\"form-control\" type=\"number\" step=\"0.1\" name=\"screenDiagonal\" value=\""+((Phone) p).getScreenDiagonal()+"\"\n" +
                "                               placeholder=\"Input ScreenDiagonal here...\"><br>\n" +
                "                        <input class=\"form-control\" type=\"number\" step=\"0.1\" name=\"ram\" value=\""+((Phone) p).getRam()+"\"\n" +
                "                               placeholder=\"Input Ram here...\"><br>\n" +
                "                        <input class=\"form-control\" type=\"number\" step=\"0.1\" name=\"internalMemory\" value=\""+((Phone) p).getInternalMemory()+"\"\n" +
                "                               placeholder=\"Input InternalMemory here...\"><br>\n" +
                "                        <input class=\"form-control\" type=\"hidden\" maxlength=\"30\" name=\"idCategory\" value=\""+((Phone) p).getIdCategory()+"\"><br>\n" +
                "                        <button type=\"submit\" class=\"btn btn-primary\">Save changes</button>\n" +
                "                    </form>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>");
        sb.append("</tr>");
        return sb.toString();
    }

    public String addTelevision (Product p) {
        StringBuilder sb = new StringBuilder();
        sb.append("<tr>");
        sb.append("<td>"+p.getName()+"</td>");
        sb.append("<td>"+p.getPrice()+"</td>");
        sb.append("<td>"+p.getManufacturer()+"</td>");
        sb.append("<td>"+p.getYearOfManufacturer()+"</td>");
        sb.append("<td>"+p.getCategory()+"</td>");
        sb.append("<td>"+((Television) p).getScreenDiagonal()+"</td>");
        sb.append("<td>-</td>");
        sb.append("<td>-</td>");
        sb.append("<td> <button type=\"button\" data-toggle=\"modal\" data-target=\"#updateModal"+p.getId()+"\">Edit</button></td>");
        sb.append("<td> <a href=\"/edit/delete?id="+p.getId()+"\">Delete</a></td>");
        sb.append("<div class=\"modal fade\" id=\"updateModal"+p.getId()+"\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\n" +
                "        <div class=\"modal-dialog\" role=\"document\">\n" +
                "            <div class=\"modal-content\">\n" +
                "                <div class=\"modal-header\">\n" +
                "                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n" +
                "                        <span aria-hidden=\"true\">&times;</span>\n" +
                "                    </button>\n" +
                "                </div>\n" +
                "                <div class=\"modal-body\">\n" +
                "                    <form method=\"post\" action=\"/edit/update\">\n" +
                "                        FORM EDIT TELEVISION\n" +
                "                        <input class=\"form-control\" type=\"hidden\" name=\"id\" value=\""+p.getId()+"\"><br>\n" +
                "                        <input class=\"form-control\" type=\"text\" maxlength=\"30\" name=\"name\" value=\""+p.getName()+"\"\n" +
                "                               placeholder=\"Input Name here...\"><br>\n" +
                "                        <input class=\"form-control\" type=\"number\" step=\"0.1\" name=\"price\" value=\""+p.getPrice()+"\"\n" +
                "                               placeholder=\"Input Price here...\"><br>\n" +
                "                        <input class=\"form-control\" type=\"text\" maxlength=\"60\" name=\"manufacturer\" value=\""+p.getManufacturer()+"\"\n" +
                "                               placeholder=\"Input Manufacturer here...\"><br>\n" +
                "                        <input class=\"form-control\" type=\"number\" maxlength=\"4\" name=\"year\" value=\""+p.getYearOfManufacturer()+"\"\n" +
                "                               placeholder=\"Input Year here...\"><br>\n" +
                "                        <input class=\"form-control\" type=\"hidden\" maxlength=\"30\" name=\"category\" value=\""+p.getCategory()+"\"><br>\n" +
                "                        <input class=\"form-control\" type=\"number\" step=\"0.1\" name=\"screenDiagonal\" value=\""+((Television) p).getScreenDiagonal()+"\"\n" +
                "                               placeholder=\"Input ScreenDiagonal here...\"><br>\n" +
                "                        <input class=\"form-control\" type=\"hidden\" maxlength=\"30\" name=\"idCategory\" value=\""+((Television) p).getIdCategory()+"\"><br>\n" +
                "                        <button type=\"submit\" class=\"btn btn-primary\">Save changes</button>\n" +
                "                    </form>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>");
        sb.append("</tr>");
        return sb.toString();
    }
}
