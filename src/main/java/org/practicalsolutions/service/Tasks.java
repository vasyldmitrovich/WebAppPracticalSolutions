package org.practicalsolutions.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Tasks {
    public static void main(String[] args) {
        Tasks tasks = new Tasks();
        tasks.fizzBuzzString("This is fizz","This is buzz");
        tasks.middleTwo("ThisWillByMiddle");
        log.debug("Debug Message Logged !!!");
        log.info("Info Message Logged !!!");
        log.error("Error Message Logged !!!", new NullPointerException("NullError"));
    }

    public static final Logger log = LogManager.getLogger(Tasks.class);

    /* Return the numbers 1..100
        For multiples of 3, print "firstName" instead of the number
        For multiples of 5, print "secondName" instead of the number
        For multiples of 3 and 5, print "firstNameSecondName" instead of the number
        Here: fill an array instead of printing + some other complications */
    public String fizzBuzzString(String firstName, String secondName) {
        StringBuilder fizzBuzz = new StringBuilder();
        log.info("Method fizzBuzzString start working");
        for (int i = 1; i < 101; i++) {
            String iterator = String.valueOf(i);
            String fizz = firstName;
            String buzz = secondName;
            if (i%3!=0) fizz = ""; else iterator = "";
            if (i%5!=0) buzz = ""; else iterator = "";
            fizzBuzz.append(iterator+fizz+buzz+"<br>");
        }
        log.info("Method fizzBuzzString finished own work");
        return fizzBuzz.toString();
    }

    public String middleTwo(String str) {
        log.info("Method middleTwo start");
        int middle = str.length();
        int middle3 = (int)middle/2;
        log.info("Method middleTwo finished");
        return str.substring(middle3-1,middle3+1);
    }
}
