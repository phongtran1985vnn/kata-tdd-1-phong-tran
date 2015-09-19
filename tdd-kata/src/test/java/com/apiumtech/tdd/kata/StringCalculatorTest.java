package com.apiumtech.tdd.kata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {

	StringCalculator classUnderTest;

	@Before
	public void setUp() throws Exception {
		classUnderTest = new StringCalculator();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddShouldSuccessfulWithEmptyString() {
		String numbers = "";
		try {
			int stringCalculator = classUnderTest.Add(numbers);

			assertEquals(0, stringCalculator);
		} catch (Exception e) {
			fail("have an exception");
		}
	}

	@Test
	public void testAddShouldSuccessfulWithOneNumber() {
		String numbers = "1";
		try {
			int stringCalculator = classUnderTest.Add(numbers);

			assertEquals(1, stringCalculator);
		} catch (Exception e) {
			fail("have an exception");
		}
	}

	@Test
	public void testAddShouldSuccessfulWithTwoNumber() {
		String numbers = "1,2";
		try {
			int stringCalculator = classUnderTest.Add(numbers);

			assertEquals(3, stringCalculator);
		} catch (Exception e) {
			fail("have an exception");
		}
	}
}
