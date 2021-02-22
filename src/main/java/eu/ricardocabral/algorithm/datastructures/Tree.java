package eu.ricardocabral.algorithm.datastructures;


/**
 *
 * It is a hierarchical (non-linear) data structure
 * A leaf has no children
 *
 * Balanced tree insertion and find: O(log n)
 * Unbalanced tree insertion and find O(n)
 *
 * Special type known as binary tree when a node has only two child nodes
 *  - Strict binary tree when a Node has both children (Either two or no children)
 *  - Full binary tree -> when the entire tree has both children and the leaf nodes are in the same level
 *  - Complete binary tree -> it is like a full binary tree, with two major differences
 *      1 - All the leaf elements must lean towards the left.
 *      2 - The last leaf element might not have a right sibling i.e. a complete binary tree doesn't have to be a full binary tree.
 *      https://www.programiz.com/dsa/complete-binary-tree
 *
 * When to use
 * - store information in forms of hierarchy (File System for instance, also HTML, XML, JSON, )
 * - binary search tree, heap, B-Tree and B+ Tree (used to implement indexing in the database)
 *
 *
 *
 * Operations
 *
 * - insert
 * - contains
 * -
 *
 */
public class Tree {

  Tree left;
  Tree right;
  int data;

  public Tree(int data) {
    this.data = data;
  }
  public void insert(int value){
    if(value <= data){ //insert in the left node
      if(left == null) {
        left = new Tree(value);
      } else {
        left.insert(value);
      }
    } else{ //insert in the right node
      if(right == null){
        right = new Tree(value);
      } else {
        right.insert(value);
      }
    }
  }

  public boolean contains(int value) {
    if (value == data) {
      return true;
    } else if (value < data) {
      if (left == null) {
        return false;
      } else {
        return left.contains(value);
      }
    } else {
        if(right == null) {
          return false;
        } else{
          return right.contains(value);
        }
    }
  }

  //left child, myself and right child
  public void printInOrder(){

    if(left != null ){
      left.printInOrder();
    }
    System.out.println(data);

    if(right != null ){
      right.printInOrder();
    }

  }

  //root first, left and right
  public void printPreOrder(){

    System.out.println(data);

    if(left != null ){
      left.printPreOrder();
    }

    if(right != null ){
      right.printPreOrder();
    }

  }

  //left child, right and root
  public void printPostOrder(){

    if(left != null ){
      left.printPostOrder();
    }


    if(right != null ){
      right.printPostOrder();
    }
    System.out.println(data);
  }
}
