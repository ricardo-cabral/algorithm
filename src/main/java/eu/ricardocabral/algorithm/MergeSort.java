package eu.ricardocabral.algorithm;

import java.util.Arrays;

/**
 * divide and conquer algorithm recursive runs in o(n lg n) in all cases we need
 * an additional vector in the memory with the same size of array[] it is
 * inefficient for small set sizes
 * 
 * @author Ricardo
 *
 */
public class MergeSort {

	private static int helper[], tmpArray[];

	public static void main(String[] args) {
		int[] array = new int[] { 8, 4, 9, 3, 5, 2, 1, 6, 7 };
		System.out.println("Initial array: " + Arrays.toString(array));
		helper = new int[array.length];
		mergeSort(array, 0, array.length - 1);
		System.out.println("Sorted array: " + Arrays.toString(array));

		int[] myArray = new int[] { 8, 4, 9, 3, 5, 2, 1, 6, 7 };
		tmpArray = new int[myArray.length];
		System.out.println("My Merge sort: ");
		myMergeSort(myArray, 0, myArray.length -1);
		System.out.println(Arrays.toString(myArray));
		

	}

	private static void mergeSort(int[] array, int begin, int end) {
		if (begin < end) {
			int middle = begin + (end - begin) / 2;
			mergeSort(array, begin, middle);
			mergeSort(array, middle + 1, end);
			merge(array, begin, middle, end);
		}
	}

	private static void merge(int[] array, int begin, int middle, int end) {
		for (int i = begin; i <= end; i++) {
			helper[i] = array[i];
		}

		int i = begin;
		int j = middle + 1;
		int k = begin;

		while (i <= middle && j <= end) {
			if (helper[i] <= helper[j]) {
				array[k] = helper[i];
				i++;
			} else {
				array[k] = helper[j];
				j++;
			}
			k++;
		}

		while (i <= middle) {
			array[k] = helper[i];
			k++;
			i++;
		}

	}

	private static void myMergeSort(int[] array, int begin, int end) {
		int middle;
		if (begin < end) {
			middle = (end + begin) / 2;
			/*System.out.println(Arrays.toString(Arrays.copyOfRange(array, begin, end)) + "- begin= " + begin
					+ ". middle= " + middle + ", end = " + end);*/
			//Sort the left side of the array
			myMergeSort(array, begin, middle);
			//sort the right side of the array
			myMergeSort(array, middle + 1, end);
			//combine both arrays
			myMerge(array, begin, middle, end);
		}
	}

	private static void myMerge(int[] array, int begin, int middle, int end) {

		for (int i = begin; i <= end; i++) {
			helper[i] = array[i];
		}

		int beginAux = begin;
		int middleAux = middle +1;
		int beginAux2 = begin;

		while (beginAux <= middle && middleAux <= end) {
			if (helper[beginAux] <= helper[middleAux]) {
				array[beginAux2] = helper[beginAux];
				beginAux++;
			} else {
				array[beginAux2] = helper[middleAux];
				middleAux++;
			}
			beginAux2++;
		}

		while (beginAux <= middle) {
			array[beginAux2] = helper[beginAux];
			beginAux2++;
			beginAux++;
		}
		System.out.println("Merge: " + Arrays.toString(array));
	}

	

}
