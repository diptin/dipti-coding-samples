package org.diptin.sorter;

/**
 * This class sorts array of any data type using Bubble Sort.
 * @param Type of value to be sorted
 * @author Dipti Nirmale
 */
public class BubbleSort<T extends Comparable<T>> {

	
	public T[] sort(T[] arr){
		int j=arr.length-1;
		boolean swapped=true;
		
		while(j>0 && swapped==true){
			
			swapped=false;
			
			for(int i=0;i<j;i++){
			
				if(!isNextGreater(arr[i], arr[i+1])){
				
					swapInArray(arr, i, i+1);
					swapped = true;
				}
			}
			j--;
		}
		return arr;
	}
	
	private void swapInArray(T[] arr, int first, int second) {
		T temp = arr[first];
		arr[first]=arr[second];
		arr[second]=temp;
	}

	private boolean isNextGreater(T t1, T t2) {
		if (t1.compareTo(t2) < 0)
			return true;
	return false;
    }
}
