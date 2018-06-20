package eu.ricardocabral.algorithm;

public class BubbleSort {

	/**
	 * worst case o(n2), for each iteration you are switching only one element.
	 * Best case O(n) when the array is sorted already
	 * 
	 */
	public static void bubbleSort(int[] numbers) {
		boolean numbersSwitched;
		
		do {
			numbersSwitched = false;
			
			for (int i =0; i < numbers.length -1; i ++) {
				if(numbers[i + 1] < numbers[i]) {
					int tmp = numbers[i +1];
					numbers[i + 1] = numbers[i];
					numbers[i] = tmp;
					numbersSwitched = true;
				}
			}
		} while(numbersSwitched);
	}
}
