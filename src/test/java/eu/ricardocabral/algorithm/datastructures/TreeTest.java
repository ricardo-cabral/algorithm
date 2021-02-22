package eu.ricardocabral.algorithm.datastructures;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TreeTest {

  @Test
  public void shouldTestInsertValue(){
    Tree tree = new Tree(10);
    tree.insert(5);
    tree.insert(15);
    tree.insert(8);

    System.out.println("Print in order");
    tree.printInOrder();
    System.out.println("Print pre order");
    tree.printPreOrder();
    System.out.println("Print post order");
    tree.printPostOrder();

    assertTrue(tree.contains(8));
  }
}
