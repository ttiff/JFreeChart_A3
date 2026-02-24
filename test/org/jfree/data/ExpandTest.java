package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ExpandTest {

    @Test
    void expand_nullRange_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
            () -> Range.expand(null, 0.1, 0.1));
    }

    @Test
    void expand_zeroMargins_returnsSameBounds() {
        Range base = new Range(2.0, 6.0); // length = 4
        Range result = Range.expand(base, 0.0, 0.0);

        assertEquals(2.0, result.getLowerBound(), 0.00001);
        assertEquals(6.0, result.getUpperBound(), 0.00001);
    }

    @Test
    void expand_positiveMargins_expandsBothSidesCorrectly() {
        Range base = new Range(2.0, 6.0); // length = 4
        // newLower = 2 - 4*0.25 = 1
        // newUpper = 6 + 4*0.50 = 8
        Range result = Range.expand(base, 0.25, 0.50);

        assertEquals(1.0, result.getLowerBound(), 0.00001);
        assertEquals(8.0, result.getUpperBound(), 0.00001);
    }

    @Test
    void expand_negativeMargin_shrinksRange() {
        Range base = new Range(2.0, 6.0);

        Range result = Range.expand(base, -0.25, -0.25);

        assertEquals(3.0, result.getLowerBound(), 0.00001);
        assertEquals(5.0, result.getUpperBound(), 0.00001);
    }

}
