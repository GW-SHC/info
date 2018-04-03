package com.shc;

public class Main {

    public static void main(String[] args) {
        queueExample();
        stackExample();
        hashMapExample();
    }

    public static void queueExample() {
        // starbucks order line
        Queue<String> queue = new Queue<>();
        String[] starBucksLine = {"gabe", "alex", "robbie", "beshoi",
                "henry", "lucas", "john", "neel"};

        for (String s: starBucksLine) {
            queue.enqueue(s);
        }

        System.out.println(queue); // verify we are all in the queue

        for (int i = 0; i<starBucksLine.length; i++) {
            System.out.println("Order Number: " + i + " for " + queue.dequeue());
        }
    }

    public static void stackExample() {
        Stack<Integer> stack = new Stack<>();
        int[] numbers = {1,2,3,4,5,6,7, 8};

        for (int i: numbers) {
            stack.push(i);
        }

        System.out.println(stack);

        Integer n = null;
        while ((n=stack.safePop()) != null) {
            System.out.println("current top of stack: " + n);
        }
    }

    public static void hashMapExample() {
        // id, user
        HashMap<Integer, String> map = new HashMap<>();
        int[] ids = {1, 2, 3, 4, 5, 6, 7, 8, 108};
        String[] names = {"gabe", "alex", "robbie", "beshoi",
                "henry", "lucas", "john", "neel", "gregor"};

        for (int i = 0; i < ids.length; i++) {
            map.put(ids[i],names[i]);
        }

        System.out.println(map);

        for (int i: ids) {
            System.out.println("User " + i + " is " + map.get(i));
        }
    }
}
