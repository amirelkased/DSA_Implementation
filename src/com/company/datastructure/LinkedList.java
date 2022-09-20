package com.company.datastructure;

/**
 * TODO: insertAtFirst()
 * TODO: insertAtLast()
 * TODO: insertAtIndex()
 * TODO: removeAtFirst()
 * TODO: removeAtLast()
 * TODO: removeAtIndex()
 *
 * @param <T> it is a variety type.
 */

public class LinkedList<T> {
    private Node<T> Head;
    private Node<T> Tail;
    private int counter;

    public LinkedList() {
        Head = null;
        Tail = null;
        counter = 0;
    }

    /**
     * add in first
     *
     * @param value variety type
     */
    public void insertAtFirst(T value) {
        incCounter();
        Node<T> newNode = new Node<>(value);
        if (Head == null) {
            Head = newNode;
            Tail = newNode;
        } else {
            newNode.next = Head;
            Head = newNode;
        }
    }

    /**
     * insert at specific index
     *
     * @param index 1-based
     * @param value variety type
     */
    public void insertAtIndex(int index, T value) {
        if (index <= counter) {
            incCounter();
            Node<T> temp = Head;
            for (int i = 1; i < index - 1; ++i) {
                temp = temp.next;
            }
            Node<T> newNode = new Node<>(value);
            newNode.next = temp.next;
            temp.next = newNode;
        } else {
            this.insertAtLast(value);
        }
    }

    /**
     * insert at end of linked-list
     *
     * @param value variety type
     */
    public void insertAtLast(T value) {
        incCounter();
        Node<T> newNode = new Node<>(value);
        if (Head == null) {
            Head = newNode;
        } else {
            Tail.next = newNode;
        }
        Tail = newNode;
    }

    /**
     * remove element from begin list.
     */
    public void removeAtFirst() {
        if (!isEmpty()) {
            decCounter();
            Node<T> temp = Head;
            Head = Head.next;
            temp = null;
        }
    }

    /**
     * remove from end.
     */
    public void removeAtLast() {
        if (!isEmpty()) {
            decCounter();
            Node<T> temp = Head;
            while (temp.next != Tail) {
                temp = temp.next;
            }
            Tail = temp;
            Tail.next = null;
            temp = null;
        }
    }

    /**
     * remove specific element
     *
     * @param index 1-based
     */
    public void removeAtIndex(int index) {
        if (index == 1) {
            decCounter();
            removeAtFirst();
        } else if (!isEmpty()) {
            decCounter();
            Node<T> temp = Head;
            for (int i = 1; i <= index - 2; ++i) {
                temp = temp.next;
            }
            Node<T> temp2 = temp.next;
            temp.next = temp2.next;
            temp2 = null;
        }
    }

    /**
     * print all data in it.
     */
    public void display() {
        Node<T> first = Head;
        while (first != null) {
            System.out.print(first.getValue() + " ");
            first = first.next;
        }
        System.out.println();
    }

    /**
     * check the list
     *
     * @return true is empty
     */
    public boolean isEmpty() {
        return Head == null;
    }

    private void incCounter() {
        this.counter++;
    }

    private void decCounter() {
        this.counter--;
    }
}
