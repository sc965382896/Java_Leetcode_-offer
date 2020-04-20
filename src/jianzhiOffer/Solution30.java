package jianzhiOffer;

// 包含min函数的栈

import java.util.Stack;

public class Solution30 {

    private Stack<Integer> numbers = new Stack<>();
    private Stack<Integer> min = new Stack<>();

    public void push(int node) {
        numbers.push(node);
        if (min.empty() || node < min.peek()) {
            min.push(node);
        } else {
            min.push(min.peek());
        }
    }

    public void pop() {
        if (numbers.empty()) {
            System.out.println("栈是空的");
            return;
        }
        numbers.pop();
        min.pop();
    }

    public int top() {
        if (numbers.empty()) {
            System.out.println("栈是空的");
            return -1;
        }
        return numbers.peek();
    }

    public int min() {
        if (min.empty()) {
            System.out.println("栈是空的");
            return -1;
        }
        return min.peek();
    }
}
