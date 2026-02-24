package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class getUpperBoundTest {

	private Range range;
	
	
	@Test
	void testNegativeValuesForGetUpperBound() {
		range = new Range (-300.0, -10.0);
		assertEquals(-10.0, range.getUpperBound());	
	}
	

	@Test
	void testPositiveValuesForGetUpperBound() {
		range = new Range(30.0,300.0);
		assertEquals(300.0, range.getUpperBound());	
	}
	
	@Test
	void testSameUpperAndLowerValuesForGetUpperBound() {
		range = new Range (30.0,30.0);
		assertEquals(30.0, range.getUpperBound());
	}
	
	@Test
    void testCrossZeroValuesForGetUpperBound() {
        range = new Range(-50.0, 100.0);
        assertEquals(100.0, range.getUpperBound());
    }
	
	@Test
	void testDecimalValuesForGetUpperBound() {
        range = new Range(2.75, 9.99);
        assertEquals(9.99, range.getUpperBound());
    }
	
	@Test
	void testLargeMagnitudeValuesForGetUpperBound() {
	     range = new Range(-1_000_000.0, 1_000_000.0);
	     assertEquals(1_000_000.0, range.getUpperBound());
	}
	
	
	

}
