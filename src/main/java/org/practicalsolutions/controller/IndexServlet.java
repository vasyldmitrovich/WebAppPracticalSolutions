package org.practicalsolutions.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.practicalsolutions.service.Tasks;
import org.practicalsolutions.view.IndexView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "IndexServlet", urlPatterns = "/", loadOnStartup = 1)

public class IndexServlet extends HttpServlet {

    public static final Logger log = LogManager.getLogger(IndexServlet.class);

    @Override
    public void init() throws ServletException {
        super.init();
        String patch = getServletContext().getRealPath(File.separator+"view"+File.separator+"html");
        String patchToFiles = getServletContext().getRealPath(File.separator+"files");

        IndexSingleton indexSingleton = IndexSingleton.getInstance();
        indexSingleton.setPatch(patch);
        indexSingleton.setPatchToFiles(patchToFiles);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String firstVar = request.getParameter("firstVariable");
        String secondVar = request.getParameter("secondVariable");

        Tasks tasks = new Tasks();
        IndexView indexView = new IndexView();

        if (firstVar != null && secondVar != null) {
            try {
                String before = "For now first number: "+firstVar+" second number: "+secondVar;
                int first = Integer.parseInt(firstVar);
                int second = Integer.parseInt(secondVar);
                String after = tasks.swapVariable(first,second);
                out.println(indexView.formingPageIndex(before,after));
            } catch (NumberFormatException e) {
                log.error("Instead Integer we received another type: "+e);
            }
        } else {
            doGet(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        IndexView indexView = new IndexView();
        out.println(indexView.pageIndex());
    }
}
