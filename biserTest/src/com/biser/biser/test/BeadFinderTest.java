package com.biser.biser.test;

import org.junit.Test;

import com.biser.biser.*;

import junit.framework.TestCase;

public class BeadFinderTest extends TestCase {
	@Test
    public void testZeroIsNotZero() {
/*		Stock stock = mock(Stock.class);
		when(stock.getPrice()).thenReturn(100.00);    // Mock implementation
		when(stock.getQuantity()).thenReturn(200);    // Mock implementation
		when(stock.getValue()).thenCallRealMethod();  // Real implementation
		BeadFinder bf = mock(BeadFinder.class);
		when(bf.getContent()).thenReturn(100);
*/
        assertEquals(0, 1);
    }
	@Test
	public void testZeroIsZero() {
        assertEquals(0, 0);
    }
}
