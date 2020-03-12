package org.practicalsolutions.view;

import org.practicalsolutions.controller.IndexSingleton;

public class IndexView {


    public String formingPageIndex (String inputInBody){
        IndexSingleton indexSingleton = IndexSingleton.getInstance();
        return indexSingleton.getIndex().replace("<!--tempIndex-->",inputInBody);
    }
}
