package tipiGenerici;

public class Nil<T> extends List<T> {

    @Override
    public String toString() {
        return "";
    }

    @Override
    public List addLast(T x) {
        return new Node(x, this);
    }

    @Override
    public void addLast2(T x) {
    }

    @Override
    public List add(T x, int i) {
        return new Node(x, this);
    }

    @Override
    public List remove(T x) {
        return this;
    }

    @Override
    public int length() {
        return 0;
    }
}
