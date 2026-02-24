package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class EqualsTest {

    // same lower & upper -> true
    @Test
    void equals_sameBounds_returnsTrue() {
        Range r1 = new Range(2.0, 6.0);
        Range r2 = new Range(2.0, 6.0);

        assertTrue(r1.equals(r2));
    }

    // different lower -> false
    @Test
    void equals_differentLower_returnsFalse() {
        Range r1 = new Range(2.0, 6.0);
        Range r2 = new Range(3.0, 6.0);

        assertFalse(r1.equals(r2));
    }

    // different upper -> false 
    @Test
    void equals_differentUpper_returnsFalse() {
        Range r1 = new Range(2.0, 6.0);
        Range r2 = new Range(2.0, 10.0);

        assertFalse(r1.equals(r2));
    }

    // null -> false
    @Test
    void equals_null_returnsFalse() {
        Range r1 = new Range(2.0, 6.0);

        assertFalse(r1.equals(null));
    }

    // different type -> false
    @Test
    void equals_differentObjectType_returnsFalse() {
        Range r1 = new Range(2.0, 6.0);

        assertFalse(r1.equals("not a range"));
    }
}
