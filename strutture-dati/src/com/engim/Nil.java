package com.engim;

public class Nil extends List{

    @Override
    public String toString() {
        return "";
    }

    @Override
    public List addLast(int x) {
        return new Node(x, this);
    }

    @Override
    public void addLast2(int x) {
    }

    @Override
    public List add(int x, int i) {
        return new Node(x, this);
    }

    @Override
    public List remove(int x) {
        return this;
    }

    @Override
    public int length() {
        return 0;
    }
}
