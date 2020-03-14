package org.practicalsolutions.view;

import org.practicalsolutions.controller.IndexSingleton;

public class FizzBuzzView {

    public static IndexSingleton indexSingleton = IndexSingleton.getInstance();
    public static String reedIndexPage = indexSingleton.getIndex();
    public static String reedFizzBuzzBodyPage = indexSingleton.getFizzBuzz();

    public String pageFizzBuzz () {
        return reedIndexPage.replace("<!--FizzBuzzBody-->",reedFizzBuzzBodyPage);
    }

    public String fizzString (String fromString) {
        String fullP = reedIndexPage.replace("<!--FizzBuzzBody-->",reedFizzBuzzBodyPage);
        return fullP.replace("FizzBuzzString",fromString);
    }

    public String fizzFirstArr (int [] fromFirstArray) {
        String fullP = reedIndexPage.replace("<!--FizzBuzzBody-->",reedFizzBuzzBodyPage);
        StringBuilder stringBuilder = new StringBuilder();

        for (int a: fromFirstArray
             ) {
            stringBuilder.append(a+"  ");
        }
        return fullP.replace("FizzBuzzArray1",stringBuilder.toString());
    }

    public String fizzThirdArr (int [] fromThirdArray) {
        String fullP = reedIndexPage.replace("<!--FizzBuzzBody-->",reedFizzBuzzBodyPage);
        StringBuilder stringBuilder = new StringBuilder();

        for (int a: fromThirdArray
        ) {
            stringBuilder.append(a+"  ");
        }
        return fullP.replace("FizzBuzzArray3",stringBuilder.toString());
    }
}
