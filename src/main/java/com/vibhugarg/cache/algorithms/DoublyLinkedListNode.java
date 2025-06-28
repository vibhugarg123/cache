package com.vibhugarg.cache.algorithms;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoublyLinkedListNode<E> {
  private E element;
  private DoublyLinkedListNode<E> prev;
  private DoublyLinkedListNode<E> next;

  public DoublyLinkedListNode(E element) {
    this.element = element;
    this.next = null;
    this.prev = null;
  }

  public DoublyLinkedListNode<E> getPrev() {
    return this.prev;
  }

  public DoublyLinkedListNode<E> getNext() {
    return this.next;
  }

  public void setPrev(DoublyLinkedListNode<E> prev) {
    this.prev = prev;
  }

  public void setNext(DoublyLinkedListNode<E> next) {
    this.next = next;
  }

  public E getElement() {
    return this.element;
  }
}
