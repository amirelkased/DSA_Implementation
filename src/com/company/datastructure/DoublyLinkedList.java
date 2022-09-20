package com.company.datastructure;


/**
 * TODO: insertAtFirst()
 * TODO: removeAtFirst()
 * TODO: insertAtLast()
 * TODO: removeAtLast()
 * TODO: insertAtIndex()
 * TODO: removeAtIndex()
 * TODO: display()
 * TODO: reverseDisplay()
 *
 * @param <T> it is a variety type.
 */
public class DoublyLinkedList<T> {

    private Node<T> First;
    private Node<T> Last;
    private int counter;

    public DoublyLinkedList() {
        First = null;
        Last = null;
        counter = 0;
    }

    /**
     * insert at end of linked-list
     *
     * @param value variety type
     */
    public void insertAtLast(T value) {
        incCounter();
        Node<T> newNode = new Node<>(value);
        if (First == null) {
            First = newNode;
        } else {
            Last.next = newNode;
            newNode.Previous = Last;
        }
        Last = newNode;
    }

    /**
     * remove from end.
     */
    public void removeAtLast() {
        if (isEmpty()) {
            System.out.println("Empty!");
            return;
        }
        decCounter();
        Node<T> temp = Last;
        Last = Last.Previous;
        Last.next = null;
        temp = null;
    }

    /**
     * add in first
     *
     * @param value variety type
     */
    public void insertAtFirst(T value) {
        incCounter();
        Node<T> newNode = new Node<>(value);
        if (First == null) {
            Last = newNode;
        } else {
            First.Previous = newNode;
            newNode.next = First;
        }
        First = newNode;
    }

    /**
     * remove element from begin list.
     */
    public void removeAtFirst() {
        if (isEmpty()) {
            System.out.println("Empty!");
            return;
        }
        decCounter();
        Node<T> temp = First;
        First = First.next;
        First.Previous = null;
        temp = null;
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
            Node<T> temp = First;
            for (int i = 1; i < index - 1; ++i) {
                temp = temp.next;
            }
            Node<T> newNode = new Node<>(value);
            newNode.next = temp.next;
            temp.next.Previous = newNode;
            temp.next = newNode;
            newNode.Previous = temp;
        } else {
            this.insertAtLast(value);
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
            Node<T> temp = First;
            for (int i = 1; i <= index - 2; ++i) {
                temp = temp.next;
            }
            Node<T> temp2 = temp.next;
            temp.next = temp2.next;
            temp = temp2.next;
            temp.Previous = temp2.Previous;
            temp2 = null;
        }
    }

    /**
     * print all data in regular order.
     */
    public void display() {
        Node<T> temp = First;
        while (temp != null) {
            System.out.println(temp.getValue() + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * print all data in reverse order.
     */
    public void reverseDisplay() {
        Node<T> temp = Last;
        while (temp != null) {
            System.out.println(temp.getValue() + " ");
            temp = temp.Previous;
        }
        System.out.println();
    }

    /**
     * check the list
     *
     * @return true is empty
     */
    public boolean isEmpty() {
        return First == null;
    }

    private void incCounter() {
        this.counter++;
    }

    private void decCounter() {
        this.counter--;
    }


}
