package com.vibhugarg.cache.algorithms;

import com.vibhugarg.cache.exceptions.InvalidElementException;
import com.vibhugarg.cache.exceptions.ResourceNotFoundException;
import lombok.Getter;

@Getter
public class DoublyLinkedList<E> {

  private DoublyLinkedListNode<E> dummyHead;
  private DoublyLinkedListNode<E> dummyTail;

  public DoublyLinkedList() {
    this.dummyHead = new DoublyLinkedListNode<>(null);
    this.dummyTail = new DoublyLinkedListNode<>(null);
    // Empty DLL, there are no items
    // Join dummyHead and Tail, we can add items in between them easily.
    this.dummyHead.setNext(this.dummyTail);
    this.dummyTail.setPrev(this.dummyHead);
  }

  /**
   * Helper method to add a node at the end of the list.
   *
   * @param node Node to be added.
   */
  public void addNodeToLast(DoublyLinkedListNode<E> node) {
    DoublyLinkedListNode<E> tailPrev = this.dummyTail.getPrev();
    tailPrev.setNext(node);
    node.setNext(this.dummyTail);
    this.dummyTail.setPrev(node);
    node.setPrev(tailPrev);
  }

  /**
   * Method to detach a random node from the doubly linked list. The node itself will not be removed
   * from the memory. Just that it will be removed from the list and become orphaned.
   *
   * @param node Node to be detached.
   */
  public void detachNode(DoublyLinkedListNode<E> node) {
    // Just Simply modifying the pointers.
    if (node != null) {
      node.getPrev().setNext(node.getNext());
      node.getNext().setPrev(node.getPrev());
    }
  }

  public DoublyLinkedListNode<E> addElementAtLast(E element) {
    if (element == null) {
      throw new InvalidElementException("null is not a valid element");
    }
    DoublyLinkedListNode<E> newNode = new DoublyLinkedListNode<>(element);
    addNodeToLast(newNode);
    return newNode;
  }

  public boolean isItemPresent() {
    return dummyHead.getNext() != dummyTail;
  }

  public DoublyLinkedListNode<E> getFirstNode() throws ResourceNotFoundException {
    DoublyLinkedListNode<E> item = null;
    if (!isItemPresent()) {
      return null;
    }
    return dummyHead.getNext();
  }

  public DoublyLinkedListNode<E> getLastNode() throws ResourceNotFoundException {
    DoublyLinkedListNode<E> item = null;
    if (!isItemPresent()) {
      return null;
    }
    return dummyTail.getPrev();
  }
}
