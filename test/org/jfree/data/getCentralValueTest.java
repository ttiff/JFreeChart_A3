package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class getCentralValueTest {
	
	private Range exampleRange;

	// Test Case #2: getCentralValue()
	@Test
	void testGetCentralValuePositiveRange() {
		exampleRange = new Range(2.0, 6.0);
		assertEquals(4.0, exampleRange.getCentralValue());
	}

	@Test
	void testGetCentralValueCrossingZero() {
		exampleRange = new Range(-2.0, 2.0);
		assertEquals(0.0, exampleRange.getCentralValue());
	}

	@Test
	void testGetCentralValueNegativeRange() {
		exampleRange = new Range(-6.0, -2.0);
		assertEquals(-4.0, exampleRange.getCentralValue());
	}

	@Test
	void testGetCentralValueZeroLengthRange() {
		exampleRange = new Range(5.0, 5.0);
		assertEquals(5.0, exampleRange.getCentralValue());
	}

}
