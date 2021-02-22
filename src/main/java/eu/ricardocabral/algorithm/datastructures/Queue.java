package eu.ricardocabral.algorithm.datastructures;

import java.util.NoSuchElementException;

/**
 * Type of list, inserts and deletions happen in the begin and end of it
 * First In First Out
 *
 * When to use
 * - Flow control
 * - Shared resources (printer, database transactions,etc
 *
 * Operations
 *
 * - create
 * - insert element in the beginning
 * - insert element in the end
 * - get the element in the beginning
 * - destroy it
 */
public class Queue<T> {

  private Node<T> head;
  private Node<T> tail;
  private int queueSize =0;


  public void enqueue(T data){
    Node<T> current = new Node<>(data);
    if(isEmpty()){
    head = current;
    tail = head;
    } else{
      Node<T> tmp = tail;
      tail = current;
      tmp.setNext(current);
    }
    queueSize++;
  };

  public T dequeue(){
    if(isEmpty()){
      throw new NoSuchElementException("Queue is empty");
    }
    Node<T> tmp = head;

    head = head.getNext();
    queueSize --;

    return tmp.getData();};

  public int size(){return queueSize;}

  public boolean isEmpty(){
    return queueSize == 0;
  }

  public T getHeadElementWithoutDequeue(){
    if(isEmpty()){
      throw new NoSuchElementException("Queue is empty");
    }
    return head.getData();
  }

  public T getTailElementWithoutDequeue(){
    if(isEmpty()){
      throw new NoSuchElementException("Queue is empty");
    }
    return tail.getData();
  }

}
