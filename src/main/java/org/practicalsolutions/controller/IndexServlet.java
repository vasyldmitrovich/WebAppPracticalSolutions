package org.practicalsolutions.controller;

import org.apache.log4j.Logger;
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
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,      // 10MB
        maxRequestSize = 1024 * 1024 * 50)   // 50MB
public class IndexServlet extends HttpServlet {

    public static final Logger log = Logger.getLogger(IndexServlet.class);
    private static final String SAVE_DIR = "/images/";

    @Override
    public void init() throws ServletException {
        super.init();
        String patch = getServletContext().getRealPath("/view/html/");
        IndexSingleton indexSingleton = IndexSingleton.getInstance();
        indexSingleton.setPatch(patch);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathToFileImage = SAVE_DIR+"/";
        PrintWriter out = response.getWriter();
        // gets absolute path of the web application
        String appPath = request.getServletContext().getRealPath("");
        // constructs path of the directory to save uploaded file
        String savePath = appPath + File.separator + SAVE_DIR;
        // creates the save directory if it does not exists
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
            for (Part part : request.getParts()) {
                String fileName = extractFileName(part);
                pathToFileImage = pathToFileImage+fileName;
                System.out.println(pathToFileImage);
                log.info("File is upload"+pathToFileImage);
                // refines the fileName in case it is an absolute path
                fileName = new File(fileName).getName();
                part.write(savePath + File.separator + fileName);
            }
        request.setAttribute("done", "Upload has been done successfully!");
        response.sendRedirect("/");

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
        Tasks tasks = new Tasks();
        String fizzBuzzString = tasks.fizzBuzzString("Fizz","Buzz");
        out.println(indexView.formingPageIndex(fizzBuzzString));
    }
}
