package com.engim;

import java.util.ArrayList;

public class Stack<T> {
    private ArrayList<T> values;

    public Stack() {
        this.values = new ArrayList<>();
    }

    public void push(T value){
        values.add(value);
    }

    public T pop(){
        T v;
        if(!isEmpty()) {
            v = values.get(values.size() - 1);
            values.remove(values.size() - 1);
        }else
            v = null;
        return v;
    }

    public boolean isEmpty(){
        return values.isEmpty();
    }

    public void stampa(){
        if(isEmpty())
            System.out.println("[]");
        for (T elem: values ) {
            System.out.print(elem + " ");
        }

    }

    public int size(){
        return values.size();
    }
}
