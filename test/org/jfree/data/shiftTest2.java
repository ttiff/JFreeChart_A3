package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class shiftTest2 {

	private Range exampleRange;

	// Test Case #4:shift(Range base, double delta, boolean allowZeroCrossing)
	@Test
	void testShiftWithZeroCrossing() {
		exampleRange = new Range(-2.0, 2.0);
		Range result = Range.shift(exampleRange, 5.0, true);
		assertEquals(3.0, result.getLowerBound());
	}

	@Test
	void testShiftAllowZeroCrossingTrue() {
		exampleRange = new Range(-2.0, 2.0);
		Range result = Range.shift(exampleRange, 3.0, true);

		assertEquals(1.0, result.getLowerBound());
		assertEquals(5.0, result.getUpperBound());
	}

	@Test
	void testShiftZeroCrossingNotAllowedNegativeToPositive() {
		exampleRange = new Range(-2.0, 2.0);
		Range result = Range.shift(exampleRange, 3.0, false);

		assertEquals(0.0, result.getLowerBound());
		assertEquals(5.0, result.getUpperBound());
	}

	@Test
	void testShiftZeroCrossingNotAllowedPositiveToNegative() {
		exampleRange = new Range(2.0, 4.0);
		Range result = Range.shift(exampleRange, -5.0, false);

		assertEquals(0.0, result.getLowerBound());
		assertEquals(0.0, result.getUpperBound());
	}

	@Test
	void testShiftWithoutCrossingZero() {
		exampleRange = new Range(2.0, 4.0);
		Range result = Range.shift(exampleRange, 2.0, false);

		assertEquals(4.0, result.getLowerBound());
		assertEquals(6.0, result.getUpperBound());
	}

}
