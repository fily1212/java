package com.engim;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class Stack<T> {
    private ArrayList<T> values;

    public Stack() {
        this.values = new ArrayList<>();
    }

    public void push(T value){
        values.add(value);
    }

    public T pop() throws EmptyException{

        if(!isEmpty()) {
            T v = values.get(values.size() - 1);
            values.remove(values.size() - 1);
            return v;
        }else
            throw new EmptyException();

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
