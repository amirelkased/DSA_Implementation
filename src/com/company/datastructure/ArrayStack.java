package com.company.datastructure;

import java.util.Arrays;

public class ArrayStack {
    private int top;
    private int[] stack = new int[100];

    {
        top = -1;
    }

    public ArrayStack() {
    }

    /**
     * To insert new Element
     *
     * @param num -> new element
     */
    public void add(int num) {
        if (isFull()) {
            System.out.println("out of memory");
            return;
        }
        ++this.top;
        stack[top] = num;
    }

    /**
     * To delete last element
     *
     * @return last element
     */
    public void delete() {
        try {
            int temp = stack[top];
            stack[top] = 0;
            --top;
        } catch (Exception ignored) {
        }
    }

    /**
     * current pos of @top is a length
     *
     * @return top
     */
    public int length() {
        return top + 1;
    }

    /**
     * last element without delete
     *
     * @return last element
     */
    public int top() {
        return stack[top];
    }

    /**
     * check if stack is empty or not
     *
     * @return true if empty otherwise false
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * check size of memory
     *
     * @return true if array is completed
     */
    private boolean isFull() {
        return top == stack.length - 1;
    }

    /**
     * all stack element
     *
     * @return String
     */
    public String print() {
        return Arrays.toString(Arrays.copyOfRange(stack, 0, top + 1).clone());
    }
}
