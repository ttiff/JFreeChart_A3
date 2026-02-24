package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ConstrainTest {


    @Test
    void constrain_insideRange_returnsSameValue() {
        Range range = new Range(2.0, 6.0);

        double result = range.constrain(4.0);

        assertEquals(4.0, result, 0.00001);
    }

   
    @Test
    
    void constrain_belowRange_returnsLowerBound() {
        Range range = new Range(2.0, 6.0);

        double result = range.constrain(1.0);

        assertEquals(2.0, result, 0.00001);
    }

    // AboveRange() -> largest value in range
    @Test
    void constrain_aboveRange_returnsUpperBound() {
        Range range = new Range(2.0, 6.0);

        double result = range.constrain(8.0);

        assertEquals(6.0, result, 0.00001);
    }

}
