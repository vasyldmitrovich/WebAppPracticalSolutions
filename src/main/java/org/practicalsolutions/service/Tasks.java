package org.practicalsolutions.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Tasks {

    /*This is temp main method only for testing some things*/
    public static void main(String[] args) {
        Tasks tasks = new Tasks();
        tasks.fizzBuzzString("This is fizz","This is buzz");

        log.debug("Debug Message Logged !!!");
        log.info("Info Message Logged !!!");
        log.error("Error Message Logged !!!", new NullPointerException("NullError"));
        String a = "2";
        int b = Integer.parseInt(a);
        System.out.println("from a to b parse integer");

        char c1 = '1';
        char c2 = '\u0031';
        char c3 = 49;
        System.out.println("This is char c1 - 1"+"\nThis is char c2 - u0031"+"\nThis is char c3 - 49"+"\nSum: "+(c1+c2+c3));

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy_mm_dd_hh_mm_ss_ssss");
        String strDate = dateFormat.format(date);
        System.out.println(strDate);
    }

    public static final Logger log = LogManager.getLogger(Tasks.class);

    /* Return the numbers 1..100
        For multiples of 3, print "firstName" instead of the number
        For multiples of 5, print "secondName" instead of the number
        For multiples of 3 and 5, print "firstNameSecondName" instead of the number
        Here: fill an array instead of printing + some other complications */
    public String fizzBuzzString(String firstName, String secondName) {
        StringBuilder fizzBuzz = new StringBuilder();
        for (int i = 1; i < 101; i++) {
            String iterator = String.valueOf(i);
            String fizz = firstName;
            String buzz = secondName;
            if (i%3!=0) fizz = ""; else iterator = "";
            if (i%5!=0) buzz = ""; else iterator = "";
            fizzBuzz.append(iterator+fizz+buzz+"  ");
        }
        return fizzBuzz.toString();
    }

    /*Return a new int array of length n, containing the numbers 0, 1, 2, ... n-1.
    * The given n may be 0*/
    public int[] fizzArray1(int n) {
        int [] myNewReturnArray = new int [n];
        for (int i = 0; i < myNewReturnArray.length; i++){
            myNewReturnArray[i] = i;
        }
        return myNewReturnArray;
    }

    /*return a new string array of length n, containing the strings "0", "1" "2" ..
    through n-1. N may be 0*/
    public String[] fizzArray2(int n) {
        String [] out = new String [n];
        for (int i = 0; i < out.length; i++) {
            out[i] = String.valueOf(i);
        }
        return out;
    }

    /*Given start and end numbers, return a new array containing the sequence of integers
    from start up to but not including end. The end number will be greater or
    equal to the start number.*/
    public int[] fizzArray3(int start, int end) {
        int lengthArray = end-start;
        int [] fizzArray = new int [lengthArray];
        for (int i = 0; i < fizzArray.length; i++){
            fizzArray[i] = start+i;
        }
        return fizzArray;
    }

    /*Consider the series of numbers beginning at start and running up to but not including end.
    * Return a new String[] array containing the string form of these numbers, except for
    * multiples of 3, use "Fizz" instead of the number, for multiples of 5 use "Buzz",
    * and for multiples of both 3 and 5 use "FizzBuzz".*/
    public String[] fizzBuzz(int start, int end) {
        String [] arr = new String [end-start];
        for (int i= 0; i < arr.length; i++) {
            int count = start+i;
            String iterator = String.valueOf(count);
            String fizz = "Fizz";
            String buzz = "Buzz";
            if(count%3 != 0) fizz = ""; else iterator = "";
            if(count%5 != 0) buzz = ""; else iterator = "";
            arr[i] = iterator+fizz+buzz;
        }
        return arr;
    }

    public String swapVariable(int a, int b){
        a=a+b-(b=a);
        String string = "For now first number: "+a+" second number: "+b;
        return string;
    }
}
