package eu.ricardocabral.algorithm.arrays;

public class OrderedArray {

	private int numberOfElements;
	private long[] array;
	
	public OrderedArray(int size) {
		this.array = new long[size];
		numberOfElements =0;
	}
	
	public int size() {
		return numberOfElements;
	}
	
	public void insert(long number) {
		//find where it goes
		if (numberOfElements == 0) {
			array[numberOfElements] = number;
			numberOfElements++;
			return;
		}
		
		int position;
		
		for (position = 0; position < numberOfElements; position++) {
			if (array[position] > number) {
				break;
			}
		}
		
		for(int k = numberOfElements; k > position; k--) {
			array[k] = array[k -1];
		}
		
		array[position] = number;
		numberOfElements++;
	}
	
	public boolean delete(long number) {
		int value = this.findIndex(number);
		
		if(value == numberOfElements) {
			return false;
		}
		
		
		for(int k = value; k < numberOfElements-1; k++) {
			array[k] = array[k+1];
			
		}
		numberOfElements--;
		
		return true;
		
		
	}

	public int findIndex(long searchKey) {
		int lowerBound = 0;
		int upperBound = numberOfElements - 1;

		int currentValue;

		while (true) {
			currentValue = (lowerBound + upperBound) / 2;
			if (array[currentValue] == searchKey) {
				return currentValue;
			} else if (lowerBound > upperBound) {
				return numberOfElements;
			} else {
				if (array[currentValue] < searchKey) {
					lowerBound = currentValue + 1; // it is in the upper half
				} else {
					upperBound = currentValue - 1; // it is in the lower half
				}
			}
		}
		
	}
	
	public long[] getArray() {
		return this.array;
	}
}
