package org.practicalsolutions.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TasksTest {
        private Tasks tasks;
        private String string;
        private String [] arrString;
        private int [] arrInt;

    @Before
    public void setUp() throws Exception {
        tasks = new Tasks();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void fizzArray1() {
        arrInt = new int[2];
        arrInt[0] = 0;
        arrInt[1] = 1;
        assertArrayEquals(arrInt,tasks.fizzArray1(2));
    }

    @Test
    public void fizzArray2() {
    }

    @Test
    public void fizzArray3() {
        arrInt = new int[4];
        arrInt[0] = 1;
        arrInt[1] = 2;
        arrInt[2] = 3;
        arrInt[3] = 4;
        assertArrayEquals(arrInt,tasks.fizzArray3(1,5));
    }

    @Test
    public void fizzBuzz() {
        arrString = new String [3];
        arrString[0] = "1";
        arrString[1] = "2";
        arrString[2] = "Fizz";
        assertArrayEquals(arrString,tasks.fizzBuzz(1,4));
    }

    @Test
    public void swapVariable() {
        string = "For now first number: 2 second number: 1";
        assertEquals(string,tasks.swapVariable(1,2));
    }
}