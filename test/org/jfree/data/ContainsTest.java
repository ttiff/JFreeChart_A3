package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ContainsTest {

	// InsideRange -> true
	@Test
	void contains_insideRange_returnsTrue() {
		Range range = new Range(2.0, 6.0);

		assertTrue(range.contains(4.0));
	}

	// BelowRange -> false
	@Test
	void contains_belowRange_returnsFalse() {
		Range range = new Range(2.0, 6.0);

		assertFalse(range.contains(1.0));
	}

	// AboveRange -> false
	@Test
	void contains_aboveRange_returnsFalse() {
		Range range = new Range(2.0, 6.0);

		assertFalse(range.contains(8.0));
	}

	// Boundary lower -> true
	@Test
	void contains_atLowerBound_returnsTrue() {
		Range range = new Range(2.0, 6.0);

		assertTrue(range.contains(2.0));
	}

	// Boundary upper -> true
	@Test
	void contains_atUpperBound_returnsTrue() {
		Range range = new Range(2.0, 6.0);

		assertTrue(range.contains(6.0));
	}
}
