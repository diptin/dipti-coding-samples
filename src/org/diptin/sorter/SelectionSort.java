package org.diptin.sorter;

/**
 * This class sorts array of any data type using Selection Sort.
 * @param T type of value to be sorted
 * @author Dipti Nirmale
 *
 */
public class SelectionSort<T extends Comparable<T>> {
	
	public void sort(T[] arr) {
		
		for(int j = 0; j < arr.length-1; j++)
		{
			int smallIndex = j;
			
		    for(int i = j+1; i < arr.length; i++){
		    	
			  if(isNextGreater(arr[i], arr[smallIndex])) {
				smallIndex=i;
			  }
		    }
		    swapInArray(arr, j, smallIndex);
		}
	}
	
	private void swapInArray(T[] arr, int first, int second) {
		T temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
	}
	
	private boolean isNextGreater(T t1, T t2) {
		if (t1.compareTo(t2) < 0)
			return true;
	return false;
    }
}
