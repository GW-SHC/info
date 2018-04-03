package com.shc;

import java.util.LinkedList;

public class Queue <T> {
    private LinkedList<T> q;

    public Queue() {
        q = new LinkedList<>();
    }

    /**
     * Adds item to the end of the queue
     * @param item data to be added to the queue
     */
    public void enqueue(T item) {
        q.addLast(item);
    }

    /**
     * Gets the first element of the queue. If non exist it will throw an error
     * @return the first item in the queue
     */
    public T dequeue() {
        return q.removeFirst();
    }

    /**
     * Same as dequeue but will return null rather than throw an exception if no elements exist
     * @return
     */
    public T safeDequeue() {
        if (q.size() == 0) {
            return null;
        }
        return q.removeFirst();
    }


    /**
     * gets the first element from the queue without removing it from its position
     * @return first item in the queue
     */
    public T peek() {
        return q.getFirst();
    }

    /**
     * same as peek; however it will not throw an error if nothing exists
     * @return
     */
    public T safePeek() {
        if (q.size() == 0) {
            return null;
        }
        return q.getFirst();
    }

    public int size() {
        return q.size();
    }

    @Override
    public String toString() {
        return q.toString();
    }
}
