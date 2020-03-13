package org.practicalsolutions.view;

import org.practicalsolutions.controller.IndexSingleton;

public class FizzBuzzView {

    public String formingPageIndex (String inputInBody){
        IndexSingleton indexSingleton = IndexSingleton.getInstance();
        String fromIndex = indexSingleton.getIndex();

        String fromFizzBuzzBody = indexSingleton.getFizzBuzz();
        String replaceFromMethod = fromFizzBuzzBody.replace("<!--FizzBuzzString-->",inputInBody);
        String full = fromIndex.replace("<!--FizzBuzzBody-->",replaceFromMethod);

        return full;
    }
}
