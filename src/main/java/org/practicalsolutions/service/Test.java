package org.practicalsolutions.service;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*This is testing class, where I am testing some function*/
public class Test {
    public static void main(String[] args) {
        /*System.out.println("Cool check:");
        System.out.println(checkWithRegExp("_@BEST"));
        System.out.println(checkWithRegExp("vovan"));
        System.out.println(checkWithRegExp("vo"));
        System.out.println(checkWithRegExp("Z@OZA"));*/
        isPassworkGood("admidn");
        isNumberOnly("123555");
        boolean tempBool = checkString("ds1dd255dasdasdasd85123xxzZ");
        System.out.println("This is boolean variable, she give data from method: "+tempBool);
        boolean tempBoolInOneLine = checkStringInOneLine("/asdfasdfac23");
        System.out.println("This is boolean variable from one line, she give data from method: "+tempBoolInOneLine);
        String manyWords = "Ok this is many word in string";
        ArrayList <String> myArray = new ArrayList<>();
        myArray.add("(_ ");
        myArray.add("53Ablacfghjl?????......");
        myArray.add("42Atanglacbh)))))))))!");
        myArray.add("83AsomFef   dil((((");
        boolean result = true;
        for (String s: myArray
             ) {
            boolean temp = checkStringInOneLine(s);
            if (!temp) {
                result = false;
            }
        }
        System.out.println("This is result variable frm array where we check all word: "+result);
        String sss = "hello ? this is? from! string. and have()symbol";
        boolean kkokey = checkStringInOneLine(sss);
        System.out.println("This is boolean from sentence: "+kkokey);

        int i = 1;
        int sum = 0;

        do
        {
            sum = sum + i;
            System.out.println(sum);
            i++;
        }
        while (i <= 10);

        System.out.println(sum);

    }

    public static boolean checkStringInOneLine (String string) {
        return string.matches("[a-zA-Z0-9\\(\\)\\!\\?\\.\\s]+");
    }

    public static void isPassworkGood(String password) {
        if (Pattern.matches("admin",password)){
            System.out.println("Pass is ok: hello log - admin. pas - admin");
        }
        else {
            System.out.println("pass is wrong good bye.");
        }
    }

    public static void isNumberOnly(String password) {
        if (Pattern.matches("[0-9]+",password)){
            System.out.println("Pass is only with number.");
        } else {
            System.out.println("Pass is not only with number, there is another symbol.");
        }
    }

    public static boolean checkWithRegExp(String userNameString){
        Pattern p = Pattern.compile("^[a-z0-9_-]{3,15}$");
        Matcher m = p.matcher(userNameString);
        return m.matches();
    }

    public static boolean checkString(String stringFromUser) {
        Pattern pattern = Pattern.compile("[A-Za-z0-9]+");
        Matcher matcher = pattern.matcher(stringFromUser);
        return matcher.matches();
    }




}

