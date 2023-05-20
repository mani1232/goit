package ua.mani123.module9;

import java.util.EmptyStackException;

public class MyStack<E> {
    private Node<E> top;
    private int size;

    private static class Node<E> {
        private final E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }

    public void push(E value) {
        Node<E> newNode = new Node<>(value);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        if (index == 0) {
            pop();
        } else {
            Node<E> currentNode = top;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }

            currentNode.next = currentNode.next.next;
            size--;
        }
    }

    public void clear() {
        top = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return top.data;
    }

    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        E value = top.data;
        top = top.next;
        size--;
        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
