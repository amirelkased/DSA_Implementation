package com.company.datastructure;

/*
 * We need to do all fun
 * TODO: push(new value)
 * TODO: pop()
 * TODO: pop() with return value
 * note that with two pop we need built method TODO: isEmpty
 * TODO: getTop()
 * TODO: display()
 * TODO: length()
 */

public class LinkedListStack<T> {
    private Node<T> Top;

    private int counter;

    public LinkedListStack() {
        Top = null;
    }

    /**
     * Insert new value
     *
     * @param value new
     */
    public void push(T value) {
        incCounter();
        Node<T> newNode = new Node<>(value);
        if (Top == null) {
            Top = newNode;
            return;
        }
        newNode.next = Top;
        Top = newNode;
    }

    /**
     * check method over stack
     *
     * @return true if stack is empty
     */
    public boolean isEmpty() {
        return Top == null;
    }

    /**
     * delete last value was inserted
     * stack is First Input Last Output
     */
    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return;
        }
        Node<T> temp = Top;
        Top = Top.next;
        temp = null;
        decCounter();
    }

    /**
     * this pop fun but has new feature
     * that is return value that will delete
     *
     * @return deleted value
     */
    public T popWithValue() {
        T value = Top.getValue();
        pop();
        return value;
    }

    /**
     * get last value was inserted
     *
     * @return last value
     */
    public T getTop() {
        return Top.getValue();
    }

    /**
     * print all values from Top to Bottom
     */
    public void display() {
        Node<T> ptr = Top;
        while (ptr != null) {
            System.out.println(ptr.getValue());
            ptr = ptr.next;
        }
    }

    /**
     * calculate length of stack
     *
     * @return length
     */
    public int length() {
        return counter;
    }

    public void incCounter() {
        ++this.counter;
    }

    public void decCounter() {
        --this.counter;
    }
}

