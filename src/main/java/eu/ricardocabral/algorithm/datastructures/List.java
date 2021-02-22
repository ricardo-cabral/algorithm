package eu.ricardocabral.algorithm.datastructures;



/**
 * Sequence of elements containing the same type
 * <p>
 * - memory allocation happens in compilation time
 * - it demands the definition of a max elements in it
 * - Sequential access
 * <p>
 * Advantages
 * - Quick access to the indices of the elements
 * - constant time to access the element
 * - easy to change what is inside the element
 * <p>
 * Disadvantages
 * <p>
 * - Previous definition of the size, resize once it is full
 * - problems to insert or remove one element between the others, it needs to move the rest
 * <p>
 * When to use
 * <p>
 * - Small lists
 * - Insertion and deletion only at the end of the list
 * - Max size well defined
 * - Search is the most frequent operation
 */
public class List {

  private final int MAX_SIZE = 10;
  private int[] array = new int[MAX_SIZE];
  private int CURRENT_SIZE = 0;

  public int getSize() {
    return this.CURRENT_SIZE;
  }

  private boolean isFull() {
    return this.CURRENT_SIZE == this.MAX_SIZE;
  }

  public boolean isEmpty() {
    return this.getSize() == 0;
  }

  public void insertAtEnd(int data) {

    if (isFull()) {
      growArray();
    }
    this.array[CURRENT_SIZE] = data;
    CURRENT_SIZE++;
  }

  private void growArray() {
    int [] newArray = new int[ CURRENT_SIZE + 10];

    for (int i = 0; i <CURRENT_SIZE; i++){
      newArray[i] = array[i];
    }

    array = newArray;
  }

  public void insertInTheBegin(int data) {

    if (isFull()) {
      growArray();
    }

    if (isEmpty()) {
      array[CURRENT_SIZE] = data;
    }


    for (int i = array.length - 1; i > 0; i--) {
      array[i] = array[i - 1];
    }
    array[0] = data;
    CURRENT_SIZE++;
  }

  public void insertSorted(int data) {
    if (isFull()) {
      growArray();
    }

    if (isEmpty()) {
      array[CURRENT_SIZE] = data;
      CURRENT_SIZE++;
      return;
    }

    int i = 0;
    while (array[i] < data) {
      i++;
    }

    for (int j = array.length - 1; j > i; j--) {
      array[j] = array[j - 1];
    }
    array[i] = data;
    CURRENT_SIZE++;

  }

  public void removeByPosition(int position) {
    if (position < 0 || position > CURRENT_SIZE) {
      return;
    }

    for (int j = position; position < CURRENT_SIZE; position++) {
      array[position] = array[position + 1];
    }
    CURRENT_SIZE--;
  }

  public void removeAtTheEnd() {
    if (isEmpty()) {
      return;
    }
    CURRENT_SIZE--;
  }

  public void removeAtTheBegin() {
    if (isEmpty()) {
      return;
    }
    for (int i = 0; i < CURRENT_SIZE; i++) {
      array[i] = array[i + 1];
    }

    CURRENT_SIZE--;

  }

  public void removeByValue(int value) {
    if (isEmpty()) {
      return;
    }

    int i = 0;
    boolean found = false;
    while (i < CURRENT_SIZE) {
      if (array[i] == value) {
        found = true;
        break;
      }
      i++;
    }

    if (!found) {
      return;
    }

    for (int j = i; j < CURRENT_SIZE; j++) {
      array[j] = array[j + 1];
    }
    CURRENT_SIZE--;

  }

  public int getByPosition(int position) {

    if (position < 0 || position > CURRENT_SIZE) {
      return -1;
    }

    return array[position];

  }

  public int getPositionByValue(int value) {
    for (int i = 0; i < CURRENT_SIZE; i++) {
      if (array[i] == value) {
        return i;
      }
    }

    return -1;

  }

  public int[] getData() {
    return array;
  }

  @Override
  public String toString() {

    StringBuilder builder = new StringBuilder("[ ");
    for (int i = 0; i < CURRENT_SIZE; i++) {
      builder.append(array[i] + " ");
    }
    builder.append("]");

    return builder.toString();
  }
}
