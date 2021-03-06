package tipiGenerici;

public class Node<T> extends List<T> {
    private T value;
    private List next;

    public Node(T value, List next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return value + " " + next.toString();
    }

    @Override
    public List addLast(T x) {
        this.next = this.next.addLast(x);
        return this;
    }

    public void addLast2(T x){
        if(this.next instanceof Nil)
            this.next = new Node(x, this.next);
        else
            this.next.addLast2(x);
    }

    @Override
    public List add(T x, int i) {
        if(i==0) {
            this.next = new Node(this.value, this.next);
            this.value = x;
        }else{
            this.next = this.next.add(x, i-1);
        }
        return this;
    }

    @Override
    public List remove(T x) {
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
