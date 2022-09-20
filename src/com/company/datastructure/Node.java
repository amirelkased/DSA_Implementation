package com.company.datastructure;

class Node<T> {
    private final T value;
    Node<T> next;
    Node<T> Previous;

    public Node(T value) {
        this.value = value;
        this.next = null;
        this.Previous = null;
    }

    public T getValue() {
        return value;
    }
}
