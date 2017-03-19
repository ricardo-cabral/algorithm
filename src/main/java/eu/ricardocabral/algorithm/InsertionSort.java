package eu.ricardocabral.algorithm;

import java.util.Arrays;

/**
 * - efficient for sorting a small number of elements
 * - it is better then merge sort until ~43 elements
 * @author Ricardo
 *
 */
public class InsertionSort {

	
	public static void main(String[] args) {
	
		int[] array = new int[]{5,2,4,6,1,3};
		System.out.println(Arrays.toString(insertionSort(array)));
		int[] array2 = new int[]{5,2,4,6,1,3};
		System.out.println(Arrays.toString(insertionSortReverted(array2)));
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
		System.out.println("IsertionSort Reverted");
		for(int i = 0; i <array.length; i++){
			int key = array[i];
			int j = i+ 1;
			while(j < array.length){
				if(key > array[j]){
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
					j++;
					System.out.println(Arrays.toString(array));
				}
				
			}
		
		}
		
		return array;
	}
	
	
}
