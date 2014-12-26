package org.diptin.sorter.tests;

import org.junit.Assert;
import org.junit.Test;

import org.diptin.sorter.BubbleSort;

public class BubbleSortTestOthers {
		
	@Test
	public void testSortChar() {
		BubbleSort<Character> bSortChar = new BubbleSort<Character>();
		Assert.assertArrayEquals(new Character[]{'A', 'Z', 'a', 'v', 'v', 'x'}, bSortChar.sort(new Character[] {'x', 'v', 'A', 'Z', 'a', 'v'}));
	}
	 
	@Test
	public void testSortDouble() {
		BubbleSort<Double> bSortDouble = new BubbleSort<Double>();
		Assert.assertArrayEquals(new Double[] {-45.90, 0.00, 45.90, 67.340, 100.0}, bSortDouble.sort(new Double[] {100.0, 45.90, 67.34, -45.90, 0.00}));
	}
	
	@Test
	public void testSortString() { 
		BubbleSort<String> bSortString = new BubbleSort<String>();
		Assert.assertArrayEquals(new String[] {"", "  ", "abc", "abc", "abcd", "adc"}, bSortString.sort(new String[] {"abcd", "adc", "", "  ", "abc", "abc"}));
	}
}
