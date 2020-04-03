package org.practicalsolutions.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.practicalsolutions.service.Tasks;
import org.practicalsolutions.view.IndexView;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "IndexServlet", urlPatterns = "/", loadOnStartup = 1)
/*@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,      // 10MB
        maxRequestSize = 1024 * 1024 * 50)   // 50MB*/
public class IndexServlet extends HttpServlet {

    public static final Logger log = LogManager.getLogger(IndexServlet.class);
    /*private static final String SAVE_DIR = "images";*/

    @Override
    public void init() throws ServletException {
        super.init();
        String patch = getServletContext().getRealPath("/view/html/");
        IndexSingleton indexSingleton = IndexSingleton.getInstance();
        indexSingleton.setPatch(patch);
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

        /*String pathToFileImage = SAVE_DIR;
        PrintWriter out = response.getWriter();
        // gets absolute path of the web application
        String appPath = request.getServletContext().getRealPath("");
        System.out.println("this is app path: "+appPath);
        // constructs path of the directory to save uploaded file
        String savePath = appPath + SAVE_DIR + File.separator;
        System.out.println("This is save path: "+savePath);
        // creates the save directory if it does not exists
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
            for (Part part : request.getParts()) {
                String fileName = extractFileName(part);
                pathToFileImage = pathToFileImage+File.separator+fileName;
                System.out.println("This is place where file is on server: "+pathToFileImage);
                log.info("File is upload: "+pathToFileImage);
                // refines the fileName in case it is an absolute path
                fileName = new File(fileName).getName();
                part.write(savePath + File.separator + fileName);
            }
        request.setAttribute("done", "Upload has been done successfully!");
        response.sendRedirect("/");*/

    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        IndexView indexView = new IndexView();
        out.println(indexView.pageIndex());
    }
}
