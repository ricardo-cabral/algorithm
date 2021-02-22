package eu.ricardocabral.algorithm.datastructures;

import java.util.NoSuchElementException;

/**
 * Linear data structure in which each element of the list contains a pointer
 * which points to the next element in the list
 *
 * For a circular linked list tail needs to set Head as a next element
 *
 * <p>
 * Advantages
 * - Better memory resources utilization
 * - There is no need to move elements in the insertion and deletion
 * <p>
 * Disadvantages
 * - Indirect access to the elements
 * - Need to go through the list to access an element
 *
 * When to use
 * - When I am not sure about how much memory I need, there is no need to pre allocate memory like arraylist
 * - Insertion and deletion in a ordered list are the most frequent operations
 */
public class LinkedList<T> {

  private int size = 0;
  private Node<T> head;
  private Node<T> tail;

  public LinkedList() {
    head = null;
  }

  /**
   * Adds data to the head of the LinkedList
   *
   * @param data
   */
  public void addFirst(T data) {

    Node<T> node = new Node(data);

    if(head == null){
      head = node;
      tail = node;
      size ++;
      return;
    }
    Node<T> tmp = head;
    tmp.setPrevious(node);
    node.setNext(tmp);

    head = node;
    size++;
  }


  public void addLast(int data) {
    Node<T> node = new Node(data);

    if (head == null) {
      head = node;
      tail = node;
      size ++;
      return;

    }

    if(head.getNext() == null){
      node.setPrevious(head);
      head.setNext(node);
      tail = node;
      size ++;
      return;
    }

    Node tmp = head.getNext();

    while(tmp.getNext() != null) {
       tmp = tmp.getNext();
    }

    node.setPrevious(tmp);
    tmp.setNext(node);

    tail = node;

    size++;
  }

  public void addAt(int index, T data) {
    if (!indexExists(index) || isEmpty()) {
      throw new NoSuchElementException("Index does not exist");
    }
    Node<T> newNode = new Node(data);

    Node<T> current = getAt(index);

    newNode.setPrevious(current);
    newNode.setNext(current.getNext());
    current.setNext(newNode);

    size++;


  }

  private boolean indexExists(int index) {
    return index < 0 || index <= size;
  }



  /**
   * returns node found in index i
   *
   * @param index
   * @return Node of T
   */
  Node<T> getAt(int index) {

    Node<T> node = head;

    for (int i = 0; i < index; i++) {
      node = node.getNext();
    }
    return node;

  }



  public T getFirst() {
    if (this.head == null) {
      throw new NoSuchElementException("Element was not found");
    }
    return this.head.getData();
  }

  public T getLast() {
    if (this.tail == null) {
      throw new NoSuchElementException("Element was not found");
    }
    return this.tail.getData();
  }

  public int getSize() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.head == null;
  }

  public void printList() {
    Node<T> node = head;

    while (node.getNext() != null) {
      System.out.print(" " + node.getData());
      node = node.getNext();
    }
    System.out.print(" " + node.getData());
  }

  public void removeFirst(){
    if(head == null ){
      throw new NoSuchElementException("Element was not found");
    }

    Node<T> tmp = head.getNext();

    if(tmp == null){
      head = null;
      tail = null;
      size--;
      return;
    }

    tmp.setPrevious(null);
    head = tmp;
    size--;

  }

  public void removeLast(){
    if(head == null ){
      throw new NoSuchElementException("Element was not found");
    }

    if(head.getNext() == null){
      head = null;
      tail = null;
      size --;
      return;
    }

    Node last = head.getNext();

    while(last.getNext() != null) {
      last = last.getNext();
    }

    Node newLast = last.getPrevious();
    newLast.setNext(null);

    tail = newLast;
    size--;
  }

  public void removeByValue(T data){
    if(head == null ){
      throw new NoSuchElementException("Element was not found");
    }

    Node<T> tmp = head;
    if(tmp.getData().equals(data)){
      head = null;
      size = 0;
    }

    boolean found = false;
    while(tmp.getNext() != null && found == false){
      if(tmp.getData().equals(data)){
        Node<T> previous = tmp.getPrevious();
        previous.setNext(tmp.getNext());
        size --;
        found =true;
      }
      tmp = tmp.getNext();

    }
  }
}
