package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class expandToIncludeTest {

	private Range exampleRange;

	// Test Case #1: ExpandToInclude(Range range, double value)
	@Test
	void testExpandToIncludeWithNullRange() {
		Range result = Range.expandToInclude(null, 5.0);
		assertEquals(5.0, result.getLowerBound());
		assertEquals(5.0, result.getUpperBound());
	}

	@Test
	void testExpandToIncludeValueInsideRange() {
		exampleRange = new Range(2.0, 6.0);
		Range result = Range.expandToInclude(exampleRange, 4.0);

		assertEquals(2.0, result.getLowerBound());
		assertEquals(6.0, result.getUpperBound());
	}

	@Test
	void testExpandToIncludeValueBelowLowerBound() {
		exampleRange = new Range(2.0, 6.0);
		Range result = Range.expandToInclude(exampleRange, 1.0);

		assertEquals(1.0, result.getLowerBound());
		assertEquals(6.0, result.getUpperBound());
	}

	@Test
	void testExpandToIncludeValueAboveUpperBound() {
		exampleRange = new Range(2.0, 6.0);
		Range result = Range.expandToInclude(exampleRange, 8.0);

		assertEquals(2.0, result.getLowerBound());
		assertEquals(8.0, result.getUpperBound());
	}

}
