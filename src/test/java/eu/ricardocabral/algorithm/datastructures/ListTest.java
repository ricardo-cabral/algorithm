package eu.ricardocabral.algorithm.datastructures;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ListTest {

  @Test
  public void shouldInsertInTheEndAndIncreaseTheSize() {
    List list = new List();
    list.insertAtEnd(10);
    assertEquals(list.getSize(), 1);
  }

  @Test
  public void shouldInsertInTheBeginAndMoveItemToNextPosition() {
    List list = new List();
    list.insertAtEnd(1);
    list.insertInTheBegin(2);

    assertEquals(list.getData()[0], 2);
    assertEquals(list.getData()[1], 1);
    assertEquals(list.getSize(), 2);
  }

  @Test
  public void shouldInsertDataSorted() {
    List list = new List();
    list.insertSorted(20);
    list.insertSorted(4);
    list.insertSorted(3);
    list.insertSorted(1);
    list.insertSorted(2);

    assertEquals(list.getSize(), 5);
    assertEquals(list.getData()[0], 1);
    assertEquals(list.getData()[1], 2);
    assertEquals(list.getData()[2], 3);
    assertEquals(list.getData()[3], 4);
    assertEquals(list.getData()[4], 20);

  }

  @Test
  public void shouldRemoveAtTheEndOfTheList() {
    List list = new List();
    list.insertAtEnd(1);
    list.insertAtEnd(2);
    list.insertAtEnd(3);

    list.removeAtTheEnd();
    assertEquals(list.getSize(), 2);

  }

  @Test
  public void shouldRemoveAtTheEndOfTheListAnEmptyList() {
    List list = new List();

    list.removeAtTheEnd();
    assertEquals(list.getSize(), 0);

  }

  @Test
  public void shouldRemoveAtTheBeginningOfTheListAnEmptyList() {
    List list = new List();

    list.removeAtTheBegin();
    assertEquals(list.getSize(), 0);
  }

  @Test
  public void shouldRemoveAtTheBeginningOfTheList() {
    List list = new List();
    list.insertAtEnd(1);
    list.insertAtEnd(2);
    list.insertAtEnd(3);

    list.removeAtTheBegin();
    assertEquals(list.getSize(), 2);

  }

  @Test
  public void shouldRemoveByPosition() {

    List list = new List();
    list.insertAtEnd(1);
    list.insertAtEnd(2);
    list.insertAtEnd(3);

    list.removeByPosition(1);
    assertEquals(list.getSize(), 2);

  }

  @Test
  public void shouldRemoveByInvalidPosition() {

    List list = new List();
    list.insertAtEnd(1);
    list.insertAtEnd(2);
    list.insertAtEnd(3);

    list.removeByPosition(-1);
    assertEquals(list.getSize(), 3);

    list.removeByPosition(6);
    assertEquals(list.getSize(), 3);

  }

  @Test
  public void shouldRemoveByValue() {
    List list = new List();
    list.insertAtEnd(1);
    list.insertAtEnd(2);
    list.insertAtEnd(3);

    list.removeByValue(2);
    assertEquals(list.getSize(), 2);

  }

  @Test
  public void shouldTryToRemoveByInvalidValue() {
    List list = new List();
    list.insertAtEnd(1);
    list.insertAtEnd(2);
    list.insertAtEnd(3);

    list.removeByValue(5);
    assertEquals(list.getSize(), 3);

  }

  @Test
  public void shouldTryToRemoveByInvalidValueInEmptyList() {
    List list = new List();

    list.removeByValue(5);
    assertEquals(list.getSize(), 0);

  }

  @Test
  public void shouldGetValueByPosition() {
    List list = new List();
    list.insertAtEnd(1);
    list.insertAtEnd(2);
    list.insertAtEnd(3);

    int r = list.getByPosition(1);
    assertEquals(r, 2);

  }

  @Test
  public void shouldGetValueByInvalidPosition() {
    List list = new List();
    list.insertAtEnd(1);
    list.insertAtEnd(2);
    list.insertAtEnd(3);

    int r = list.getByPosition(4);
    assertEquals(r, -1);

     r = list.getByPosition(-3);
    assertEquals(r, -1);

  }

  @Test
  public void shouldGetPositionByValue() {
    List list = new List();
    list.insertAtEnd(1);
    list.insertAtEnd(2);
    list.insertAtEnd(3);

    int r = list.getPositionByValue(2);
    assertEquals(r, 1);

  }

  @Test
  public void shouldGetInvalidPositionByValue() {
    List list = new List();
    list.insertAtEnd(1);
    list.insertAtEnd(2);
    list.insertAtEnd(3);

    int r = list.getPositionByValue(4);
    assertEquals(r, -1);

  }

  @Test
  public void shouldResizeArrayAndInsertValueAutomatically() {
    List list = new List();
    list.insertAtEnd(1);
    list.insertAtEnd(2);
    list.insertAtEnd(3);
    list.insertAtEnd(4);
    list.insertAtEnd(5);
    list.insertAtEnd(6);
    list.insertAtEnd(7);
    list.insertAtEnd(8);
    list.insertAtEnd(9);
    list.insertAtEnd(10);
    list.insertAtEnd(11);

    assertEquals(list.getSize(), 11);

  }

  @Test
  public void shouldResizeArrayAndInsertValueSorted() {
    List list = new List();
    list.insertSorted(11);
    list.insertSorted(1);
    list.insertSorted(8);
    list.insertSorted(2);
    list.insertSorted(7);
    list.insertSorted(3);
    list.insertSorted(5);
    list.insertSorted(6);
    list.insertSorted(4);
    list.insertSorted(9);
    list.insertSorted(10);


    assertEquals(list.getSize(), 11);

  }


  @Test
  public void shouldResizeArrayAndInsertValueInTheBegin() {
    List list = getList();

    assertEquals(list.getSize(), 11);

  }

  @Test
  public void shouldReturnListToString() {
    List list = getList();

    assertNotNull(list.toString());

  }


  private List getList() {
    List list = new List();
    list.insertInTheBegin(11);
    list.insertInTheBegin(1);
    list.insertInTheBegin(8);
    list.insertInTheBegin(2);
    list.insertInTheBegin(7);
    list.insertInTheBegin(3);
    list.insertInTheBegin(5);
    list.insertInTheBegin(6);
    list.insertInTheBegin(4);
    list.insertInTheBegin(9);
    list.insertInTheBegin(10);
    return list;
  }

}
