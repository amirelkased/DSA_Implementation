package com.company.datastructure;

/**
 * What do you need to do?
 * TODO: enqueue(value)
 * TODO: dequeue()
 * TODO: length()
 * TODO: display()
 * TODO: getFront()
 * TODO: getRear()
 * TODO: isEmpty()
 */

public class LinkedListQueue<T> {
    private Node<T> front;
    private Node<T> rear;
    private int counter;

    public LinkedListQueue() {
        front = null;
        rear = null;
        counter = 0;
    }

    /**
     * insert new value
     *
     * @param value new
     */
    public void enqueue(T value) {
        incCounter();
        Node<T> newNode = new Node<>(value);
        if (front == null) {
            front = newNode;
            rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    /**
     * delete first input value
     */
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return;
        }
        decCounter();
        Node<T> temp = front;
        front = front.next;
        temp = null;
    }

    /**
     * Display all values
     */
    public void display() {
        Node<T> Front = front;
        while (Front != null) {
            System.out.print(Front.getValue() + ", ");
            Front = Front.next;
        }
        System.out.println();
    }

    /**
     * check whether is empty queue or not
     *
     * @return true if is empty
     */
    public boolean isEmpty() {
        return front == null;
    }

    /**
     * return first inserted element
     *
     * @return first
     */
    public T getFront() {
        return front.getValue();
    }

    /**
     * last element inserted
     *
     * @return last element
     */
    public T getRear() {
        return rear.getValue();
    }

    /**
     * what is the length of queue now
     *
     * @return length
     */
    public int length() {
        return counter;
    }

    private void incCounter() {
        ++this.counter;
    }

    private void decCounter() {
        --this.counter;
    }
}