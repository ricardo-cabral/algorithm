package eu.ricardocabral.algorithm.datastructures;

public class Node<T> {

  private T data;
  private Node next;
  private Node previous;


  Node(T data) {
    this.data = data;
    this.next = null;
  }

  public T getData(){
    return this.data;
  }

  public Node getNext(){
    return this.next;
  }

  public void setNext(Node next){
    this.next = next;
  }

  public void setPrevious(Node previous){
    this.previous = previous;
  }

  public Node getPrevious(){
    return previous;
  }
}
