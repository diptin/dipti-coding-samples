package org.diptin.strings;

/*
 * This program removes all white spaces in a string 
 * 
 * author: Dipti Nirmale
 * Dated 12/4/14
 */

public class StringSegregator {

	private String inputString; 
	
	public StringSegregator(String str) {
		inputString = str;
	}
	
	public StringSegregator() {	}

	public String getSegregatedString() {
		return inputString;
	}
	
	public String segragateString(String str) {
		if (str == null)
			return str;
		
		int spacePtr = 0;
		int charPtr = 0;
		
		char[] inputArr = str.toCharArray();
		
		while (spacePtr < inputArr.length && charPtr < inputArr.length) {

			while (charPtr < inputArr.length && !Character.isWhitespace(inputArr[charPtr]))
				charPtr++;
			
			while (spacePtr < inputArr.length && Character.isWhitespace(inputArr[spacePtr]))
				spacePtr++;
			
			if (spacePtr < inputArr.length && charPtr < inputArr.length && charPtr < spacePtr)
				swapChars(spacePtr, charPtr, inputArr);			
			else 
				spacePtr++;
		}
		return String.valueOf(inputArr).trim();
	}
	
	public void segragateString() {
		if (inputString == null)
			return;
		
		int spacePtr = 0;
		int charPtr = 0;
		
		char[] inputArr = inputString.toCharArray();
		
		while (spacePtr < inputArr.length && charPtr < inputArr.length) {

			while (charPtr < inputArr.length && !Character.isWhitespace(inputArr[charPtr]))
				charPtr++;
			
			while (spacePtr < inputArr.length && Character.isWhitespace(inputArr[spacePtr]))
				spacePtr++;
			
			if (spacePtr < inputArr.length && charPtr < inputArr.length && charPtr < spacePtr)
				swapChars(spacePtr, charPtr, inputArr);			
			else 
				spacePtr++;
		}
		inputString = String.valueOf(inputArr).trim();
	}

	private void swapChars(int space, int chars, char[] inputArr) {
		char temp = inputArr[chars];
		inputArr[chars] = inputArr[space];
		inputArr[space] = temp;
//		return inputArr;
	}
	
	public static void main(String[] args) {
		StringSegregator strSeg = new StringSegregator("  a 1  b  v  ");
		strSeg.segragateString();
		System.out.println(strSeg.getSegregatedString());
	}

}
