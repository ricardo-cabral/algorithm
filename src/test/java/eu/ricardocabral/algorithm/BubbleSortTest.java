package eu.ricardocabral.algorithm;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class BubbleSortTest {

	@Test
	public void testBubbleSort() {
		final int[] numbers = { -3, -5, 1, 7, 4, -2 };
		final int[] expected = { -5, -3, -2, 1, 4, 7 };
		
		BubbleSort.bubbleSort(numbers);
		assertArrayEquals(expected, numbers);

	}
	
}
