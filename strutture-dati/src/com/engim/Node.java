package com.engim;

public class Node extends List{
    private int value;
    private List next;

    public Node(int value, List next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return value + " " + next.toString();
    }

    @Override
    public List addLast(int x) {
        this.next = this.next.addLast(x);
        return this;
    }

    public void addLast2(int x){
        if(this.next instanceof Nil)
            this.next = new Node(x, this.next);
        else
            this.next.addLast2(x);
    }

    @Override
    public List add(int x, int i) {
        if(i==0) {
            this.next = new Node(this.value, this.next);
            this.value = x;
        }else{
            this.next = this.next.add(x, i-1);
        }
        return this;
    }

    @Override
    public List remove(int x) {
        if(this.value == x)
            return this.next.remove(x);
        else {
            this.next = this.next.remove(x);
            return this;
        }
    }

    @Override
    public int length() {
        return 1 + this.next.length();
    }
}
