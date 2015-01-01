package org.diptin.strings.tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import org.diptin.strings.StringSegregator;

@RunWith(Parameterized.class)
public class StringSegregatorTest {
	private StringSegregator strSeg;
	private String inputStr;
	private String expectedStr;
	
	@Before
	public void initialize() {
		strSeg = new StringSegregator();
	}
	
	public StringSegregatorTest (String inpuString, String expectedStr) {
		this.inputStr = inpuString;
		this.expectedStr = expectedStr;
	}
	
	@Parameters //(name = "{index}: seg({0}) = {1}")
	public static Collection<Object[]> testData() {
		return Arrays.asList(new Object[][] {
				{"a b c", "abc"}, 
				{"", "a"},	// Test fails. Added to check Junit Report for failures 
				{"    ", ""}, 
				{null, null}, 
				{"abcd", "abcd"}, 
				{"  a  b   c  ", "abc"}
		});
	} 
	

	@Test
	public void testSegragateString() {
		assertEquals(expectedStr, strSeg.segragateString(inputStr));
	}
	
	@Ignore
	public void testSegragateStringForEmpty() {
		StringSegregator strSeg = new StringSegregator("");
		strSeg.segragateString();
		assertEquals("", strSeg.getSegregatedString());
	}
	
	@Ignore
	public void testSegragateStringForWhiteSpacesOnly() {
		StringSegregator strSeg = new StringSegregator("   ");
		strSeg.segragateString();
		assertEquals("", strSeg.getSegregatedString());
	}
	
	@Ignore
	public void testSegragateStringForNull() {
		StringSegregator strSeg = new StringSegregator(null);
		strSeg.segragateString();
		assertEquals(null, strSeg.getSegregatedString());
	}
	
	@Ignore
	public void testSegragateStringForNoWhiteSpace() {
		StringSegregator strSeg = new StringSegregator("abcd");
		strSeg.segragateString();
		assertEquals("abcd", strSeg.getSegregatedString());
	}
	
	@Ignore
	public void testSegragateStringForTrailingWhitespaces() {
		StringSegregator strSeg = new StringSegregator("  a     bc  ");
		strSeg.segragateString();
		assertEquals("abc", strSeg.getSegregatedString());
	}
}
