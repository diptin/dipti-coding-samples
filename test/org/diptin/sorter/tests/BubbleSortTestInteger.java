package org.diptin.sorter.tests;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import org.diptin.sorter.BubbleSort;

@RunWith(Parameterized.class)
public class BubbleSortTestInteger {
	
	private Integer[] input;
	private Integer[] expectedOut;
	
	private BubbleSort<Integer> bSortInt;
	
	public BubbleSortTestInteger(Integer[] inp, Integer[] op) {
		this.input = inp;
		this.expectedOut = op;
	}
	
	@Parameters//(name = "{index}: ")
	public static Collection<Object[]> testData () {
		return Arrays.asList(new Object[][] {
				{new Integer[]{55, 12, 5, 100, 5, 45}, new Integer[]{5, 5, 12, 45, 55, 100}}, //0. Random Positive integers with duplicates
				{new Integer[]{}, new Integer[]{}}, //1. empty array
				{new Integer[]{1}, new Integer[]{1}},	//2. array with single element
				{new Integer[]{99, -99}, new Integer[]{-99, 99}},	//3. array with two elements with same face value but different signs
				{new Integer[]{-78, -12, -45, -23, 0}, new Integer[]{-78, -45, -23, -12, 0}},	//4. all negatives
				{new Integer[]{1000, 90, 50, 0, -1, -10}, new Integer[]{-10, -1, 0, 50, 90, 1000}}, //5. all elements in descending order
				{new Integer[]{-55, -1, 0, 1, 10, 100000}, new Integer[]{-55, -1, 0, 1, 10, 100000}}	//6. already sorted array
		});
	}
	
	@Test
	public void testSortInt() {
		bSortInt = new BubbleSort<>();		
		Assert.assertArrayEquals(expectedOut, bSortInt.sort(input));
	}
}
