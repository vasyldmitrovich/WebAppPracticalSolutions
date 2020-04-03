package org.practicalsolutions.view;

import org.practicalsolutions.controller.IndexSingleton;

public class IndexView {

    public static IndexSingleton indexSingleton = IndexSingleton.getInstance();
    public static String reedIndexPage = indexSingleton.getIndex();
    public static String reedIndexBodyPage = indexSingleton.getIndexBody();

    public String pageIndex(){
        return reedIndexPage.replace("<!--IndexBody-->",reedIndexBodyPage);
    }

    public String formingPageIndex (String before, String after){
        String fullPage = reedIndexPage.replace("<!--IndexBody-->",reedIndexBodyPage);
        return fullPage.replace("SwapVariable",before+"        "+after);
    }
}
