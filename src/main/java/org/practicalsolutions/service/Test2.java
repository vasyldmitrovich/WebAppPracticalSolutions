package org.practicalsolutions.service;

import java.util.Arrays;
public class Test2 {

    public static void main(String[] args) {

        int [] arrayFirst = {1,2,3,4,5,6,7,8,9,0};
        System.out.println("length array is:"+arrayFirst.length);
        for (int i : arrayFirst
             ) {
            System.out.print(arrayFirst[i]+" ");
        }
        System.out.println();
        for (int j=0; j<arrayFirst.length;j++){
            System.out.print(arrayFirst[j]+" ");
        }
        System.out.println();
        System.out.println("than we will be doing arraycopy from arrayFirst to arraySecond");
        int [] arraySecond = new int[10];
        System.arraycopy(arrayFirst,2,arraySecond,0,8);
        for (int k = 0 ; k < arraySecond.length;k++){
            System.out.print(arraySecond[k]+" ");
        }
        System.out.println();
        System.out.println("copyOfRang from arraySecond to arrayThird");
        int [] arrayThird = new int[10];
        arrayThird = Arrays.copyOfRange(arraySecond,2,10);
        for (int s = 0; s<arrayThird.length; s++){
            System.out.print(arrayThird[s]+" ");
        }
        System.out.println();
        System.out.println("length arrayThird:"+ arrayThird.length);


        /*int [][] twoDimensionArray;
        twoDimensionArray = new int[][] { {1, 2, 3}, {4,5,6} };
        System.out.println("this is 0 0 : "+twoDimensionArray[0][0]);
        System.out.println("this is 1 0 : "+twoDimensionArray[1][0]);
        System.out.println("this is 0 1 : "+twoDimensionArray[0][1]);
        System.out.println("this is 1 1 : "+twoDimensionArray[1][1]);
        System.out.println("this is 0 2 : "+twoDimensionArray[0][2]);
        System.out.println("this is 1 2 : "+twoDimensionArray[1][2]);*/


        /*
        bla:
        for (int l=0;l<=3;l++){
            System.out.println("l first for: "+l);
            for (int k = 0; k <=3; k++){
                System.out.println("k from second for: "+k);
                if (l >1){
                    continue bla;
                }
            }
        }
*/


        /*int[] arrayOfInts= { 32, 87, 3, 589,12, 1076, 2000,8, 622, 127 };
        int searchfor= 12;
        int i;
        boolean foundIt= false;
        blablabla:
        for (i= 0; i< arrayOfInts.length; i++) {
            if (arrayOfInts[i] == searchfor) {
                foundIt= true;
                System.out.println("this is: "+searchfor+" this is place: "+i);
                continue blablabla;
            }
            System.out.println(i);
        }*/


    }

}

