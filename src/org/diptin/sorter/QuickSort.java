package org.diptin.sorter;

/**
 * This class sorts array of any data type using Quick Sort.
 * @param T type of value to be sorted
 * @author Dipti Nirmale
 */
public class QuickSort<T extends Comparable<T>> {
	
	public void sort (T[] arr) {
		recQuickSort(arr, 0, arr.length-1);
	}

	private void recQuickSort(T[] arr, int start, int end) {
		
		if(start >= end)
			return;
		
		int pivot = partition(arr, start, end);
		
		recQuickSort(arr, start, pivot-1);
		recQuickSort(arr, pivot+1, end);
	}

	private int partition(T[] arr, int left, int right) {
		int pivot = left;
		int i = left + 1;
		int j = right;
		
		while(i <= j) {
			while(isNextGreater(arr[i], arr[pivot]) && i < right) 
				i++;
			
			while(isNextGreater(arr[pivot], arr[j]) && j > left) 
				j--;
			
			if(i >= j)
				break;
			else
				swapInArray(arr, i, j);
		}
		swapInArray(arr, pivot, j);
		pivot = j;
		return pivot;
	}
	
	private boolean isNextGreater(T t1, T t2) {
		if (t1.compareTo(t2) < 0)
			return true;
	return false;
    }
	
	private void swapInArray(T[] arr, int first, int second) {
		T temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
	}
}
