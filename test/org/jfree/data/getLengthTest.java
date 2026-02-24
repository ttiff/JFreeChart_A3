package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class getLengthTest {
	
	private Range exampleRange;

	// Test Case #3: getLength()
	@Test
	void testGetLengthNormalRange() {
		exampleRange = new Range(2.0, 6.0);
		assertEquals(4.0, exampleRange.getLength());
	}

	@Test
	void testGetLengthZeroLengthRange() {
		exampleRange = new Range(5.0, 5.0);
		assertEquals(0.0, exampleRange.getLength());
	}

	@Test
	void testGetLengthNegativeRange() {
		exampleRange = new Range(-6.0, -2.0);
		assertEquals(4.0, exampleRange.getLength());
	}

}
