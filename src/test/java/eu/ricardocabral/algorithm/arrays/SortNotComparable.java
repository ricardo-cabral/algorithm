package eu.ricardocabral.algorithm.arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SortNotComparable {

	private static class NotComparable{
		private int i;
		private NotComparable(final int i) {
			this.i = i;
		}
	}
	
	/**
	 * ClassCastException is thrown because there is no implementation of Comparable Interface
	 */
	@Test(expected=ClassCastException.class)
	public void sortNotComparable() {
		final List<NotComparable> objects = new ArrayList<>();
		for(int i =0; i < 10; i++) {
			objects.add(new NotComparable(i));
		}
		
			Arrays.sort(objects.toArray());
		
	}
	
}
