package com.engim;

public class MainStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.stampa();
        System.out.println(stack.pop());
        stack.stampa();
    }
}
