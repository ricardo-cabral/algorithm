package eu.ricardocabral.algorithm.datastructures;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Constant time for insertions ore removals
 * finding a item takes proportional to the size of the list
 * For larger lists LinkedList has more overhead since pointers to the next and previous element
 */

public class LinkedListTest {

  @Test
  public void shouldAddDataWhenHeadIsNull() {
    LinkedList linkedList = new LinkedList<>();
    linkedList.addFirst(2);

    assertEquals(linkedList.getFirst(), 2);
    assertEquals(linkedList.getLast(), 2);

    assertEquals(linkedList.getSize(), 1);
  }

  @Test
  public void shouldAddDataInTheHead() {
    LinkedList linkedList = new LinkedList<>();
    linkedList.addLast(1);
    linkedList.addFirst(2);

    assertEquals(linkedList.getFirst(), 2);
    assertEquals(linkedList.getLast(), 1);

    assertEquals(linkedList.getSize(), 2);
  }

  @Test
  public void shouldAddANewNodeCheckFirstAndLast() {
    LinkedList linkedList = new LinkedList<>();
    linkedList.addLast(1);

    assertEquals(linkedList.getFirst(), 1);
    assertEquals(linkedList.getLast(), 1);
    assertEquals(linkedList.getSize(), 1);
  }


  @Test(expected = NoSuchElementException.class)
  public void shouldTryToGetHeadWithNullLinkedList() {
    LinkedList linkedList = new LinkedList();
    linkedList.getFirst();
  }

  @Test(expected = NoSuchElementException.class)
  public void shouldTryToGetTailWithNullLinkedList() {
    LinkedList linkedList = new LinkedList();
    linkedList.getLast();
  }

  @Test
  public void shouldAddTwoElementsAndCheckHeadAndTail() {
    LinkedList linkedList = new LinkedList();
    linkedList.addLast(1);
    linkedList.addLast(2);

    assertEquals(linkedList.getFirst(), 1);
    assertEquals(linkedList.getLast(), 2);
    assertEquals(linkedList.getSize(), 2);

  }

  @Test
  public void shouldInsertAtPositionTwoAndCheckHeadAndTail() {

    LinkedList linkedList = new LinkedList();
    linkedList.addLast(1);
    linkedList.addLast(2);
    linkedList.addLast(3);

    linkedList.addAt(1, 5);

    assertEquals(linkedList.getFirst(), 1);
    assertEquals(linkedList.getLast(), 3);
    assertEquals(linkedList.getSize(), 4);

  }

  @Test
  public void shouldAddANewValueToTheHead() {
    LinkedList linkedList = new LinkedList();
    linkedList.addLast(1);
    linkedList.addLast(2);
    linkedList.addFirst(3);

    assertEquals(linkedList.getFirst(), 3);
    assertEquals(linkedList.getLast(), 2);
    assertEquals(linkedList.getSize(), 3);
  }

  @Test(expected = NoSuchElementException.class)
  public void shouldTryTAddInAnInvalidPosition() {
    LinkedList linkedList = new LinkedList();
    linkedList.addLast(3);
    linkedList.addAt(3, 2);
  }


  @Test
  public void shouldAddAtPosition() {
    LinkedList linkedList = new LinkedList();
    linkedList.addLast(1);
    linkedList.addLast(2);
    linkedList.addLast(3);
    linkedList.addAt(1, 4);

    assertEquals(linkedList.getFirst(), 1);
    assertEquals(linkedList.getLast(), 3);
    assertEquals(linkedList.getSize(), 4);

  }

  @Test
  public void shouldAddAt() {
    LinkedList linkedList = new LinkedList();
    linkedList.addLast(1);
    linkedList.addLast(2);
    linkedList.addLast(3);
    linkedList.addLast(4);
    linkedList.addAt(2, 5);

    assertEquals(linkedList.getFirst(), 1);
    assertEquals(linkedList.getLast(), 4);
    assertEquals(linkedList.getSize(), 5);

  }

  @Test
  public void shouldGetAtPosition() {
    LinkedList<Integer> linkedList = new LinkedList();
    linkedList.addLast(1);
    linkedList.addLast(2);
    linkedList.addLast(3);
    linkedList.addLast(4);

    assertEquals(linkedList.getAt(2).getData().intValue(), 3);
  }

  @Test
  public void shouldPrintList() {
    LinkedList linkedList = new LinkedList();
    linkedList.addLast(1);
    linkedList.addLast(2);
    linkedList.addLast(3);
    linkedList.addLast(4);

    linkedList.printList();
  }

  @Test
  public void shouldTestListEmpty() {
    LinkedList linkedList = new LinkedList();
    assertTrue(linkedList.isEmpty());

  }

  @Test(expected = NoSuchElementException.class)
  public void shouldTryToInsertAndIndexLowerThan0AndGetException() {
    LinkedList linkedList = new LinkedList();
    linkedList.addAt(-1, null);
  }

  @Test(expected = NoSuchElementException.class)
  public void shouldTryToInsertAndIndexIsGreaterThan0AndGetException() {
    LinkedList linkedList = new LinkedList();
    linkedList.addAt(10, null);
  }

  @Test(expected = NoSuchElementException.class)
  public void shouldTryToRemoveFirstWhenHeadIsnullAndThrowsException() {
    LinkedList linkedList = new LinkedList();
    linkedList.removeFirst();
  }

  @Test
  public void shouldRemoveFirstWhenHeadHasOneElement() {
    LinkedList linkedList = new LinkedList();
    linkedList.addFirst(3);

    linkedList.removeFirst();

    assertTrue(linkedList.isEmpty());
  }

  @Test
  public void shouldRemoveFirstElement() {
    LinkedList linkedList = new LinkedList();
    linkedList.addFirst(3);
    linkedList.addFirst(2);
    linkedList.addFirst(1);

    linkedList.removeFirst();

    assertEquals(linkedList.getFirst(), 2);
    assertEquals(linkedList.getLast(), 3);
    assertEquals(linkedList.getSize(), 2);
  }

  @Test(expected = NoSuchElementException.class)
  public void shouldTryToRemoveLastWhenNullAndThrowException() {
    LinkedList linkedList = new LinkedList();
    linkedList.removeLast();
  }

  @Test
  public void shouldRemoveLastWhenListHasOnlyHead() {

    LinkedList linkedList = new LinkedList();
    linkedList.addFirst(2);
    linkedList.removeLast();

    assertEquals(linkedList.getSize(), 0);
  }

  @Test
  public void shouldRemoveLast() {

    LinkedList linkedList = new LinkedList();
    linkedList.addLast(1);
    linkedList.addLast(2);
    linkedList.addLast(3);


    assertEquals(linkedList.getLast(), 3);

    linkedList.removeLast();

    assertEquals(2, linkedList.getSize());
    assertEquals(1, linkedList.getFirst());
    assertEquals(2, linkedList.getLast());
  }

  @Test
  public void shouldRemoveByValue() {
    LinkedList linkedList = new LinkedList();
    linkedList.addLast(1);
    linkedList.addLast(2);
    linkedList.addLast(3);

    linkedList.removeByValue(2);

    assertEquals(2, linkedList.getSize());
    assertEquals(1, linkedList.getFirst());
    assertEquals(3, linkedList.getLast());

  }

  @Test
  public void shouldNotRemoveByNonexistentValue() {
    LinkedList linkedList = new LinkedList();
    linkedList.addLast(1);
    linkedList.addLast(2);
    linkedList.addLast(3);

    linkedList.removeByValue(6);

    assertEquals(3, linkedList.getSize());
    assertEquals(1, linkedList.getFirst());
    assertEquals(3, linkedList.getLast());

  }

  @Test(expected = NoSuchElementException.class)
  public void shouldTryToRemoveWithHeadNullAndGetAnException() {
    LinkedList linkedList = new LinkedList();
    linkedList.removeByValue(5);
  }

  @Test
  public void shouldRemoveValueWhenItHasOneNode() {
    LinkedList linkedList = new LinkedList();
    linkedList.addLast(1);
    linkedList.removeByValue(1);

    assertEquals(0, linkedList.getSize());
  }

}
