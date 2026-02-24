package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class toStringTest {
	
	private Range range;

	@Test
	void testPositiveValuesToString() {
		range = new Range(10.0, 20.0);
		assertEquals("Range[10.0,20.0]", range.toString());
	}

	@Test
	void testNegativeValuesToString() {
		range = new Range(-5.0, -1.0);
		assertEquals("Range[-5.0,-1.0]", range.toString());
	}

	@Test
	void testSameBoundsToString() {
		range = new Range(3.0, 3.0);
		assertEquals("Range[3.0,3.0]", range.toString());
	}

	@Test
	void testDecimalValuesToString() {
		range = new Range(2.75, 9.99);
		assertEquals("Range[2.75,9.99]", range.toString());
	}
}
