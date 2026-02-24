package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RangeTest {
	private Range exampleRange;
	

	@Test
	void test() {
		exampleRange = new Range(-1,1);
		assertEquals(0, exampleRange.getCentralValue(),0.1d,"The central value of (-1,1) is 0");
	}

}
