package org.practicalsolutions.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*This class for to take the location
of the file on server*/

public class IndexSingleton {
    private String patch;
    private String index;
    private static IndexSingleton indexSingleton = new IndexSingleton();

    private IndexSingleton(){}

    public static IndexSingleton getInstance() {
        return indexSingleton;
    }

    public String getIndex() {
        return index;
    }

    public void setPatch(String patch) {
        this.patch = patch;
        this.index = getPartialHtml("index");
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
            System.out.println(e);
        }
        return stringBuilder.toString();
    }
}
