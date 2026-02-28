package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*; 
import org.junit.jupiter.api.BeforeEach; 

import org.junit.jupiter.api.Test;

class DataUtilitiesTest {
	
	private Values2D value;
	private static final double EPS = 0.0000001;

 	 
	@BeforeEach
	void setUp() throws Exception {
		value = mock(Values2D.class);                	
	    when(value.getColumnCount()).thenReturn(4);                	
	    when(value.getRowCount()).thenReturn(3);                	
	    when(value.getValue(0, 2)).thenReturn(5);                	
	    when(value.getValue(1, 2)).thenReturn(7);                	
	    when(value.getValue(2, 2)).thenReturn(1);    
	}


	@Test
	void test() {
		assertEquals(13, DataUtilities.calculateColumnTotal(value, 2), .01d);
      	verify(value, times(3)).getValue(anyInt(), anyInt());

	}

	@Test
    void cumulative_basic() {
        DefaultKeyedValues data = new DefaultKeyedValues();
        data.addValue("A", 5);
        data.addValue("B", 9);
        data.addValue("C", 2);

        KeyedValues result = DataUtilities.getCumulativePercentages(data);

        assertEquals(1.0, result.getValue(2).doubleValue(), EPS);
    }

    @Test
    void cumulative_nullInput() {
        assertThrows(IllegalArgumentException.class,
                () -> DataUtilities.getCumulativePercentages(null));
    }

}
