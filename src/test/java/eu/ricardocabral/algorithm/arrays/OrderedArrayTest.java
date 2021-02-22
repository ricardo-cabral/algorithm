package eu.ricardocabral.algorithm.arrays;

import org.junit.Assert;
import org.junit.Test;

public class OrderedArrayTest {
	
	
	@Test
	public void shouldInsertANumber() {
		OrderedArray orderedArray = new OrderedArray(1);
		orderedArray.insert(44);
		Assert.assertEquals(orderedArray.getArray()[0], 44);
	}
	
	@Test
	public void shouldInsertTwoNumbersAndOrderTheArray() {
		OrderedArray orderedArray = new OrderedArray(2);
		orderedArray.insert(44);
		orderedArray.insert(33);
		Assert.assertEquals(orderedArray.getArray()[0], 33);
		Assert.assertEquals(orderedArray.getArray()[1], 44);

	}
	
	@Test
	public void shouldInsertFourNumbersAndOrderTheArray() {
		OrderedArray orderedArray = new OrderedArray(4);
		orderedArray.insert(44);
		orderedArray.insert(33);
		orderedArray.insert(22);
		orderedArray.insert(66);
		Assert.assertEquals(orderedArray.getArray()[0], 22);
		Assert.assertEquals(orderedArray.getArray()[1], 33);
		Assert.assertEquals(orderedArray.getArray()[2], 44);
		Assert.assertEquals(orderedArray.getArray()[3], 66);

	}
	
	
	@Test
	public void shouldFindANumberBasedOnTheIndex() {
		long searchKey = 1;
		OrderedArray orderedArray = new OrderedArray(4);
		orderedArray.insert(33);
		orderedArray.insert(44);
		orderedArray.insert(22);
		orderedArray.insert(66);
		Assert.assertEquals(searchKey, orderedArray.findIndex(33));
	}
	
	@Test
	public void shouldNotDeleteANotFoundElement() {
		OrderedArray orderedArray = new OrderedArray(4);
		orderedArray.insert(33);
		orderedArray.insert(44);
		orderedArray.insert(22);
		orderedArray.insert(66);
		Assert.assertFalse(orderedArray.delete(99));
	}
	
	@Test 
	public void shouldDeleteAFoundNumber() {
		OrderedArray orderedArray = new OrderedArray(4);
		orderedArray.insert(33);
		orderedArray.insert(44);
		orderedArray.insert(22);
		orderedArray.insert(66);
		Assert.assertTrue(orderedArray.delete(44));
		
	}

}
