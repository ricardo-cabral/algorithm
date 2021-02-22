package eu.ricardocabral.algorithm.datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {

  @Test
  public void shouldTestIfStackIsEmpty(){
    Stack stack = new Stack();
    assertEquals(stack.isEmpty(), true);
    assertEquals(stack.size(), 0);
  }

  @Test
  public void shouldTestPushAndPop() {

    Stack<String> stack = new Stack<>();
    assertNull(stack.pop());


    stack.push("A");
    stack.push("B");
    stack.push("C");
    assertEquals(stack.isEmpty(), false);
    assertEquals(stack.size(), 3);

    assertEquals(stack.pop(), "C");
    assertEquals(stack.size(), 2);
    assertEquals(stack.peek(), "B");
    assertEquals(stack.pop(), "B");
    assertEquals(stack.size(), 1);
    assertEquals(stack.pop(), "A");
    assertEquals(stack.size(), 0);
    assertNull(stack.pop());
    assertNull(stack.peek());


    stack.push("C");
    assertEquals(stack.size(), 1);
    stack.empty();
    assertEquals(stack.size(), 0);

  }

  @Test
  public void shouldResizeAndShrinkArray(){
    Stack<Integer> stack = new Stack<>();
    for (int i =0; i <=50; i++){
      stack.push(i);
    }
    assertEquals(stack.size(), 51);

    while(!stack.isEmpty()) {
      stack.pop();
    }
    assertEquals(stack.size(), 0);
    assertTrue(stack.isEmpty());
  }
}
