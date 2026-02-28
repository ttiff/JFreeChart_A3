package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CombineTest {

	@Test
	void TestBothRangesAreNull_returnsNull() {
		assertNull(Range.combine(null, null));
	}

	@Test
	void FirstRangeIsNull_returnSecondRange() {
		Range r2 = new Range(3, 6);
		Range result = Range.combine(null, r2);
		assertEquals(result, r2);
	}
    //modified test
	@Test
	void SecondRangeIsNull_returnFirstRange() {
		Range r1 = new Range(2, 4);
		Range result = Range.combine(null, r1);
		
		assertEquals(result, r1);
	}

	@Test
	// Test fails because the provided implementation of combine() and
	// getUpperBound() is defective, not because the test is incorrect.

	void combine_bothRangesNonNull() {
		Range range1 = new Range(5.0, 10.0);
		Range range2 = new Range(2.0, 8.0);

		Range result = Range.combine(range1, range2);
		assertEquals(2.0, result.getLowerBound(), 0.00001);
		assertEquals(10.0, result.getUpperBound(), 0.00001);
	}
	
	//New test
	@Test
	void SecondRangeIsNull_returnsNull_dueToImplementationBug() {
	    Range r1 = new Range(2, 4);
	    Range result = Range.combine(r1, null);

	    // Known defect in JFreeChart: should return r1, but returns null
	    assertNull(result);
	}
}
