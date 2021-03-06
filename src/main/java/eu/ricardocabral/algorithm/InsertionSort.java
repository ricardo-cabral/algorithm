package eu.ricardocabral.algorithm;

import java.util.Arrays;

/**
 * - efficient for sorting a small number of elements
 * - it is better then merge sort until ~43 elements
 * - the best case occurs if the array is already sorted
 * - the worst case occurs if the array is in reverse order
 * - we have always to look at the worst case
 * - it can be expressed as an^2 + bn + c. We have to exclude the constants and get the worst case n^2
 * - We can confirm that insertion sort is a quadratic function
 * - We may say theta of n-squared
 * 
 * worst-case running time: o(n^2)
 * bets-case running time: o(n^2)
 * average-case running time: o(n^2)
 * @author Ricardo
 *
 */
public class InsertionSort {

	
	public static void main(String[] args) {
	
		int[] array = new int[]{5,2,4,6,1,3};
		System.out.println(Arrays.toString(insertionSort(array)));
		int[] array2 = new int[]{5,2,4,6,1,3};
		System.out.println(Arrays.toString(insertionSortReverted(array2)));
		int[] array3 = new int[]{5,2,4,6,1,3};
		System.out.println(Arrays.toString(myInsertionSort(array3)));
		
	}
	
	private static int[] insertionSort(int[] array ){
				 
		for (int i = 1; i < array.length; i++) {
			int key = array[i];
			int ant = i -1;
			
			while(ant >= 0 && array[ant] > key){
				array[ant + 1] = array[ant];
				ant--;
				array[ant + 1] = key;
				System.out.println(Arrays.toString(array));
			}
			
		}
		
		return array;
	}
	
	private static int[] insertionSortReverted(int[] array){
		System.out.println("IsertionSort Reverted: " + Arrays.toString(array));
		for(int i = 1; i <array.length; i++){
			int key = array[i];
			int j = i -1;
			
			
			while(j >=0 && key > array[j]){
					array[j + 1] = array[j];
					j--;
					array[j + 1] = key;
					
					System.out.println(Arrays.toString(array));
			}
		
		}
		
		return array;
	}
	
	private static int[] myInsertionSort(int[] array){
		System.out.println("My InsertionSort");
		
		for (int i = 1; i < array.length; i++) {
			int aux =i;
			for (int j = i; j >= 0; j--) {
				if(array[j]> array[aux]){
					int tmp =  array[j];
					array[j] = array[aux];
					array[aux] = tmp;
					aux--;
				}
			}
		}
		
		return array;
	}
	
	
}
