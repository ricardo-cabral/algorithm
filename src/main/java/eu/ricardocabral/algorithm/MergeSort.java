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

		int[] myArray = new int[] { 45, 3, 50, 1, 20, 15, 33, 35 };
		tmpArray = new int[myArray.length];
		System.out.println("My Merge sort: ");
		myMergeSort(myArray, 0, myArray.length - 1);
		System.out.println(Arrays.toString(myArray));

		int[] arrayToMerge = new int[] { 8, 4 };
		myMerge(arrayToMerge, 0, 0, 1);

		int[] arrayToMerge2 = new int[] { 4, 8, 9 };
		myMerge(arrayToMerge2, 1, 1, 2);

		int[] arrayToMerge3 = new int[] { 3, 41, 52, 1 };
		myMerge(arrayToMerge3, 0, 2, 3);

		// int[] bookArray = new int[] { 45, 3, 50, 1, 20, 15, 33, 35};
		int[] bookArray = new int[] { 45, 3, 50, 1, 20, 15, 33, 35 };
		System.out.println("Book Merge sort: ");
		bookMergeSort(bookArray, 0, bookArray.length - 1);
		// bookMerge(bookArray, 0, 2, 3);
		System.out.println(Arrays.toString(bookArray));

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
			/*
			 * System.out.println(Arrays.toString(Arrays.copyOfRange(array,
			 * begin, end)) + "- begin= " + begin + ". middle= " + middle +
			 * ", end = " + end);
			 */
			// Sort the left side of the array
			myMergeSort(array, begin, middle);
			// sort the right side of the array
			myMergeSort(array, middle + 1, end);
			// combine both arrays
			myMerge(array, begin, middle, end);
		}
	}

	private static void myMerge(int[] array, int begin, int middle, int end) {
		helper = new int[end + 1];
		for (int i = begin; i <= end; i++) {
			helper[i] = array[i];
		}

		int beginAux = begin;
		int middleAux = middle + 1;
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

	private static void bookMergeSort(int[] array, int begin, int end) {

		if (begin < end) {
			int middle = (end + begin) / 2;
			/*
			 * System.out.println(Arrays.toString(Arrays.copyOfRange(array,
			 * begin, end)) + "- begin= " + begin + ". middle= " + middle +
			 * ", end = " + end);
			 */
			// Sort the left side of the array
			bookMergeSort(array, begin, middle);
			// sort the right side of the array
			bookMergeSort(array, middle + 1, end);
			// combine both arrays
			bookMerge(array, begin, middle, end);
		}
	}

	private static void bookMerge(int[] array, int begin, int middle, int end) {

		int lengthLeft = middle - begin + 1;
		int lengthRight = end - middle;

		int[] left = new int[lengthLeft + 1];
		int[] right = new int[lengthRight + 1];

		for (int i = 0; i < lengthLeft; i++) {
			left[i] = array[begin + i];
		}

		for (int j = 0; j < lengthRight; j++) {
			right[j] = array[middle + j + 1];
		}

		left[lengthLeft] = Integer.MAX_VALUE;
		right[lengthRight] = Integer.MAX_VALUE;

		for (int pointLeft = 0, pointRight = 0, pointArray = begin; pointArray <= end; pointArray++) {
			if (left[pointLeft] <= right[pointRight]) {
				array[pointArray] = left[pointLeft++];

			} else {
				array[pointArray] = right[pointRight++];

			}
		}

	}

}
