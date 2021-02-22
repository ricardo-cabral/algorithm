package eu.ricardocabral.algorithm.datastructures;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class QueueTest {


  @Test
  public void shouldTestSizeOfTheQueue(){

    Queue<String> queue = new Queue<>();
    assertEquals(queue.size(), 0);
    queue.enqueue("A");
    assertEquals(queue.size(), 1);
    queue.dequeue();
    assertEquals(queue.size(), 0);
  }

  @Test
  public void shouldTestEmptyQueue(){
    Queue<String> queue = new Queue<>();
    assertEquals(queue.isEmpty(), true);
    queue.enqueue("A");
    assertEquals(queue.isEmpty(), false);
  }
  @Test(expected = NoSuchElementException.class)
  public void shouldTryToDequeueAnEmptyQueueAndThrowException() {
    Queue<String> queue = new Queue<>();
    queue.dequeue();
  }

  @Test
  public void shouldEnqueueAndDequeueValues(){
    Queue<String> queue = new Queue<>();
    queue.enqueue("A");
    queue.enqueue("B");
    queue.enqueue("C");
    assertEquals(queue.size(), 3);
    assertEquals(queue.dequeue(), "A");
    assertEquals(queue.dequeue(), "B");
    assertEquals(queue.dequeue(), "C");
    assertEquals(queue.isEmpty(), true);
  }

  @Test(expected = NoSuchElementException.class)
  public void shouldTryToGetHeadElementInAnEmptyQueueAndThrowException() {
    Queue<String> queue = new Queue<>();
    queue.getHeadElementWithoutDequeue();
  }

  @Test(expected = NoSuchElementException.class)
  public void shouldTryToGetTailElementInAnEmptyQueueAndThrowException() {
    Queue<String> queue = new Queue<>();
    queue.getTailElementWithoutDequeue();
  }
  @Test
  public void shouldGetHeadAndTailElementsWithoutDequeue(){
    Queue<String> queue = new Queue<>();
    queue.enqueue("A");
    queue.enqueue("B");
    queue.enqueue("C");
    assertEquals(queue.getHeadElementWithoutDequeue(), "A");
    assertEquals(queue.getTailElementWithoutDequeue(), "C");
    assertEquals(queue.isEmpty(), false);
    assertEquals(queue.size(), 3);
  }

}
