package org.practicalsolutions.service;

public class AnotherTasks {
    public static void main(String[] args) {
        /*first task with label*/
        /*big_loop:
        for (int i=0; i<3;i++){
            try {
                for (int j=0; j<3;j++){
                    if (i==j) continue ;
                    else if (i>j) continue big_loop;
                    System.out.println("A");
                }
            } finally {
                System.out.println("B");
            }
            System.out.println("C");
        }*/

        /*first task with label*/
        /*
        System.out.println("this is start");
        blablabla:
        for (int i=0; i == 22; i++) {
            System.out.println("this is i: "+i);
            if (i >11) {
                System.out.println("this is from if where condition i>11: ");
                break blablabla;
            }
        }*/

        /*int i, j = 0;
        label: for (i = 0; i < 10; i++)
        {
            for (j = 0; j < 10; j++)
            {
                if (i == 5 && j == 5)
                {
                    break label;
                }
            }
        }
        System.out.println(i + " " + j);*/


        label: for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                System.out.print(" second: "+j);
                if(i == 5) {
                    System.out.println(" if i == 5 ");
                    continue label;
                }
            }
            System.out.println("\n"+i);
        }

        http://dr-magic.blogspot.com/
        System.out.println("Hello World!");


    }
}

class MainClass {
    /*public static void test(int ...a) {
        System.out.println("int...");
    }*/
    static  short s=17;

    public static void test(Integer ...a) {
        System.out.println("Integer...");
    }

    public static void test(Number ...a) {
        System.out.println("Number...");
    }

    public static void test(Object ...a) {
        System.out.println("Object...");
    }

    public static void main(String args[]) {
        String sttttt = new String("aaaa");
        String ssssssss = "aaaa";
        System.out.println(sttttt);
        System.out.println(ssssssss.equals(sttttt)+" ");











        Number n = new Integer(1);
        test(n.intValue());
        int f;
        f = 3;
        f = ++f + f++;
        System.out.println(f);
        System.out.println(23 | 43);

        int nk = 33;
        int s = 0;
        while (nk > 0) {
            s += nk % 2;
            System.out.println("this is: s += nk % 2 "+(s += nk % 2));
            nk /= 2;
            System.out.println("this is nk/=2 "+(nk /= 2));
        }
        System.out.println(s);
        System.out.printf("%2.6f", Math.PI);
        String value = "29.1";
        float bbbbbla = 20.333f;
        System.out.println(bbbbbla);
        System.out.println((Float.valueOf(value) + 1.0) == 30.1);
        System.out.println((Double.valueOf(value) + 1.0) == 30.1);
    }
}
