package org.diptin.numbers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Iterator;

public class OccuranceLookup {

	public void printEvenOccurance(int[] arr){
		HashMap<Integer, Integer> ht =new HashMap<Integer, Integer>(arr.length);

		for(int i = 0; i < arr.length; i++)
		{
			if(ht.containsKey(arr[i])){
				ht.put(arr[i], ht.get(arr[i]) + 1);
			}
			else{
				ht.put(arr[i], 1);
			}
		}
		
		System.out.print("\nThe elements with even number of occurrances: ");
		
		Set<Entry<Integer, Integer>> st= ht.entrySet();
		Iterator<Entry<Integer, Integer>> i = st.iterator();
		
		boolean isEvenOccur = false;
		
		while(i.hasNext()){
			Map.Entry<Integer, Integer> mapEntry = (Map.Entry<Integer, Integer>)i.next();
			if(mapEntry.getValue()%2==0) {
				isEvenOccur = true;
				System.out.print(mapEntry.getKey()+ ", ");
			}
		}
		
		if (!isEvenOccur) 
			System.out.println(" No such element found");
	}
	
	public void printOddOccurance(int[] arr) {
		
		Arrays.sort(arr);
		boolean isOddOccur = false;
		
		System.out.print("\nThe elements with odd number of occurances:- ");
		int i = 0;		
		while (i < arr.length) {
			int count = 1;
			int k = arr[i++];
			while (i < arr.length && arr[i] == k) {
				count++;
				i++;
			}
			if (count % 2 == 1) {
				isOddOccur = true;
				System.out.print(k + ", ");
			}
		}
		
		if (!isOddOccur)
			System.out.println("No such element found");
	}
	
	void printArr(int[] arr)
	{
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + "\t");
	}
	
	public static void main(String[] args) {
		OccuranceLookup oLookup = new OccuranceLookup();
		int[] arr1 = {34, 56, 67, 56, 34, 34, 67, 89, 89, 90};
		oLookup.printEvenOccurance(arr1);
		oLookup.printOddOccurance(arr1);
	}
}
