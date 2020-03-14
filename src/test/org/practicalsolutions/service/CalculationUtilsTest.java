package org.practicalsolutions.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculationUtilsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void add() {
        assertEquals(10,CalculationUtils.add(5,5));
    }

    @Test
    public void sub() {
        assertEquals(8,CalculationUtils.sub(10,2));
    }
}