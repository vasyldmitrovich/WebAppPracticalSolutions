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
import java.io.*;
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

        /*Get data and time, because files will save on server in the format date+time in milliseconds*/
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy_mm_dd_hh_mm_ss_ssss");
        String fileName = dateFormat.format(date)+".txt";
        String patchPlusNameFile = patchToFile+fileName;

        TransformSentence transformSentence = new TransformSentence();
        TransformSentenceServlet transformSentenceServlet = new TransformSentenceServlet();

        if (sentence != null){
            if (transformSentence.isStringCorrect(sentence) && sentence.length()<=60) {

                /*if sentence do not have wrong characters and do not length than 60 symbol
                * transform in array and write in file on server */
                transformSentence.mySentence(sentence);
                String[][] strings = transformSentence.getStrings();
                transformSentenceServlet.createFile(patchPlusNameFile,strings);

                /*Passing this file to the user*/
                response.setContentType("application/octet-stream");
                response.setHeader("Content-Disposition","attachment; filename=\"" + fileName + "\"");
                FileInputStream fileInputStream = new FileInputStream(patchPlusNameFile);

                try {
                    int i;
                    while ((i=fileInputStream.read()) != -1) {
                        out.write(i);
                    }
                    fileInputStream.close();
                    out.close();
                } catch (IOException e) {
                    log.error("IOException, can not write file from server: "+e);
                }
            } else {
                response.sendRedirect("/transformSentence?message=sorry");
            }
        } else {
            doGet(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String message = request.getParameter("message");

        TransformSentenceView transformSentenceView = new TransformSentenceView();
        String fullPage = transformSentenceView.pageTransformSentence();

        if (message != null && message.equals("sorry")) {
            out.println(transformSentenceView.addMessageOnPage(fullPage));
        } else {
            out.println(fullPage);
        }
    }

    public void createFile(String pathAndNameFile, String[][] strings){
        try {
            File fout = new File(pathAndNameFile);
            FileOutputStream fos = new FileOutputStream(fout);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            for (int i=0; i < strings.length; i++) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < strings[i].length; j++) {
                    stringBuilder.append(strings[i][j]);
                }
                bw.write(stringBuilder.toString());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            log.error("IOException, can not create file: "+e);
        }
    }//Create file on server and write in this
    // file data from array

}
