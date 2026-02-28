package org.jfree.data;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
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

	// calculateColumnTotal() Tests
	@Test
	void testCalculateColumnTotal_TypicalValues() {
		Values2D data = mock(Values2D.class);
		when(data.getRowCount()).thenReturn(3);
		when(data.getValue(0, 0)).thenReturn(1.0);
		when(data.getValue(1, 0)).thenReturn(2.5);
		when(data.getValue(2, 0)).thenReturn(3.0);
		double total = DataUtilities.calculateColumnTotal(data, 0);
		assertEquals(6.5, total, 0.0000001);
		verify(data, times(1)).getRowCount();
		verify(data, times(3)).getValue(anyInt(), eq(0));
	}

	@Test
	void testCalculateColumnTotal_EmptyTableReturnsZero() {
		Values2D data = mock(Values2D.class);
		when(data.getRowCount()).thenReturn(0);
		double total = DataUtilities.calculateColumnTotal(data, 0);
		assertEquals(0.0, total, 0.0000001);
		verify(data, times(1)).getRowCount();
		verify(data, never()).getValue(anyInt(), anyInt());
	}

	@Test
	void testCalculateColumnTotal_NullDataThrows() {
		assertThrows(NullPointerException.class, () -> DataUtilities.calculateColumnTotal(null, 0));
	}

	// createNumberArray() Tests
	@Test
	void testCreateNumberArray_Typical() {
		double[] input = { 1.0, 2.5, -3.0 };
		Number[] result = DataUtilities.createNumberArray(input);
		assertEquals(3, result.length);
		assertEquals(1.0, result[0].doubleValue(), 0.0000001);
		assertEquals(2.5, result[1].doubleValue(), 0.0000001);
		assertEquals(-3.0, result[2].doubleValue(), 0.0000001);
	}

	@Test
	void testCreateNumberArray_EmptyArray() {
		double[] input = {};
		Number[] result = DataUtilities.createNumberArray(input);
		assertNotNull(result);
		assertEquals(0, result.length);
	}

	@Test
	void testCreateNumberArray_NullThrowsWithMessage() {
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
				() -> DataUtilities.createNumberArray(null));
		assertTrue(ex.getMessage().contains("Null 'data' argument."));
	}

	// createNumberArray2D Tests
	@Test
	void testCreateNumberArray2D_Typical() {
		double[][] input = { { 1.0, 2.0 }, { -1.5 }, {} };

		Number[][] result = DataUtilities.createNumberArray2D(input);

		assertEquals(3, result.length);

		assertEquals(2, result[0].length);
		assertEquals(1.0, result[0][0].doubleValue(), 0.0000001);
		assertEquals(2.0, result[0][1].doubleValue(), 0.0000001);

		assertEquals(1, result[1].length);
		assertEquals(-1.5, result[1][0].doubleValue(), 0.0000001);

		assertEquals(0, result[2].length);
	}

	@Test
	void testCreateNumberArray2D_NullThrowsWithMessage() {
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
				() -> DataUtilities.createNumberArray2D(null));
		assertTrue(ex.getMessage().contains("Null 'data' argument."));
	}

	@Test
	void testCreateNumberArray2D_RowNullThrows() {
		double[][] input = new double[2][];
		input[0] = new double[] { 1.0 };
		input[1] = null; 
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
				() -> DataUtilities.createNumberArray2D(input));
		assertTrue(ex.getMessage().contains("Null 'data' argument."));
	}
	
	//getCumulativePercentages() Tests

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

	//calculateRowTotal() Tests

}