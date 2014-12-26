package org.diptin.sorter;

/**
 * This class sorts array of any data type using Heap Sort.
 * @param T type of value to be sorted
 * @author Dipti Nirmale
 */
public class HeapSort<T extends Comparable<T>> {
	
	public void sort(T[] arr) {
		int heapSize = buildHeap(arr);
				
		for(int i = heapSize; i > 0; i--) {
			swapInArray(arr, 0, i);
			heapSize = heapSize - 1;
			maxHeapify(arr, 0, heapSize);
		}
	}
	
	private int buildHeap(T[] arr) {
		int heapSize = arr.length - 1;
		for(int i = heapSize/2; i >= 0; i--) {
			maxHeapify(arr, i, heapSize);
		}
		return heapSize;
	}
	
	private void maxHeapify(T[] arr, int i, int heapSize) {
		int left = 2 * i +1;
		int right = 2* i + 2;
		int max = i;
		
		if(left <= heapSize && isNextGreater(arr[max], arr[left]))
			max = left;
		
		if(right <= heapSize && isNextGreater(arr[max], arr[right]))
			max = right;
		
		if(max != i )
		{
			swapInArray(arr, i, max);
			maxHeapify(arr, max, heapSize);
		}
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
