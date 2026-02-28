package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class intersectsTest {
	
	private Range range;

	@Test
	void testRangeInsideIntersects() {
		range = new Range (10.0, 20.0);
		assertTrue(range.intersects(12.0, 18.0));	
	}
	
	@Test
	void testRangeCoversIntersects() {
		range = new Range (10.0, 20.0);
		assertTrue(range.intersects(5.0, 25.0));
		
	}
	
	@Test
	void testLeftOverlapIntersects() {
	    range = new Range(10.0, 20.0);
	    assertTrue(range.intersects(5.0, 12.0));
	}
	
	@Test
	void testRightOverlapIntersects() {
		range = new Range(10.0, 20.0);
		assertTrue(range.intersects(18.0, 30.0));
	}
	
	@Test
	void testExactSameRangeIntersects() {
		range = new Range(10.0, 20.0);
		assertTrue(range.intersects(10.0, 20.0));
	}
	
	@Test
	void testLowerEndpointIntersects() {
		range = new Range(10.0, 20.0);
		assertTrue(range.intersects(0.0, 10.0));
	}
	
	@Test
	void testUpperEndpointIntersects() {
		range = new Range(10.0, 20.0);
		assertTrue(range.intersects(20.0, 30.0));
		
	}
	
	@Test
	void testBelowRangeIntersects() {
		range = new Range(10.0, 20.0);
		assertFalse(range.intersects(0.0, 9.99));
	}
	
	@Test
	void testAboveRangeIntersects() {
		range = new Range(10.0, 20.0);
		assertFalse(range.intersects(20.001, 30.0));
		
	}

	//New Test Cases
	//lower==upper
	@Test
void testPointInsideRangeIntersects() {
    range = new Range(10.0, 20.0);
    assertTrue(range.intersects(15.0, 15.0));
}


//point outside range
@Test
void testPointOutsideRangeIntersects() {
    range = new Range(10.0, 20.0);
    assertFalse(range.intersects(25.0, 25.0));
}

//lower >upper
@Test
void testReversedInputBoundsIntersects() {
    range = new Range(10.0, 20.0);
    assertFalse(range.intersects(18.0, 12.0));
}



}
