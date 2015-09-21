package com.apiumtech.tdd.kata;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NumberFilterTest {
    
    NumberFilter classUnderTest;

    @Before
    public void setUp() throws Exception {
        classUnderTest = new NumberFilter();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testFilterShouldSuccessful() {
        String stringInput = "1,a,2,b,3";
        try {
            String numberStringResult = classUnderTest.Filter(stringInput);

            assertEquals("1,2,3", numberStringResult);
        } catch (Exception e) {
            fail("have an exception");
        }
        
    }
    
    @Test
    public void testFilterShouldSuccessfulWithOneChar() {
        String stringInput = "a";
        try {
            String nuberStringResult = classUnderTest.Filter(stringInput);

            assertEquals("", nuberStringResult);
        } catch (Exception e) {
            fail("have an exception");
        }
        
    }
    
    @Test
    public void testFilterShouldSuccessfulWithCommas() {
        String stringInput = ",";
        try {
            String nuberStringResult = classUnderTest.Filter(stringInput);

            assertEquals("", nuberStringResult);
        } catch (Exception e) {
            fail("have an exception");
        }
        
    }

}
