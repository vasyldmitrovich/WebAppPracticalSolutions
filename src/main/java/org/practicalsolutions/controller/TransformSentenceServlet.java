package org.practicalsolutions.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.practicalsolutions.service.TransformSentence;
import org.practicalsolutions.view.TransformSentenceView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@WebServlet(name = "TransformSentenceServlet", urlPatterns = "/transformSentence")
public class TransformSentenceServlet extends HttpServlet {

    public static final Logger log = LogManager.getLogger(IndexServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String sentence = request.getParameter("sentence");

        IndexSingleton indexSingleton = IndexSingleton.getInstance();
        String patchToFile = indexSingleton.getPatchToFiles();

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy_mm_dd_hh_mm_ss_ssss");
        String patchPlusNameFile = patchToFile+dateFormat.format(date)+".txt";

        TransformSentence transformSentence = new TransformSentence();
        transformSentence.mySentence(sentence);
        transformSentence.createFile(patchPlusNameFile);

        //TODO view this page and link on file
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        TransformSentenceView transformSentenceView = new TransformSentenceView();
        out.println(transformSentenceView.pageTransformSentence());

    }
}
