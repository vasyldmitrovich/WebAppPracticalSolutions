package org.practicalsolutions.service;

public class Tasks {

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
            fizzBuzz.append(iterator+fizz+buzz+"<br>");
        }
        return fizzBuzz.toString();
    }

}
