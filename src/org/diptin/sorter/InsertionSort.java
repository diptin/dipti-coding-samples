package org.diptin.sorter;

/**
 * This class sorts array of any data type using Insertion Sort.
 * @param T type of value to be sorted
 * @author Dipti Nirmale
 *
 */
public class InsertionSort<T extends Comparable<T>> {
	
	public void sort(T[] arr){
		for(int i = 1; i < arr.length; i++){
			
			T temp = arr[i];
			int j;
			
			for(j = i-1; j >= 0; j--){
				
				if(isNextGreater(arr[j], temp))
					break;
				
				arr[j+1]=arr[j];
			}
			arr[j+1]=temp;
		}
	}
	
	private boolean isNextGreater(T t1, T t2) {
		if (t1.compareTo(t2) < 0)
			return true;
	return false;
    }
}
