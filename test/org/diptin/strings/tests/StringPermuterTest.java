package org.diptin.strings.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import org.diptin.strings.StringPermuter;

public class StringPermuterTest {
	String testString;
	StringPermuter strPermuter;
	Collection<String> expectedList, actualList;

	@Before
	public void initialize() throws Exception {
		strPermuter = new StringPermuter();
	}

	@Test 
	public void testPermutate() {
		testString = "abc";
	    expectedList = new HashSet<>(Arrays.asList("abc", "acb", "bca", "bac", "cab", "cba")); 
		strPermuter.permutate(testString);
		actualList = strPermuter.getPermutationList();
		
		assertEquals(expectedList, actualList);
		assertThat(actualList, is(expectedList));
	}
	
	@Test
	public void testPermuteForNullString() {
		expectedList = null;
		strPermuter.permutate(null);
		actualList = strPermuter.getPermutationList();
		assertEquals(expectedList, actualList);
	}
	
	@Test
	public void testPermuteForEmptyString() {
		expectedList = null;
		strPermuter.permutate("");
		actualList = strPermuter.getPermutationList();
		assertEquals(expectedList, actualList);
	}
	
	@Test
	public void testPermuteForDigitString() {
		expectedList = new HashSet<>(Arrays.asList("036", "306", "630", "360", "603", "063"));
		strPermuter.permutate("603");
		actualList = strPermuter.getPermutationList();
		assertEquals(expectedList, actualList);
	}
	
	@Test // Test fails. To check Junit test report for failures
	public void testPermuteForNonCharString() {
		expectedList = null;
		strPermuter.permutate("/,'j5");
		actualList = strPermuter.getPermutationList();
		assertEquals(expectedList, actualList);
	}
	
	@Test
	public void testPermuteForWhiteSpaces() {
		expectedList = null;
		strPermuter.permutate("     ");
		actualList = strPermuter.getPermutationList();
		assertEquals(expectedList, actualList);
	}
}
