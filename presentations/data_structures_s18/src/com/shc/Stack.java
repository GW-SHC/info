package com.shc;

import java.util.LinkedList;

public class Stack <T> {
    LinkedList<T> stack;

    public Stack() {
        stack = new LinkedList<>();
    }

    public void push(T item) {
        stack.addFirst(item);
    }

    public T pop() {
        return stack.removeFirst();
    }

    public T safePop() {
        if (stack.size() == 0) {
            return null;
        }
        return stack.removeFirst();
    }

    public T peek() {
        return stack.getFirst();
    }

    public T safePeek() {
        if (stack.size() == 0) {
            return null;
        }
        return stack.getFirst();
    }

    public int size() {
        return stack.size();
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}
