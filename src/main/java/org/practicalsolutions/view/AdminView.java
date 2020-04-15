package org.practicalsolutions.view;

import org.practicalsolutions.controller.IndexSingleton;

public class AdminView {

    public static IndexSingleton indexSingleton = IndexSingleton.getInstance();
    public static String reedIndexPage = indexSingleton.getIndex();
    public static String reedAdminPage = indexSingleton.getAdmin();

    public String pageAdmin () {
        return reedIndexPage.replace("<!--Admin-->",reedAdminPage);
    }
}
