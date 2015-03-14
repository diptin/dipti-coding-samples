package org.diptin.sorter;

import java.lang.reflect.Array;

/**
 * This class sorts array of any data type using Merge Sort.
 * @param T type of value to be sorted
 * @author Dipti Nirmale
 */


public class MergeSort<T extends Comparable<T>> {
	
		
		public void sort(T[] arr){
			recMergeSort(arr, 0, arr.length-1);
		}
		
		private void recMergeSort(T[] arr, int left, int right){
			if(left >= right)
				return;
			
			int mid = left+((right-left)/2);
		
			recMergeSort(arr, left, mid);
			recMergeSort(arr, mid+1, right);
			
			merge(arr, left, mid, right);
		}
		
		@SuppressWarnings("unchecked")
		private void merge(T[] mgArr, int left, int mid, int right){
			
			Class<?> c = mgArr.getClass();
			T[] leftArr = (T[]) Array.newInstance(c, mid - left + 1);
			T[] rightArr = (T[]) Array.newInstance(c, right - mid);		
			
			for(int i = 0, j = left; i < leftArr.length && j <= mid; i++,j++)
				leftArr[i] = mgArr[j]; 
			
			for(int i = 0, j = mid + 1; i < rightArr.length && j <= right; i++,j++)
				rightArr[i] = mgArr[j];
			
			int k = left, i = 0, j = 0;
			
			while(i < leftArr.length && j < rightArr.length) {
				
				if(isNextGreater(leftArr[i],rightArr[j])) {
					mgArr[k] = leftArr[i];
					i++; 
					k++;
				}
				else{
					mgArr[k] = rightArr[j];
					j++; 
					k++;
				}
			}
			if(i == leftArr.length){
				while(j < rightArr.length){
					mgArr[k] = rightArr[j];
					j++;
					k++;
				}
			}
			else if(j == rightArr.length){
				while(i < leftArr.length){
					mgArr[k] = leftArr[i];
					i++; 
					k++;
				}
			}
		}

		private boolean isNextGreater(T t1, T t2) {
			if (t1.compareTo(t2) < 0)
				return true;
		return false;
	    }
}
//Generic type is used for following use cases
//public class MergeSort {
//	public static void main(String[] args) {
//		MergeSort mrgSort = new MergeSort();
//		int[] arrInt = {5,100, 1, -99, 78, 1};
//		int[] arrChar = {'v', 'b', 'v', 'a', 'z', 'B', 'Z'};
//		String[] arrString = {"hjkj", "", "  ", "hjjj", "abcd"};
//		double[] arrDouble = {45.23, 78.45, 0};
//		
//		mrgSort.sort(arrInt);
//		mrgSort.sort(arrChar);
//		
//		mrgSort.printArray(arrInt);
//		System.out.println();
//		mrgSort.printArray(arrChar);
//	}
//}
