package eu.ricardocabral.algorithm;

import java.util.Arrays;

/**
 * divide and conquer algorithm
 * recursive
 * runs in o(n lg n) in all cases
 * we need an additional vector in the memory with the same size of array[]
 * 
 * @author Ricardo
 *
 */
public class MergeSort {

	private static int helper[];
	
	public static void main(String[] args) {
		int[] array = new int[]{8,4,9,3,5,2,1,6,7};
		System.out.println("Initial array: " + Arrays.toString(array));
		helper = new int[array.length];
		mergeSort(array, 0, array.length -1);
		System.out.println("Sorted array: " + Arrays.toString(array));
		
	}
	
	private static void  mergeSort(int[] array, int begin, int end){
		if(begin < end){
			int middle = begin + (end - begin)/2;
			mergeSort(array, begin, middle);
			mergeSort(array, middle + 1, end);
			merge(array, begin, middle, end);
		}
	}
	
	private static void merge(int[] array, int begin, int middle, int end){
		for(int i = begin; i<= end; i++){
			helper[i] = array[i];
		}
		
		int i = begin;
		int j = middle + 1;
		int k = begin;
		
		while(i <= middle && j <= end){
			if(helper[i] <= helper[j]){
				array[k] = helper[i];
				i++;
			}else{
				array[k] = helper[j];
				j++;
			}
			k++;
		}
		
		while(i <= middle){
			array[k] = helper[i];
			k++;
			i++;
		}
		
	}
}
