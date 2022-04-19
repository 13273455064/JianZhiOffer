package com.liquor.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class QueueImplStack {

    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    public static void main(String[] args) {
        final QueueImplStack stack = new QueueImplStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("top: " + stack.top());

        System.out.println("empty? " + stack.empty());



        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        queue1.addAll(queue2);
        queue2.clear();
    }

    public int pop() {
        return queue1.isEmpty() ? -1 : queue1.poll();
    }

    public int top() {
        return queue1.isEmpty() ? -1 : queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

}
