package org.practicalsolutions.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*This class for to take the location
of the files on server*/

public class IndexSingleton {

    public static final Logger log = LogManager.getLogger(IndexServlet.class);

    private String patch;
    private String index;
    private String fizzBuzz;


    private static IndexSingleton indexSingleton = new IndexSingleton();

    private IndexSingleton(){}

    public static IndexSingleton getInstance() {
        return indexSingleton;
    }

    public String getIndex() {
        log.info("Get info where is file Index");
        return index;
    }

    public String getFizzBuzz() {
        log.info("Get info where is file FizzBuzzBody");
        return fizzBuzz;
    }

    public void setPatch(String patch) {
        this.patch = patch;
        this.index = getPartialHtml("index");
        this.fizzBuzz = getPartialHtml("FizzBuzzBody");
        log.info("Set patch to files html on server");
    }


    private String getPartialHtml(String filename) {
        StringBuilder stringBuilder = new StringBuilder();
        Path patch = Paths.get(this.patch+filename+".html");
        Charset charset = Charset.forName("UTF-8");

        try (BufferedReader bufferedReader = Files.newBufferedReader(patch,charset)) {
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            //System.err.format("IOException: %s%n", e);
            log.error("IOException: No html file on disc: ",e);
        }
        return stringBuilder.toString();
    }
}
