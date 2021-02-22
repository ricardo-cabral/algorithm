package eu.ricardocabral.algorithm.datastructures;

/**
 *
 * Last In First Out
 *
 * When to use
 * - a stack of books, plates for instance
 * - reverse a word. push a word to stack and get letters by letter back
 * - undo mechanism
 *
 *
 * Operations
 *
 * - add -> push
 * - delete -> pop
 * - find -> peek
 *
 */
public class Stack<E> {

  Object[] data;
  int count = 0;

  public Stack(){
    data = new Object[10];
  }

  //Add element to the top of the stack
  public E push(E element){
    if (count == data.length) resize(2*data.length);
    this.data[count] = element;
    this.count++;

    return element;
  }

  public E pop(){
    if(count == 0){
      return null;
    }
    E e = (E) this.data[count -1];
    this.data[count -1] = null;
    this.count--;

    // shrink size of array if necessary
    if (count > 0 && count == data.length/4) resize(data.length/2);
    return e;
  }

  public E peek(){

    if(count == 0){
      return null;
    }
    return (E) this.data[count -1];
  }

  public boolean isEmpty(){
    return count == 0;
  }

  public int size(){
    return count;
  }

  public void empty(){
    this.data = new Object[10];
    this.count = 0;
  }

  private void resize(int capacity) {

    Object[] copy = new Object[capacity];
    for (int i = 0; i < count; i++) {
      copy[i] = data[i];
    }
    data = copy;

  }
}
