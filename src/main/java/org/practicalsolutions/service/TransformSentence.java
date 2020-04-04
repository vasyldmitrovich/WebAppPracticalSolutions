package org.practicalsolutions.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.practicalsolutions.controller.IndexServlet;

import java.util.Scanner;

public class TransformSentence {

    /*The user input sentence, the output gets own sentence but big letters*/
    public static final Logger log = LogManager.getLogger(IndexServlet.class);
    private static int indexArray = 0;
    final static private int heightArray = 7;
    final static private int wightArray = 360;
    private String [] [] strings;//Array where concat all letters

    public TransformSentence() {
        this.strings = new String[heightArray][wightArray];
    }

    public String[][] getStrings() {
        return strings;
    }

    private static String getInputSentence(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input any word or sentence. I will show you how it will be look on airport table." +
                "\nATTENTION: only letters a-z or A-Z, space, numbers 0-9 and symbol ! ? ( ) and point." +
                "\nDo not length then 30 symbols");
        return scanner.nextLine();
    }//Scanner input letters.

    public void mySentence(String mSentence){
        String string = mSentence.toUpperCase();
        /*Clean array from value null*/
        for (int l = 0; l < strings.length; l++){
            for (int k=0; k < strings[l].length; k++){
                strings[l][k] = "";
            }
        }
        /*A loop that runs through each character in a line,
        and add this character in array*/
        for (int i = 0; i < string.length(); i++){
            char oneLetter = string.charAt(i);
            switch (oneLetter){
                case 'A': plusLetter(letterA()); break;
                case 'B': plusLetter(letterB()); break;
                case 'C': plusLetter(letterC()); break;
                case 'D': plusLetter(letterD()); break;
                case 'E': plusLetter(letterE()); break;
                case 'F': plusLetter(letterF()); break;
                case 'G': plusLetter(letterG()); break;
                case 'H': plusLetter(letterH()); break;
                case 'I': plusLetter(letterI()); break;
                case 'J': plusLetter(letterJ()); break;
                case 'K': plusLetter(letterK()); break;
                case 'L': plusLetter(letterL()); break;
                case 'M': plusLetter(letterM()); break;
                case 'N': plusLetter(letterN()); break;
                case 'O': plusLetter(letterO()); break;
                case 'P': plusLetter(letterP()); break;
                case 'Q': plusLetter(letterQ()); break;
                case 'R': plusLetter(letterR()); break;
                case 'S': plusLetter(letterS()); break;
                case 'T': plusLetter(letterT()); break;
                case 'U': plusLetter(letterU()); break;
                case 'V': plusLetter(letterV()); break;
                case 'W': plusLetter(letterW()); break;
                case 'X': plusLetter(letterX()); break;
                case 'Y': plusLetter(letterY()); break;
                case 'Z': plusLetter(letterZ()); break;
                case ' ': plusLetter(numberFree()); break;
                case '0': plusLetter(numberZero()); break;
                case '1': plusLetter(numberOne()); break;
                case '2': plusLetter(numberTwo()); break;
                case '3': plusLetter(numberThree()); break;
                case '4': plusLetter(numberFour()); break;
                case '5': plusLetter(numberFive()); break;
                case '6': plusLetter(numberSix()); break;
                case '7': plusLetter(numberSeven()); break;
                case '8': plusLetter(numberEight()); break;
                case '9': plusLetter(numberNine()); break;
                case '?': plusLetter(symbolQuestion()); break;
                case '!': plusLetter(symbolWTF()); break;
                case '(': plusLetter(symbolBrackets1()); break;
                case ')': plusLetter(symbolBrackets2()); break;
                case '.': plusLetter(symbolPoint()); break;

            }
        }
        indexArray = 0;
    }//Build array with letters

    private void plusLetter(String [] [] str){
        int rows = str.length;// I get length rows array
        int columns = str[0].length;// I get length columns array
        /*This cycle get start index from static variable,
        get array and set this array in static array*/
        for (int i=0; i < rows; i++ ){
            for (int j=indexArray; j < indexArray+columns; j++){
                strings[i][j] = str[i][j-indexArray];
            }
        }
        indexArray = indexArray+columns;
    }//Add letter in array

    public void printArray(){
        for (int i=0; i < strings.length; i++){
            for (int j=0; j<strings[i].length; j++){
                System.out.print(strings[i] [j]);
            }
            System.out.println();
        }
    }//Print array letters in console

    public boolean isStringCorrect (String string) {
        return string.matches("[a-zA-Z0-9\\(\\)\\!\\?\\.\\s]+");
    }//Check is sentence right

    /*letters*/

    private static String [] [] letterA (){
        String [] [] array = new String[7][6];
        array[0] [0] = " ";
        array[0] [1] = "*";
        array[0] [2] = "*";
        array[0] [3] = "*";
        array[0] [4] = " ";
        array[0] [5] = " ";

        array[1] [0] = "*";
        array[1] [1] = " ";
        array[1] [2] = " ";
        array[1] [3] = " ";
        array[1] [4] = "*";
        array[1] [5] = " ";

        array[2] [0] = "*";
        array[2] [1] = " ";
        array[2] [2] = " ";
        array[2] [3] = " ";
        array[2] [4] = "*";
        array[2] [5] = " ";

        array[3] [0] = "*";
        array[3] [1] = "*";
        array[3] [2] = "*";
        array[3] [3] = "*";
        array[3] [4] = "*";
        array[3] [5] = " ";

        array[4] [0] = "*";
        array[4] [1] = " ";
        array[4] [2] = " ";
        array[4] [3] = " ";
        array[4] [4] = "*";
        array[4] [5] = " ";

        array[5] [0] = "*";
        array[5] [1] = " ";
        array[5] [2] = " ";
        array[5] [3] = " ";
        array[5] [4] = "*";
        array[5] [5] = " ";

        array[6] [0] = "*";
        array[6] [1] = " ";
        array[6] [2] = " ";
        array[6] [3] = " ";
        array[6] [4] = "*";
        array[6] [5] = " ";
        return array;
    }

    private static String [] [] letterB (){
        String [] [] array = new String[7][6];
        array[0] [0] = "*";
        array[0] [1] = "*";
        array[0] [2] = "*";
        array[0] [3] = "*";
        array[0] [4] = " ";
        array[0] [5] = " ";

        array[1] [0] = "*";
        array[1] [1] = " ";
        array[1] [2] = " ";
        array[1] [3] = " ";
        array[1] [4] = "*";
        array[1] [5] = " ";

        array[2] [0] = "*";
        array[2] [1] = " ";
        array[2] [2] = " ";
        array[2] [3] = " ";
        array[2] [4] = "*";
        array[2] [5] = " ";

        array[3] [0] = "*";
        array[3] [1] = "*";
        array[3] [2] = "*";
        array[3] [3] = "*";
        array[3] [4] = " ";
        array[3] [5] = " ";

        array[4] [0] = "*";
        array[4] [1] = " ";
        array[4] [2] = " ";
        array[4] [3] = " ";
        array[4] [4] = "*";
        array[4] [5] = " ";

        array[5] [0] = "*";
        array[5] [1] = " ";
        array[5] [2] = " ";
        array[5] [3] = " ";
        array[5] [4] = "*";
        array[5] [5] = " ";

        array[6] [0] = "*";
        array[6] [1] = "*";
        array[6] [2] = "*";
        array[6] [3] = "*";
        array[6] [4] = " ";
        array[6] [5] = " ";
        return array;
    }

    private static String [] [] letterC (){
        String [] [] array = new String[7][6];
        array[0] [0] = " ";
        array[0] [1] = "*";
        array[0] [2] = "*";
        array[0] [3] = "*";
        array[0] [4] = " ";
        array[0] [5] = " ";

        array[1] [0] = "*";
        array[1] [1] = " ";
        array[1] [2] = " ";
        array[1] [3] = " ";
        array[1] [4] = "*";
        array[1] [5] = " ";

        array[2] [0] = "*";
        array[2] [1] = " ";
        array[2] [2] = " ";
        array[2] [3] = " ";
        array[2] [4] = " ";
        array[2] [5] = " ";

        array[3] [0] = "*";
        array[3] [1] = " ";
        array[3] [2] = " ";
        array[3] [3] = " ";
        array[3] [4] = " ";
        array[3] [5] = " ";

        array[4] [0] = "*";
        array[4] [1] = " ";
        array[4] [2] = " ";
        array[4] [3] = " ";
        array[4] [4] = " ";
        array[4] [5] = " ";

        array[5] [0] = "*";
        array[5] [1] = " ";
        array[5] [2] = " ";
        array[5] [3] = " ";
        array[5] [4] = "*";
        array[5] [5] = " ";

        array[6] [0] = " ";
        array[6] [1] = "*";
        array[6] [2] = "*";
        array[6] [3] = "*";
        array[6] [4] = " ";
        array[6] [5] = " ";
        return array;
    }

    private static String [] [] letterD (){
        String [] [] array = new String[7][6];
        array[0] [0] = "*";
        array[0] [1] = "*";
        array[0] [2] = "*";
        array[0] [3] = "*";
        array[0] [4] = " ";
        array[0] [5] = " ";

        array[1] [0] = "*";
        array[1] [1] = " ";
        array[1] [2] = " ";
        array[1] [3] = " ";
        array[1] [4] = "*";
        array[1] [5] = " ";

        array[2] [0] = "*";
        array[2] [1] = " ";
        array[2] [2] = " ";
        array[2] [3] = " ";
        array[2] [4] = "*";
        array[2] [5] = " ";

        array[3] [0] = "*";
        array[3] [1] = " ";
        array[3] [2] = " ";
        array[3] [3] = " ";
        array[3] [4] = "*";
        array[3] [5] = " ";

        array[4] [0] = "*";
        array[4] [1] = " ";
        array[4] [2] = " ";
        array[4] [3] = " ";
        array[4] [4] = "*";
        array[4] [5] = " ";

        array[5] [0] = "*";
        array[5] [1] = " ";
        array[5] [2] = " ";
        array[5] [3] = " ";
        array[5] [4] = "*";
        array[5] [5] = " ";

        array[6] [0] = "*";
        array[6] [1] = "*";
        array[6] [2] = "*";
        array[6] [3] = "*";
        array[6] [4] = " ";
        array[6] [5] = " ";
        return array;
    }

    private static String [] [] letterE (){
        String [] [] array = new String[7][6];
        array[0] [0] = "*";
        array[0] [1] = "*";
        array[0] [2] = "*";
        array[0] [3] = "*";
        array[0] [4] = "*";
        array[0] [5] = " ";

        array[1] [0] = "*";
        array[1] [1] = " ";
        array[1] [2] = " ";
        array[1] [3] = " ";
        array[1] [4] = " ";
        array[1] [5] = " ";

        array[2] [0] = "*";
        array[2] [1] = " ";
        array[2] [2] = " ";
        array[2] [3] = " ";
        array[2] [4] = " ";
        array[2] [5] = " ";

        array[3] [0] = "*";
        array[3] [1] = "*";
        array[3] [2] = "*";
        array[3] [3] = " ";
        array[3] [4] = " ";
        array[3] [5] = " ";

        array[4] [0] = "*";
        array[4] [1] = " ";
        array[4] [2] = " ";
        array[4] [3] = " ";
        array[4] [4] = " ";
        array[4] [5] = " ";

        array[5] [0] = "*";
        array[5] [1] = " ";
        array[5] [2] = " ";
        array[5] [3] = " ";
        array[5] [4] = " ";
        array[5] [5] = " ";

        array[6] [0] = "*";
        array[6] [1] = "*";
        array[6] [2] = "*";
        array[6] [3] = "*";
        array[6] [4] = "*";
        array[6] [5] = " ";
        return array;
    }

    private static String [] [] letterF (){
        String [] [] array = new String[7][6];
        array[0] [0] = "*";
        array[0] [1] = "*";
        array[0] [2] = "*";
        array[0] [3] = "*";
        array[0] [4] = "*";
        array[0] [5] = " ";

        array[1] [0] = "*";
        array[1] [1] = " ";
        array[1] [2] = " ";
        array[1] [3] = " ";
        array[1] [4] = " ";
        array[1] [5] = " ";

        array[2] [0] = "*";
        array[2] [1] = " ";
        array[2] [2] = " ";
        array[2] [3] = " ";
        array[2] [4] = " ";
        array[2] [5] = " ";

        array[3] [0] = "*";
        array[3] [1] = "*";
        array[3] [2] = "*";
        array[3] [3] = " ";
        array[3] [4] = " ";
        array[3] [5] = " ";

        array[4] [0] = "*";
        array[4] [1] = " ";
        array[4] [2] = " ";
        array[4] [3] = " ";
        array[4] [4] = " ";
        array[4] [5] = " ";

        array[5] [0] = "*";
        array[5] [1] = " ";
        array[5] [2] = " ";
        array[5] [3] = " ";
        array[5] [4] = " ";
        array[5] [5] = " ";

        array[6] [0] = "*";
        array[6] [1] = " ";
        array[6] [2] = " ";
        array[6] [3] = " ";
        array[6] [4] = " ";
        array[6] [5] = " ";
        return array;
    }

    private static String [] [] letterG (){
        String [] [] array = new String[7][6];
        array[0] [0] = " ";
        array[0] [1] = "*";
        array[0] [2] = "*";
        array[0] [3] = "*";
        array[0] [4] = " ";
        array[0] [5] = " ";

        array[1] [0] = "*";
        array[1] [1] = " ";
        array[1] [2] = " ";
        array[1] [3] = " ";
        array[1] [4] = "*";
        array[1] [5] = " ";

        array[2] [0] = "*";
        array[2] [1] = " ";
        array[2] [2] = " ";
        array[2] [3] = " ";
        array[2] [4] = " ";
        array[2] [5] = " ";

        array[3] [0] = "*";
        array[3] [1] = " ";
        array[3] [2] = " ";
        array[3] [3] = " ";
        array[3] [4] = " ";
        array[3] [5] = " ";

        array[4] [0] = "*";
        array[4] [1] = " ";
        array[4] [2] = " ";
        array[4] [3] = "*";
        array[4] [4] = "*";
        array[4] [5] = " ";

        array[5] [0] = "*";
        array[5] [1] = " ";
        array[5] [2] = " ";
        array[5] [3] = " ";
        array[5] [4] = "*";
        array[5] [5] = " ";

        array[6] [0] = " ";
        array[6] [1] = "*";
        array[6] [2] = "*";
        array[6] [3] = "*";
        array[6] [4] = " ";
        array[6] [5] = " ";
        return array;
    }

    private static String [] [] letterH (){
        String [] [] array = new String[7][6];
        array[0] [0] = "*";
        array[0] [1] = " ";
        array[0] [2] = " ";
        array[0] [3] = " ";
        array[0] [4] = "*";
        array[0] [5] = " ";

        array[1] [0] = "*";
        array[1] [1] = " ";
        array[1] [2] = " ";
        array[1] [3] = " ";
        array[1] [4] = "*";
        array[1] [5] = " ";

        array[2] [0] = "*";
        array[2] [1] = " ";
        array[2] [2] = " ";
        array[2] [3] = " ";
        array[2] [4] = "*";
        array[2] [5] = " ";

        array[3] [0] = "*";
        array[3] [1] = "*";
        array[3] [2] = "*";
        array[3] [3] = "*";
        array[3] [4] = "*";
        array[3] [5] = " ";

        array[4] [0] = "*";
        array[4] [1] = " ";
        array[4] [2] = " ";
        array[4] [3] = " ";
        array[4] [4] = "*";
        array[4] [5] = " ";

        array[5] [0] = "*";
        array[5] [1] = " ";
        array[5] [2] = " ";
        array[5] [3] = " ";
        array[5] [4] = "*";
        array[5] [5] = " ";

        array[6] [0] = "*";
        array[6] [1] = " ";
        array[6] [2] = " ";
        array[6] [3] = " ";
        array[6] [4] = "*";
        array[6] [5] = " ";
        return array;
    }

    private static String [] [] letterI (){
        String [] [] array = new String[7][6];
        array[0] [0] = "*";
        array[0] [1] = "*";
        array[0] [2] = "*";
        array[0] [3] = "*";
        array[0] [4] = "*";
        array[0] [5] = " ";

        array[1] [0] = " ";
        array[1] [1] = " ";
        array[1] [2] = "*";
        array[1] [3] = " ";
        array[1] [4] = " ";
        array[1] [5] = " ";

        array[2] [0] = " ";
        array[2] [1] = " ";
        array[2] [2] = "*";
        array[2] [3] = " ";
        array[2] [4] = " ";
        array[2] [5] = " ";

        array[3] [0] = " ";
        array[3] [1] = " ";
        array[3] [2] = "*";
        array[3] [3] = " ";
        array[3] [4] = " ";
        array[3] [5] = " ";

        array[4] [0] = " ";
        array[4] [1] = " ";
        array[4] [2] = "*";
        array[4] [3] = " ";
        array[4] [4] = " ";
        array[4] [5] = " ";

        array[5] [0] = " ";
        array[5] [1] = " ";
        array[5] [2] = "*";
        array[5] [3] = " ";
        array[5] [4] = " ";
        array[5] [5] = " ";

        array[6] [0] = "*";
        array[6] [1] = "*";
        array[6] [2] = "*";
        array[6] [3] = "*";
        array[6] [4] = "*";
        array[6] [5] = " ";
        return array;
    }

    private static String [] [] letterJ (){
        String [] [] array = new String[7][5];
        array[0] [0] = " ";
        array[0] [1] = " ";
        array[0] [2] = " ";
        array[0] [3] = "*";
        array[0] [4] = " ";

        array[1] [0] = " ";
        array[1] [1] = " ";
        array[1] [2] = " ";
        array[1] [3] = "*";
        array[1] [4] = " ";

        array[2] [0] = " ";
        array[2] [1] = " ";
        array[2] [2] = " ";
        array[2] [3] = "*";
        array[2] [4] = " ";

        array[3] [0] = " ";
        array[3] [1] = " ";
        array[3] [2] = " ";
        array[3] [3] = "*";
        array[3] [4] = " ";

        array[4] [0] = " ";
        array[4] [1] = " ";
        array[4] [2] = " ";
        array[4] [3] = "*";
        array[4] [4] = " ";

        array[5] [0] = "*";
        array[5] [1] = " ";
        array[5] [2] = " ";
        array[5] [3] = "*";
        array[5] [4] = " ";

        array[6] [0] = " ";
        array[6] [1] = "*";
        array[6] [2] = "*";
        array[6] [3] = " ";
        array[6] [4] = " ";
        return array;
    }

    private static String [] [] letterK (){
        String [] [] array = new String[7][6];
        array[0] [0] = "*";
        array[0] [1] = " ";
        array[0] [2] = " ";
        array[0] [3] = " ";
        array[0] [4] = "*";
        array[0] [5] = " ";

        array[1] [0] = "*";
        array[1] [1] = " ";
        array[1] [2] = " ";
        array[1] [3] = "*";
        array[1] [4] = " ";
        array[1] [5] = " ";

        array[2] [0] = "*";
        array[2] [1] = " ";
        array[2] [2] = "*";
        array[2] [3] = " ";
        array[2] [4] = " ";
        array[2] [5] = " ";

        array[3] [0] = "*";
        array[3] [1] = "*";
        array[3] [2] = " ";
        array[3] [3] = " ";
        array[3] [4] = " ";
        array[3] [5] = " ";

        array[4] [0] = "*";
        array[4] [1] = " ";
        array[4] [2] = "*";
        array[4] [3] = " ";
        array[4] [4] = " ";
        array[4] [5] = " ";

        array[5] [0] = "*";
        array[5] [1] = " ";
        array[5] [2] = " ";
        array[5] [3] = "*";
        array[5] [4] = " ";
        array[5] [5] = " ";

        array[6] [0] = "*";
        array[6] [1] = " ";
        array[6] [2] = " ";
        array[6] [3] = " ";
        array[6] [4] = "*";
        array[6] [5] = " ";
        return array;
    }

    private static String [] [] letterL (){
        String [] [] array = new String[7][6];
        array[0] [0] = "*";
        array[0] [1] = " ";
        array[0] [2] = " ";
        array[0] [3] = " ";
        array[0] [4] = " ";
        array[0] [5] = " ";

        array[1] [0] = "*";
        array[1] [1] = " ";
        array[1] [2] = " ";
        array[1] [3] = " ";
        array[1] [4] = " ";
        array[1] [5] = " ";

        array[2] [0] = "*";
        array[2] [1] = " ";
        array[2] [2] = " ";
        array[2] [3] = " ";
        array[2] [4] = " ";
        array[2] [5] = " ";

        array[3] [0] = "*";
        array[3] [1] = " ";
        array[3] [2] = " ";
        array[3] [3] = " ";
        array[3] [4] = " ";
        array[3] [5] = " ";

        array[4] [0] = "*";
        array[4] [1] = " ";
        array[4] [2] = " ";
        array[4] [3] = " ";
        array[4] [4] = " ";
        array[4] [5] = " ";

        array[5] [0] = "*";
        array[5] [1] = " ";
        array[5] [2] = " ";
        array[5] [3] = " ";
        array[5] [4] = " ";
        array[5] [5] = " ";

        array[6] [0] = "*";
        array[6] [1] = "*";
        array[6] [2] = "*";
        array[6] [3] = "*";
        array[6] [4] = "*";
        array[6] [5] = " ";
        return array;
    }

    private static String [] [] letterM (){
        String [] [] array = new String[7][6];
        array[0] [0] = "*";
        array[0] [1] = " ";
        array[0] [2] = " ";
        array[0] [3] = " ";
        array[0] [4] = "*";
        array[0] [5] = " ";

        array[1] [0] = "*";
        array[1] [1] = "*";
        array[1] [2] = " ";
        array[1] [3] = "*";
        array[1] [4] = "*";
        array[1] [5] = " ";

        array[2] [0] = "*";
        array[2] [1] = " ";
        array[2] [2] = "*";
        array[2] [3] = " ";
        array[2] [4] = "*";
        array[2] [5] = " ";

        array[3] [0] = "*";
        array[3] [1] = " ";
        array[3] [2] = " ";
        array[3] [3] = " ";
        array[3] [4] = "*";
        array[3] [5] = " ";

        array[4] [0] = "*";
        array[4] [1] = " ";
        array[4] [2] = " ";
        array[4] [3] = " ";
        array[4] [4] = "*";
        array[4] [5] = " ";

        array[5] [0] = "*";
        array[5] [1] = " ";
        array[5] [2] = " ";
        array[5] [3] = " ";
        array[5] [4] = "*";
        array[5] [5] = " ";

        array[6] [0] = "*";
        array[6] [1] = " ";
        array[6] [2] = " ";
        array[6] [3] = " ";
        array[6] [4] = "*";
        array[6] [5] = " ";
        return array;
    }

    private static String [] [] letterN (){
        String [] [] array = new String[7][6];
        array[0] [0] = "*";
        array[0] [1] = " ";
        array[0] [2] = " ";
        array[0] [3] = " ";
        array[0] [4] = "*";
        array[0] [5] = " ";

        array[1] [0] = "*";
        array[1] [1] = " ";
        array[1] [2] = " ";
        array[1] [3] = " ";
        array[1] [4] = "*";
        array[1] [5] = " ";

        array[2] [0] = "*";
        array[2] [1] = "*";
        array[2] [2] = " ";
        array[2] [3] = " ";
        array[2] [4] = "*";
        array[2] [5] = " ";

        array[3] [0] = "*";
        array[3] [1] = " ";
        array[3] [2] = "*";
        array[3] [3] = " ";
        array[3] [4] = "*";
        array[3] [5] = " ";

        array[4] [0] = "*";
        array[4] [1] = " ";
        array[4] [2] = " ";
        array[4] [3] = "*";
        array[4] [4] = "*";
        array[4] [5] = " ";

        array[5] [0] = "*";
        array[5] [1] = " ";
        array[5] [2] = " ";
        array[5] [3] = " ";
        array[5] [4] = "*";
        array[5] [5] = " ";

        array[6] [0] = "*";
        array[6] [1] = " ";
        array[6] [2] = " ";
        array[6] [3] = " ";
        array[6] [4] = "*";
        array[6] [5] = " ";
        return array;
    }

    private static String [] [] letterO (){
        String [] [] array = new String[7][6];
        array[0] [0] = " ";
        array[0] [1] = "*";
        array[0] [2] = "*";
        array[0] [3] = "*";
        array[0] [4] = " ";
        array[0] [5] = " ";

        array[1] [0] = "*";
        array[1] [1] = " ";
        array[1] [2] = " ";
        array[1] [3] = " ";
        array[1] [4] = "*";
        array[1] [5] = " ";

        array[2] [0] = "*";
        array[2] [1] = " ";
        array[2] [2] = " ";
        array[2] [3] = " ";
        array[2] [4] = "*";
        array[2] [5] = " ";

        array[3] [0] = "*";
        array[3] [1] = " ";
        array[3] [2] = " ";
        array[3] [3] = " ";
        array[3] [4] = "*";
        array[3] [5] = " ";

        array[4] [0] = "*";
        array[4] [1] = " ";
        array[4] [2] = " ";
        array[4] [3] = " ";
        array[4] [4] = "*";
        array[4] [5] = " ";

        array[5] [0] = "*";
        array[5] [1] = " ";
        array[5] [2] = " ";
        array[5] [3] = " ";
        array[5] [4] = "*";
        array[5] [5] = " ";

        array[6] [0] = " ";
        array[6] [1] = "*";
        array[6] [2] = "*";
        array[6] [3] = "*";
        array[6] [4] = " ";
        array[6] [5] = " ";
        return array;
    }

    private static String [] [] letterP (){
        String [] [] array = new String[7][6];
        array[0] [0] = "*";
        array[0] [1] = "*";
        array[0] [2] = "*";
        array[0] [3] = "*";
        array[0] [4] = " ";
        array[0] [5] = " ";

        array[1] [0] = "*";
        array[1] [1] = " ";
        array[1] [2] = " ";
        array[1] [3] = " ";
        array[1] [4] = "*";
        array[1] [5] = " ";

        array[2] [0] = "*";
        array[2] [1] = " ";
        array[2] [2] = " ";
        array[2] [3] = " ";
        array[2] [4] = "*";
        array[2] [5] = " ";

        array[3] [0] = "*";
        array[3] [1] = "*";
        array[3] [2] = "*";
        array[3] [3] = "*";
        array[3] [4] = " ";
        array[3] [5] = " ";

        array[4] [0] = "*";
        array[4] [1] = " ";
        array[4] [2] = " ";
        array[4] [3] = " ";
        array[4] [4] = " ";
        array[4] [5] = " ";

        array[5] [0] = "*";
        array[5] [1] = " ";
        array[5] [2] = " ";
        array[5] [3] = " ";
        array[5] [4] = " ";
        array[5] [5] = " ";

        array[6] [0] = "*";
        array[6] [1] = " ";
        array[6] [2] = " ";
        array[6] [3] = " ";
        array[6] [4] = " ";
        array[6] [5] = " ";
        return array;
    }

    private static String [] [] letterQ (){
        String [] [] array = new String[7][6];
        array[0] [0] = " ";
        array[0] [1] = "*";
        array[0] [2] = "*";
        array[0] [3] = "*";
        array[0] [4] = " ";
        array[0] [5] = " ";

        array[1] [0] = "*";
        array[1] [1] = " ";
        array[1] [2] = " ";
        array[1] [3] = " ";
        array[1] [4] = "*";
        array[1] [5] = " ";

        array[2] [0] = "*";
        array[2] [1] = " ";
        array[2] [2] = " ";
        array[2] [3] = " ";
        array[2] [4] = "*";
        array[2] [5] = " ";

        array[3] [0] = "*";
        array[3] [1] = " ";
        array[3] [2] = " ";
        array[3] [3] = " ";
        array[3] [4] = "*";
        array[3] [5] = " ";

        array[4] [0] = "*";
        array[4] [1] = " ";
        array[4] [2] = "*";
        array[4] [3] = " ";
        array[4] [4] = "*";
        array[4] [5] = " ";

        array[5] [0] = "*";
        array[5] [1] = " ";
        array[5] [2] = " ";
        array[5] [3] = "*";
        array[5] [4] = " ";
        array[5] [5] = " ";

        array[6] [0] = " ";
        array[6] [1] = "*";
        array[6] [2] = "*";
        array[6] [3] = " ";
        array[6] [4] = "*";
        array[6] [5] = " ";
        return array;
    }

    private static String [] [] letterR (){
        String [] [] array = new String[7][6];
        array[0] [0] = "*";
        array[0] [1] = "*";
        array[0] [2] = "*";
        array[0] [3] = "*";
        array[0] [4] = " ";
        array[0] [5] = " ";

        array[1] [0] = "*";
        array[1] [1] = " ";
        array[1] [2] = " ";
        array[1] [3] = " ";
        array[1] [4] = "*";
        array[1] [5] = " ";

        array[2] [0] = "*";
        array[2] [1] = " ";
        array[2] [2] = " ";
        array[2] [3] = " ";
        array[2] [4] = "*";
        array[2] [5] = " ";

        array[3] [0] = "*";
        array[3] [1] = "*";
        array[3] [2] = "*";
        array[3] [3] = "*";
        array[3] [4] = " ";
        array[3] [5] = " ";

        array[4] [0] = "*";
        array[4] [1] = " ";
        array[4] [2] = "*";
        array[4] [3] = " ";
        array[4] [4] = " ";
        array[4] [5] = " ";

        array[5] [0] = "*";
        array[5] [1] = " ";
        array[5] [2] = " ";
        array[5] [3] = "*";
        array[5] [4] = " ";
        array[5] [5] = " ";

        array[6] [0] = "*";
        array[6] [1] = " ";
        array[6] [2] = " ";
        array[6] [3] = " ";
        array[6] [4] = "*";
        array[6] [5] = " ";
        return array;
    }

    private static String [] [] letterS (){
        String [] [] array = new String[7][6];
        array[0] [0] = " ";
        array[0] [1] = "*";
        array[0] [2] = "*";
        array[0] [3] = "*";
        array[0] [4] = "*";
        array[0] [5] = " ";

        array[1] [0] = "*";
        array[1] [1] = " ";
        array[1] [2] = " ";
        array[1] [3] = " ";
        array[1] [4] = " ";
        array[1] [5] = " ";

        array[2] [0] = "*";
        array[2] [1] = " ";
        array[2] [2] = " ";
        array[2] [3] = " ";
        array[2] [4] = " ";
        array[2] [5] = " ";

        array[3] [0] = " ";
        array[3] [1] = "*";
        array[3] [2] = "*";
        array[3] [3] = "*";
        array[3] [4] = " ";
        array[3] [5] = " ";

        array[4] [0] = " ";
        array[4] [1] = " ";
        array[4] [2] = " ";
        array[4] [3] = " ";
        array[4] [4] = "*";
        array[4] [5] = " ";

        array[5] [0] = " ";
        array[5] [1] = " ";
        array[5] [2] = " ";
        array[5] [3] = " ";
        array[5] [4] = "*";
        array[5] [5] = " ";

        array[6] [0] = "*";
        array[6] [1] = "*";
        array[6] [2] = "*";
        array[6] [3] = "*";
        array[6] [4] = " ";
        array[6] [5] = " ";
        return array;
    }

    private static String [] [] letterT (){
        String [] [] array = new String[7][6];
        array[0] [0] = "*";
        array[0] [1] = "*";
        array[0] [2] = "*";
        array[0] [3] = "*";
        array[0] [4] = "*";
        array[0] [5] = " ";

        array[1] [0] = " ";
        array[1] [1] = " ";
        array[1] [2] = "*";
        array[1] [3] = " ";
        array[1] [4] = " ";
        array[1] [5] = " ";

        array[2] [0] = " ";
        array[2] [1] = " ";
        array[2] [2] = "*";
        array[2] [3] = " ";
        array[2] [4] = " ";
        array[2] [5] = " ";

        array[3] [0] = " ";
        array[3] [1] = " ";
        array[3] [2] = "*";
        array[3] [3] = " ";
        array[3] [4] = " ";
        array[3] [5] = " ";

        array[4] [0] = " ";
        array[4] [1] = " ";
        array[4] [2] = "*";
        array[4] [3] = " ";
        array[4] [4] = " ";
        array[4] [5] = " ";

        array[5] [0] = " ";
        array[5] [1] = " ";
        array[5] [2] = "*";
        array[5] [3] = " ";
        array[5] [4] = " ";
        array[5] [5] = " ";

        array[6] [0] = " ";
        array[6] [1] = " ";
        array[6] [2] = "*";
        array[6] [3] = " ";
        array[6] [4] = " ";
        array[6] [5] = " ";
        return array;
    }

    private static String [] [] letterU (){
        String [] [] array = new String[7][6];
        array[0] [0] = "*";
        array[0] [1] = " ";
        array[0] [2] = " ";
        array[0] [3] = " ";
        array[0] [4] = "*";
        array[0] [5] = " ";

        array[1] [0] = "*";
        array[1] [1] = " ";
        array[1] [2] = " ";
        array[1] [3] = " ";
        array[1] [4] = "*";
        array[1] [5] = " ";

        array[2] [0] = "*";
        array[2] [1] = " ";
        array[2] [2] = " ";
        array[2] [3] = " ";
        array[2] [4] = "*";
        array[2] [5] = " ";

        array[3] [0] = "*";
        array[3] [1] = " ";
        array[3] [2] = " ";
        array[3] [3] = " ";
        array[3] [4] = "*";
        array[3] [5] = " ";

        array[4] [0] = "*";
        array[4] [1] = " ";
        array[4] [2] = " ";
        array[4] [3] = " ";
        array[4] [4] = "*";
        array[4] [5] = " ";

        array[5] [0] = "*";
        array[5] [1] = " ";
        array[5] [2] = " ";
        array[5] [3] = " ";
        array[5] [4] = "*";
        array[5] [5] = " ";

        array[6] [0] = " ";
        array[6] [1] = "*";
        array[6] [2] = "*";
        array[6] [3] = "*";
        array[6] [4] = " ";
        array[6] [5] = " ";
        return array;
    }

    private static String [] [] letterV (){
        String [] [] array = new String[7][6];
        array[0] [0] = "*";
        array[0] [1] = " ";
        array[0] [2] = " ";
        array[0] [3] = " ";
        array[0] [4] = "*";
        array[0] [5] = " ";

        array[1] [0] = "*";
        array[1] [1] = " ";
        array[1] [2] = " ";
        array[1] [3] = " ";
        array[1] [4] = "*";
        array[1] [5] = " ";

        array[2] [0] = "*";
        array[2] [1] = " ";
        array[2] [2] = " ";
        array[2] [3] = " ";
        array[2] [4] = "*";
        array[2] [5] = " ";

        array[3] [0] = "*";
        array[3] [1] = " ";
        array[3] [2] = " ";
        array[3] [3] = " ";
        array[3] [4] = "*";
        array[3] [5] = " ";

        array[4] [0] = "*";
        array[4] [1] = " ";
        array[4] [2] = " ";
        array[4] [3] = " ";
        array[4] [4] = "*";
        array[4] [5] = " ";

        array[5] [0] = " ";
        array[5] [1] = "*";
        array[5] [2] = " ";
        array[5] [3] = "*";
        array[5] [4] = " ";
        array[5] [5] = " ";

        array[6] [0] = " ";
        array[6] [1] = " ";
        array[6] [2] = "*";
        array[6] [3] = " ";
        array[6] [4] = " ";
        array[6] [5] = " ";
        return array;
    }

    private static String [] [] letterW (){
        String [] [] array = new String[7][6];
        array[0] [0] = "*";
        array[0] [1] = " ";
        array[0] [2] = " ";
        array[0] [3] = " ";
        array[0] [4] = "*";
        array[0] [5] = " ";

        array[1] [0] = "*";
        array[1] [1] = " ";
        array[1] [2] = " ";
        array[1] [3] = " ";
        array[1] [4] = "*";
        array[1] [5] = " ";

        array[2] [0] = "*";
        array[2] [1] = " ";
        array[2] [2] = " ";
        array[2] [3] = " ";
        array[2] [4] = "*";
        array[2] [5] = " ";

        array[3] [0] = "*";
        array[3] [1] = " ";
        array[3] [2] = " ";
        array[3] [3] = " ";
        array[3] [4] = "*";
        array[3] [5] = " ";

        array[4] [0] = "*";
        array[4] [1] = " ";
        array[4] [2] = "*";
        array[4] [3] = " ";
        array[4] [4] = "*";
        array[4] [5] = " ";

        array[5] [0] = "*";
        array[5] [1] = "*";
        array[5] [2] = " ";
        array[5] [3] = "*";
        array[5] [4] = "*";
        array[5] [5] = " ";

        array[6] [0] = "*";
        array[6] [1] = " ";
        array[6] [2] = " ";
        array[6] [3] = " ";
        array[6] [4] = "*";
        array[6] [5] = " ";
        return array;
    }

    private static String [] [] letterX (){
        String [] [] array = new String[7][6];
        array[0] [0] = "*";
        array[0] [1] = " ";
        array[0] [2] = " ";
        array[0] [3] = " ";
        array[0] [4] = "*";
        array[0] [5] = " ";

        array[1] [0] = "*";
        array[1] [1] = " ";
        array[1] [2] = " ";
        array[1] [3] = " ";
        array[1] [4] = "*";
        array[1] [5] = " ";

        array[2] [0] = " ";
        array[2] [1] = "*";
        array[2] [2] = " ";
        array[2] [3] = "*";
        array[2] [4] = " ";
        array[2] [5] = " ";

        array[3] [0] = " ";
        array[3] [1] = " ";
        array[3] [2] = "*";
        array[3] [3] = " ";
        array[3] [4] = " ";
        array[3] [5] = " ";

        array[4] [0] = " ";
        array[4] [1] = "*";
        array[4] [2] = " ";
        array[4] [3] = "*";
        array[4] [4] = " ";
        array[4] [5] = " ";

        array[5] [0] = "*";
        array[5] [1] = " ";
        array[5] [2] = " ";
        array[5] [3] = " ";
        array[5] [4] = "*";
        array[5] [5] = " ";

        array[6] [0] = "*";
        array[6] [1] = " ";
        array[6] [2] = " ";
        array[6] [3] = " ";
        array[6] [4] = "*";
        array[6] [5] = " ";
        return array;
    }

    private static String [] [] letterY (){
        String [] [] array = new String[7][6];
        array[0] [0] = "*";
        array[0] [1] = " ";
        array[0] [2] = " ";
        array[0] [3] = " ";
        array[0] [4] = "*";
        array[0] [5] = " ";

        array[1] [0] = "*";
        array[1] [1] = " ";
        array[1] [2] = " ";
        array[1] [3] = " ";
        array[1] [4] = "*";
        array[1] [5] = " ";

        array[2] [0] = " ";
        array[2] [1] = "*";
        array[2] [2] = " ";
        array[2] [3] = "*";
        array[2] [4] = " ";
        array[2] [5] = " ";

        array[3] [0] = " ";
        array[3] [1] = " ";
        array[3] [2] = "*";
        array[3] [3] = " ";
        array[3] [4] = " ";
        array[3] [5] = " ";

        array[4] [0] = " ";
        array[4] [1] = " ";
        array[4] [2] = "*";
        array[4] [3] = " ";
        array[4] [4] = " ";
        array[4] [5] = " ";

        array[5] [0] = " ";
        array[5] [1] = " ";
        array[5] [2] = "*";
        array[5] [3] = " ";
        array[5] [4] = " ";
        array[5] [5] = " ";

        array[6] [0] = " ";
        array[6] [1] = " ";
        array[6] [2] = "*";
        array[6] [3] = " ";
        array[6] [4] = " ";
        array[6] [5] = " ";
        return array;
    }

    private static String [] [] letterZ (){
        String [] [] array = new String[7][6];
        array[0] [0] = "*";
        array[0] [1] = "*";
        array[0] [2] = "*";
        array[0] [3] = "*";
        array[0] [4] = "*";
        array[0] [5] = " ";

        array[1] [0] = " ";
        array[1] [1] = " ";
        array[1] [2] = " ";
        array[1] [3] = " ";
        array[1] [4] = "*";
        array[1] [5] = " ";

        array[2] [0] = " ";
        array[2] [1] = " ";
        array[2] [2] = " ";
        array[2] [3] = "*";
        array[2] [4] = " ";
        array[2] [5] = " ";

        array[3] [0] = " ";
        array[3] [1] = " ";
        array[3] [2] = "*";
        array[3] [3] = " ";
        array[3] [4] = " ";
        array[3] [5] = " ";

        array[4] [0] = " ";
        array[4] [1] = "*";
        array[4] [2] = " ";
        array[4] [3] = " ";
        array[4] [4] = " ";
        array[4] [5] = " ";

        array[5] [0] = "*";
        array[5] [1] = " ";
        array[5] [2] = " ";
        array[5] [3] = " ";
        array[5] [4] = " ";
        array[5] [5] = " ";

        array[6] [0] = "*";
        array[6] [1] = "*";
        array[6] [2] = "*";
        array[6] [3] = "*";
        array[6] [4] = "*";
        array[6] [5] = " ";
        return array;
    }

    private static String [] [] numberZero (){
        String [] [] array = new String[7][6];
        array[0] [0] = " ";
        array[0] [1] = "*";
        array[0] [2] = "*";
        array[0] [3] = "*";
        array[0] [4] = " ";
        array[0] [5] = " ";

        array[1] [0] = "*";
        array[1] [1] = " ";
        array[1] [2] = " ";
        array[1] [3] = " ";
        array[1] [4] = "*";
        array[1] [5] = " ";

        array[2] [0] = "*";
        array[2] [1] = " ";
        array[2] [2] = " ";
        array[2] [3] = "*";
        array[2] [4] = "*";
        array[2] [5] = " ";

        array[3] [0] = "*";
        array[3] [1] = " ";
        array[3] [2] = "*";
        array[3] [3] = " ";
        array[3] [4] = "*";
        array[3] [5] = " ";

        array[4] [0] = "*";
        array[4] [1] = "*";
        array[4] [2] = " ";
        array[4] [3] = " ";
        array[4] [4] = "*";
        array[4] [5] = " ";

        array[5] [0] = "*";
        array[5] [1] = " ";
        array[5] [2] = " ";
        array[5] [3] = " ";
        array[5] [4] = "*";
        array[5] [5] = " ";

        array[6] [0] = " ";
        array[6] [1] = "*";
        array[6] [2] = "*";
        array[6] [3] = "*";
        array[6] [4] = " ";
        array[6] [5] = " ";
        return array;
    }

    private static String [] [] numberOne (){
        String [] [] array = new String[7][6];
        array[0] [0] = " ";
        array[0] [1] = " ";
        array[0] [2] = "*";
        array[0] [3] = " ";
        array[0] [4] = " ";
        array[0] [5] = " ";

        array[1] [0] = " ";
        array[1] [1] = "*";
        array[1] [2] = "*";
        array[1] [3] = " ";
        array[1] [4] = " ";
        array[1] [5] = " ";

        array[2] [0] = "*";
        array[2] [1] = " ";
        array[2] [2] = "*";
        array[2] [3] = " ";
        array[2] [4] = " ";
        array[2] [5] = " ";

        array[3] [0] = " ";
        array[3] [1] = " ";
        array[3] [2] = "*";
        array[3] [3] = " ";
        array[3] [4] = " ";
        array[3] [5] = " ";

        array[4] [0] = " ";
        array[4] [1] = " ";
        array[4] [2] = "*";
        array[4] [3] = " ";
        array[4] [4] = " ";
        array[4] [5] = " ";

        array[5] [0] = " ";
        array[5] [1] = " ";
        array[5] [2] = "*";
        array[5] [3] = " ";
        array[5] [4] = " ";
        array[5] [5] = " ";

        array[6] [0] = "*";
        array[6] [1] = "*";
        array[6] [2] = "*";
        array[6] [3] = "*";
        array[6] [4] = "*";
        array[6] [5] = " ";
        return array;
    }

    private static String [] [] numberTwo (){
        String [] [] array = new String[7][6];
        array[0] [0] = " ";
        array[0] [1] = "*";
        array[0] [2] = "*";
        array[0] [3] = "*";
        array[0] [4] = " ";
        array[0] [5] = " ";

        array[1] [0] = "*";
        array[1] [1] = " ";
        array[1] [2] = " ";
        array[1] [3] = " ";
        array[1] [4] = "*";
        array[1] [5] = " ";

        array[2] [0] = " ";
        array[2] [1] = " ";
        array[2] [2] = " ";
        array[2] [3] = " ";
        array[2] [4] = "*";
        array[2] [5] = " ";

        array[3] [0] = " ";
        array[3] [1] = " ";
        array[3] [2] = " ";
        array[3] [3] = "*";
        array[3] [4] = " ";
        array[3] [5] = " ";

        array[4] [0] = " ";
        array[4] [1] = " ";
        array[4] [2] = "*";
        array[4] [3] = " ";
        array[4] [4] = " ";
        array[4] [5] = " ";

        array[5] [0] = " ";
        array[5] [1] = "*";
        array[5] [2] = " ";
        array[5] [3] = " ";
        array[5] [4] = " ";
        array[5] [5] = " ";

        array[6] [0] = "*";
        array[6] [1] = "*";
        array[6] [2] = "*";
        array[6] [3] = "*";
        array[6] [4] = "*";
        array[6] [5] = " ";
        return array;
    }

    private static String [] [] numberThree (){
        String [] [] array = new String[7][6];
        array[0] [0] = " ";
        array[0] [1] = "*";
        array[0] [2] = "*";
        array[0] [3] = "*";
        array[0] [4] = " ";
        array[0] [5] = " ";

        array[1] [0] = "*";
        array[1] [1] = " ";
        array[1] [2] = " ";
        array[1] [3] = " ";
        array[1] [4] = "*";
        array[1] [5] = " ";

        array[2] [0] = " ";
        array[2] [1] = " ";
        array[2] [2] = " ";
        array[2] [3] = " ";
        array[2] [4] = "*";
        array[2] [5] = " ";

        array[3] [0] = " ";
        array[3] [1] = " ";
        array[3] [2] = "*";
        array[3] [3] = "*";
        array[3] [4] = " ";
        array[3] [5] = " ";

        array[4] [0] = " ";
        array[4] [1] = " ";
        array[4] [2] = " ";
        array[4] [3] = " ";
        array[4] [4] = "*";
        array[4] [5] = " ";

        array[5] [0] = "*";
        array[5] [1] = " ";
        array[5] [2] = " ";
        array[5] [3] = " ";
        array[5] [4] = "*";
        array[5] [5] = " ";

        array[6] [0] = " ";
        array[6] [1] = "*";
        array[6] [2] = "*";
        array[6] [3] = "*";
        array[6] [4] = " ";
        array[6] [5] = " ";
        return array;
    }

    private static String [] [] numberFour (){
        String [] [] array = new String[7][6];
        array[0] [0] = "*";
        array[0] [1] = " ";
        array[0] [2] = " ";
        array[0] [3] = " ";
        array[0] [4] = "*";
        array[0] [5] = " ";

        array[1] [0] = "*";
        array[1] [1] = " ";
        array[1] [2] = " ";
        array[1] [3] = " ";
        array[1] [4] = "*";
        array[1] [5] = " ";

        array[2] [0] = "*";
        array[2] [1] = " ";
        array[2] [2] = " ";
        array[2] [3] = " ";
        array[2] [4] = "*";
        array[2] [5] = " ";

        array[3] [0] = " ";
        array[3] [1] = "*";
        array[3] [2] = "*";
        array[3] [3] = "*";
        array[3] [4] = "*";
        array[3] [5] = " ";

        array[4] [0] = " ";
        array[4] [1] = " ";
        array[4] [2] = " ";
        array[4] [3] = " ";
        array[4] [4] = "*";
        array[4] [5] = " ";

        array[5] [0] = " ";
        array[5] [1] = " ";
        array[5] [2] = " ";
        array[5] [3] = " ";
        array[5] [4] = "*";
        array[5] [5] = " ";

        array[6] [0] = " ";
        array[6] [1] = " ";
        array[6] [2] = " ";
        array[6] [3] = " ";
        array[6] [4] = "*";
        array[6] [5] = " ";
        return array;
    }

    private static String [] [] numberFive (){
        String [] [] array = new String[7][6];
        array[0] [0] = "*";
        array[0] [1] = "*";
        array[0] [2] = "*";
        array[0] [3] = "*";
        array[0] [4] = "*";
        array[0] [5] = " ";

        array[1] [0] = "*";
        array[1] [1] = " ";
        array[1] [2] = " ";
        array[1] [3] = " ";
        array[1] [4] = " ";
        array[1] [5] = " ";

        array[2] [0] = "*";
        array[2] [1] = " ";
        array[2] [2] = " ";
        array[2] [3] = " ";
        array[2] [4] = " ";
        array[2] [5] = " ";

        array[3] [0] = "*";
        array[3] [1] = "*";
        array[3] [2] = "*";
        array[3] [3] = "*";
        array[3] [4] = " ";
        array[3] [5] = " ";

        array[4] [0] = " ";
        array[4] [1] = " ";
        array[4] [2] = " ";
        array[4] [3] = " ";
        array[4] [4] = "*";
        array[4] [5] = " ";

        array[5] [0] = " ";
        array[5] [1] = " ";
        array[5] [2] = " ";
        array[5] [3] = " ";
        array[5] [4] = "*";
        array[5] [5] = " ";

        array[6] [0] = "*";
        array[6] [1] = "*";
        array[6] [2] = "*";
        array[6] [3] = "*";
        array[6] [4] = " ";
        array[6] [5] = " ";
        return array;
    }

    private static String [] [] numberSix (){
        String [] [] array = new String[7][6];
        array[0] [0] = " ";
        array[0] [1] = "*";
        array[0] [2] = "*";
        array[0] [3] = "*";
        array[0] [4] = " ";
        array[0] [5] = " ";

        array[1] [0] = "*";
        array[1] [1] = " ";
        array[1] [2] = " ";
        array[1] [3] = " ";
        array[1] [4] = "*";
        array[1] [5] = " ";

        array[2] [0] = "*";
        array[2] [1] = " ";
        array[2] [2] = " ";
        array[2] [3] = " ";
        array[2] [4] = " ";
        array[2] [5] = " ";

        array[3] [0] = "*";
        array[3] [1] = "*";
        array[3] [2] = "*";
        array[3] [3] = "*";
        array[3] [4] = " ";
        array[3] [5] = " ";

        array[4] [0] = "*";
        array[4] [1] = " ";
        array[4] [2] = " ";
        array[4] [3] = " ";
        array[4] [4] = "*";
        array[4] [5] = " ";

        array[5] [0] = "*";
        array[5] [1] = " ";
        array[5] [2] = " ";
        array[5] [3] = " ";
        array[5] [4] = "*";
        array[5] [5] = " ";

        array[6] [0] = " ";
        array[6] [1] = "*";
        array[6] [2] = "*";
        array[6] [3] = "*";
        array[6] [4] = " ";
        array[6] [5] = " ";
        return array;
    }

    private static String [] [] numberSeven (){
        String [] [] array = new String[7][6];
        array[0] [0] = "*";
        array[0] [1] = "*";
        array[0] [2] = "*";
        array[0] [3] = "*";
        array[0] [4] = "*";
        array[0] [5] = " ";

        array[1] [0] = " ";
        array[1] [1] = " ";
        array[1] [2] = " ";
        array[1] [3] = " ";
        array[1] [4] = "*";
        array[1] [5] = " ";

        array[2] [0] = " ";
        array[2] [1] = " ";
        array[2] [2] = " ";
        array[2] [3] = "*";
        array[2] [4] = " ";
        array[2] [5] = " ";

        array[3] [0] = " ";
        array[3] [1] = " ";
        array[3] [2] = "*";
        array[3] [3] = " ";
        array[3] [4] = " ";
        array[3] [5] = " ";

        array[4] [0] = " ";
        array[4] [1] = " ";
        array[4] [2] = "*";
        array[4] [3] = " ";
        array[4] [4] = " ";
        array[4] [5] = " ";

        array[5] [0] = " ";
        array[5] [1] = " ";
        array[5] [2] = "*";
        array[5] [3] = " ";
        array[5] [4] = " ";
        array[5] [5] = " ";

        array[6] [0] = " ";
        array[6] [1] = " ";
        array[6] [2] = "*";
        array[6] [3] = " ";
        array[6] [4] = " ";
        array[6] [5] = " ";
        return array;
    }

    private static String [] [] numberEight (){
        String [] [] array = new String[7][6];
        array[0] [0] = " ";
        array[0] [1] = "*";
        array[0] [2] = "*";
        array[0] [3] = "*";
        array[0] [4] = " ";
        array[0] [5] = " ";

        array[1] [0] = "*";
        array[1] [1] = " ";
        array[1] [2] = " ";
        array[1] [3] = " ";
        array[1] [4] = "*";
        array[1] [5] = " ";

        array[2] [0] = "*";
        array[2] [1] = " ";
        array[2] [2] = " ";
        array[2] [3] = " ";
        array[2] [4] = "*";
        array[2] [5] = " ";

        array[3] [0] = " ";
        array[3] [1] = "*";
        array[3] [2] = "*";
        array[3] [3] = "*";
        array[3] [4] = " ";
        array[3] [5] = " ";

        array[4] [0] = "*";
        array[4] [1] = " ";
        array[4] [2] = " ";
        array[4] [3] = " ";
        array[4] [4] = "*";
        array[4] [5] = " ";

        array[5] [0] = "*";
        array[5] [1] = " ";
        array[5] [2] = " ";
        array[5] [3] = " ";
        array[5] [4] = "*";
        array[5] [5] = " ";

        array[6] [0] = " ";
        array[6] [1] = "*";
        array[6] [2] = "*";
        array[6] [3] = "*";
        array[6] [4] = " ";
        array[6] [5] = " ";
        return array;
    }

    private static String [] [] numberNine (){
        String [] [] array = new String[7][6];
        array[0] [0] = " ";
        array[0] [1] = "*";
        array[0] [2] = "*";
        array[0] [3] = "*";
        array[0] [4] = " ";
        array[0] [5] = " ";

        array[1] [0] = "*";
        array[1] [1] = " ";
        array[1] [2] = " ";
        array[1] [3] = " ";
        array[1] [4] = "*";
        array[1] [5] = " ";

        array[2] [0] = "*";
        array[2] [1] = " ";
        array[2] [2] = " ";
        array[2] [3] = " ";
        array[2] [4] = "*";
        array[2] [5] = " ";

        array[3] [0] = " ";
        array[3] [1] = "*";
        array[3] [2] = "*";
        array[3] [3] = "*";
        array[3] [4] = "*";
        array[3] [5] = " ";

        array[4] [0] = " ";
        array[4] [1] = " ";
        array[4] [2] = " ";
        array[4] [3] = " ";
        array[4] [4] = "*";
        array[4] [5] = " ";

        array[5] [0] = "*";
        array[5] [1] = " ";
        array[5] [2] = " ";
        array[5] [3] = " ";
        array[5] [4] = "*";
        array[5] [5] = " ";

        array[6] [0] = " ";
        array[6] [1] = "*";
        array[6] [2] = "*";
        array[6] [3] = "*";
        array[6] [4] = " ";
        array[6] [5] = " ";
        return array;
    }

    private static String [] [] numberFree (){
        String [] [] array = new String[7][6];
        array[0] [0] = " ";
        array[0] [1] = " ";
        array[0] [2] = " ";
        array[0] [3] = " ";
        array[0] [4] = " ";
        array[0] [5] = " ";

        array[1] [0] = " ";
        array[1] [1] = " ";
        array[1] [2] = " ";
        array[1] [3] = " ";
        array[1] [4] = " ";
        array[1] [5] = " ";

        array[2] [0] = " ";
        array[2] [1] = " ";
        array[2] [2] = " ";
        array[2] [3] = " ";
        array[2] [4] = " ";
        array[2] [5] = " ";

        array[3] [0] = " ";
        array[3] [1] = " ";
        array[3] [2] = " ";
        array[3] [3] = " ";
        array[3] [4] = " ";
        array[3] [5] = " ";

        array[4] [0] = " ";
        array[4] [1] = " ";
        array[4] [2] = " ";
        array[4] [3] = " ";
        array[4] [4] = " ";
        array[4] [5] = " ";

        array[5] [0] = " ";
        array[5] [1] = " ";
        array[5] [2] = " ";
        array[5] [3] = " ";
        array[5] [4] = " ";
        array[5] [5] = " ";

        array[6] [0] = " ";
        array[6] [1] = " ";
        array[6] [2] = " ";
        array[6] [3] = " ";
        array[6] [4] = " ";
        array[6] [5] = " ";
        return array;
    }

    private static String [] [] symbolQuestion (){
        String [] [] array = new String[7][6];
        array[0] [0] = " ";
        array[0] [1] = "*";
        array[0] [2] = "*";
        array[0] [3] = "*";
        array[0] [4] = " ";
        array[0] [5] = " ";

        array[1] [0] = "*";
        array[1] [1] = " ";
        array[1] [2] = " ";
        array[1] [3] = " ";
        array[1] [4] = "*";
        array[1] [5] = " ";

        array[2] [0] = "*";
        array[2] [1] = " ";
        array[2] [2] = " ";
        array[2] [3] = " ";
        array[2] [4] = "*";
        array[2] [5] = " ";

        array[3] [0] = " ";
        array[3] [1] = " ";
        array[3] [2] = " ";
        array[3] [3] = "*";
        array[3] [4] = " ";
        array[3] [5] = " ";

        array[4] [0] = " ";
        array[4] [1] = " ";
        array[4] [2] = "*";
        array[4] [3] = " ";
        array[4] [4] = " ";
        array[4] [5] = " ";

        array[5] [0] = " ";
        array[5] [1] = " ";
        array[5] [2] = " ";
        array[5] [3] = " ";
        array[5] [4] = " ";
        array[5] [5] = " ";

        array[6] [0] = " ";
        array[6] [1] = " ";
        array[6] [2] = "*";
        array[6] [3] = " ";
        array[6] [4] = " ";
        array[6] [5] = " ";
        return array;
    }

    private static String [] [] symbolWTF (){
        String [] [] array = new String[7][1];
        array[0] [0] = "*";

        array[1] [0] = "*";

        array[2] [0] = "*";

        array[3] [0] = "*";

        array[4] [0] = "*";

        array[5] [0] = " ";

        array[6] [0] = "*";
        return array;
    }

    private static String [] [] symbolBrackets1 (){
        String [] [] array = new String[7][2];
        array[0] [0] = " ";
        array[0] [1] = "*";

        array[1] [0] = "*";
        array[1] [1] = " ";

        array[2] [0] = "*";
        array[2] [1] = " ";

        array[3] [0] = "*";
        array[3] [1] = " ";

        array[4] [0] = "*";
        array[4] [1] = " ";

        array[5] [0] = "*";
        array[5] [1] = " ";

        array[6] [0] = " ";
        array[6] [1] = "*";
        return array;
    }

    private static String [] [] symbolBrackets2 (){
        String [] [] array = new String[7][2];
        array[0] [0] = "*";
        array[0] [1] = " ";

        array[1] [0] = " ";
        array[1] [1] = "*";

        array[2] [0] = " ";
        array[2] [1] = "*";

        array[3] [0] = " ";
        array[3] [1] = "*";

        array[4] [0] = " ";
        array[4] [1] = "*";

        array[5] [0] = " ";
        array[5] [1] = "*";

        array[6] [0] = "*";
        array[6] [1] = " ";
        return array;
    }

    private static String [] [] symbolPoint (){
        String [] [] array = new String[7][2];
        array[0] [0] = " ";
        array[0] [1] = " ";

        array[1] [0] = " ";
        array[1] [1] = " ";

        array[2] [0] = " ";
        array[2] [1] = " ";

        array[3] [0] = " ";
        array[3] [1] = " ";

        array[4] [0] = " ";
        array[4] [1] = " ";

        array[5] [0] = "*";
        array[5] [1] = "*";

        array[6] [0] = "*";
        array[6] [1] = "*";
        return array;
    }
}
