package com.biser.biser.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.biser.biser.BeadSorter;

public class BeadSorterTest {


	@Test
	public void testInsertIntoHash() {
		BeadSorter bs = new BeadSorter("stand");
		assertEquals(bs.nextLine(), "aaa");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
