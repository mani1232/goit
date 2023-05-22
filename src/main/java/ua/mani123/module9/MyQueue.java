package ua.mani123.module9;

import java.util.NoSuchElementException;

public class MyQueue<E> {
    private Node<E> front;
    private Node<E> rear;
    private int size;

    private static class Node<E> {
        private final E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }

    public void add(E value) {
        Node<E> newNode = new Node<>(value);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        size++;
    }

    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return front.data;
    }

    public E poll() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        E value = front.data;
        front = front.next;
        size--;

        if (isEmpty()) {
            rear = null;
        }

        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
