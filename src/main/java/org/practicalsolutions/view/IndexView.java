package org.practicalsolutions.view;

import org.practicalsolutions.controller.IndexSingleton;

public class IndexView {

    public static IndexSingleton indexSingleton = IndexSingleton.getInstance();

    public String formingPageIndex (String before, String after){
        return indexSingleton.getIndex().replace("SwapVariable",before+"        "+after);
    }
}
