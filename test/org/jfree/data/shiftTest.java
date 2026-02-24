package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class shiftTest {
	
	private Range baseRange;
	private Range shiftedRange;

	@Test
	void testPostiveShift() {
		baseRange = new Range(10.0, 20.0);
		shiftedRange = Range.shift(baseRange, 5.0);		
		assertEquals(15.0, shiftedRange.getLowerBound());
		assertEquals(25.0, shiftedRange.getUpperBound());
		
		
	}
	
	@Test
	void testNegativeShift() {
		baseRange = new Range(10.0, 20.0);
		shiftedRange = Range.shift(baseRange, -5.0);	
		assertEquals(5.0, shiftedRange.getLowerBound());
		assertEquals(15.0, shiftedRange.getUpperBound());
		
		
	}
	
	@Test
	void TestZeroShift(){
		baseRange = new Range(10.0, 20.0);
		shiftedRange = Range.shift(baseRange, 0.0);	
		assertEquals(10.0, shiftedRange.getLowerBound());
		assertEquals(20.0, shiftedRange.getUpperBound());
	}
	
	@Test
	
	void testDecimalShift() {
		baseRange = new Range(9.5, 19.5);
		shiftedRange = Range.shift(baseRange, 0.5);	
		assertEquals(10.0, shiftedRange.getLowerBound());
		assertEquals(20.0, shiftedRange.getUpperBound());
		
	}

}
