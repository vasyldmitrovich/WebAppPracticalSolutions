package org.practicalsolutions.view;

import org.practicalsolutions.controller.IndexSingleton;

public class TransformSentenceView {

    public static IndexSingleton indexSingleton = IndexSingleton.getInstance();
    public static String reedIndexPage = indexSingleton.getIndex();
    public static String reedTransformSentenceBodyPage = indexSingleton.getTransformSentence();

    public String pageTransformSentence () {
        return reedIndexPage.replace("<!--TransformSentence-->",reedTransformSentenceBodyPage);
    }

    //TODO method with forming doPost part
}
