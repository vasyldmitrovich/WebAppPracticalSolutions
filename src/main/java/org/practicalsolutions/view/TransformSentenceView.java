package org.practicalsolutions.view;

import org.practicalsolutions.controller.IndexSingleton;

public class TransformSentenceView {

    public static IndexSingleton indexSingleton = IndexSingleton.getInstance();
    public static String reedIndexPage = indexSingleton.getIndex();
    public static String reedTransformSentenceBodyPage = indexSingleton.getTransformSentence();

    public String pageTransformSentence () {
        return reedIndexPage.replace("<!--TransformSentence-->",reedTransformSentenceBodyPage);
    }

    public String addMessageOnPage(String page) {
        String message = "<div class=\"flex-item\">\n" +
                "        <textarea class=\"first-task-area\">\n" +
                "           I am sorry, but you maybe didn't read requirements for valid characters, \n" +
                "           or maybe length sentence bigger than it can be. \n"+
                "           Please be careful and re-enter.\n"+
                "        </textarea>\n" +
                "    </div>";
        return page.replace("<!--This is message-->",message);
    }
}
