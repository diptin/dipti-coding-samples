package org.diptin.strings;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/* 
 * This program computes and prints all permutations of a string.
 * It avoids the duplicates by sorting the string in case insensitive manner and then calling the permutation function recursively.
 * 
 * author: Dipti Nirmale
 * Dated 12/4/14
 *
*/

public class StringPermuter {
	
	private Collection<String> permutaions;
	
	public StringPermuter() {
		permutaions = new HashSet<>();
	}
		
	private String sortString(String str)
	{
		String[] array = str.split("");
		Arrays.sort(array, String.CASE_INSENSITIVE_ORDER);
		StringBuilder sortedStr = new StringBuilder();
		for (int i=0; i<array.length; i++)
			sortedStr.append(array[i]);
		return sortedStr.toString();
	}
	
	private void getPermOfString(String prevStr, String nextStr) {
		if(nextStr.length()==0) {
			permutaions.add(prevStr);
		}
		else {
			String prevPlusIthStr, nextMinusIthStr, thisChar;
			
			//check previous character in the string to avoid duplicates
			String prevChar = nextStr.substring(0, 1);
			
			for(int i=0; i<nextStr.length(); i++)
			{
				thisChar = nextStr.substring(i, i+1);
				if(i==0 || !prevChar.equalsIgnoreCase(thisChar))
				{
					prevPlusIthStr = prevStr + thisChar;
					nextMinusIthStr = nextStr.substring(0, i) + nextStr.substring(i+1);
					getPermOfString(prevPlusIthStr, nextMinusIthStr);
				}
				prevChar = thisChar;
			}
		}
	}
		
	public void permutate(String str)
	{
		if (str == null || str.trim().equals("")) {
			permutaions = null;
			return;
		}
		if (str.length() == 1) {
			permutaions.add(str);
			return;
		}
		
		String sortedStr = sortString(str);
//		System.out.println("The permute of " + sortedStr + ":-");
		getPermOfString("", sortedStr);
//		printPermutationsList();
	}
	
	public int getCountOfPermutations() {
		return getPermutationList().size();
	}
	
	public Collection<String> getPermutationList () {
		return permutaions;
	}
	
	public void printPermutationsList () {
		Iterator<String> listIter = getPermutationList().iterator();
		while(listIter.hasNext()) {
			System.out.println(listIter.next());
		}
	}
	
	public static void main(String[] args) {
		StringPermuter str = new StringPermuter();
		str.permutate("acC");
		str.printPermutationsList();
		System.out.println("Count of permutations = " + str.getCountOfPermutations());
	}

}
