package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class getLowerBoundTest {

	private Range range;
	
	
	@Test
	void testNegativeValuesForGetLowerBound() {
		range = new Range (-300.0, -10.0);
		assertEquals(-300, range.getLowerBound());
	}
	

	@Test
	void testPositiveValuesForGetLowerBound() {
		range = new Range(30.0,300.0);
		assertEquals(30, range.getLowerBound());
	}
	
	@Test
	void testSameUpperAndLowerValuesForGetLowerBound() {
		range = new Range (30,30);
		assertEquals(30, range.getLowerBound());
	}
	
	@Test
	void testCrossZeroValuesForGetLowerBound() {
		range = new Range(-50.0, 100.0);
        assertEquals(-50.0, range.getLowerBound());
		
	}
	
	@Test
    void testDecimalValuesForGetLowerBound() {
        range = new Range(2.75, 9.99);
        assertEquals(2.75, range.getLowerBound());
    }
	
	@Test
    void testVerySmallDecimalValuesForGetLowerBound() {
        range = new Range(0.0002, 0.0009);
        assertEquals(0.0002, range.getLowerBound());
    }
	
	@Test
    void testLargeMagnitudeValuesForGetLowerBound() {
        range = new Range(-1_000_000_000.0, 1_000_000_000.0);
        assertEquals(-1_000_000_000.0, range.getLowerBound());
    }
}
