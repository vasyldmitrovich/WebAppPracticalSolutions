package org.practicalsolutions.service;

import org.junit.Test;

import static org.junit.Assert.*;


public class CalculationUtilsTest {


    @Test
    public void add() {
        assertEquals(10, CalculationUtils.add(8, 2));
    }

    @Test
    public void sub() {
        assertEquals(6, CalculationUtils.sub(8, 2));
    }
}
