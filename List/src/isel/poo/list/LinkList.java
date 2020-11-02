package isel.poo.list;
import isel.poo.Iterator;

public class LinkList<T> {

    private static class Node<T> {
        Node<T> next;
        T elem;
        Node(T value, Node<T> next) {
            elem = value;
            this.next = next;
        }
    }

    private Node<T> first = null;
    private Node<T> last = null;
    private int counter = 0;

    public void addFirst(T value) {
        first = new Node<>(value,first);
        if (last==null) last = first;
        ++counter;
    }
    public void add(T value) {
        Node<T> n = new Node<>(value,null);
        if (first==null) first = n;
        else last.next = n;
        last = n;
        ++counter;
    }
    public int size() {
        return counter;
    }
    public T get(int idx) {
        for(Node<T> n=first ; ; --idx, n=n.next )
            if (idx==0) return n.elem;
    }

    public void remove(int idx) {
        if (idx==0) {
            first = first.next;
            if (first==null) last = null;
        }
        else {
            Node<T> p = first;
            for(--idx; idx>0 ;--idx )
                p = p.next;
            p.next = p.next.next;
            if (p.next==null) last=p;
        }
        --counter;
    }

    public Iterator<T> getIterator() {
        /*
        class It implements IntIterator {
            Node cur = first;
            public boolean hasNext() { return cur!=null; }
            public int next() {
                int elem = cur.elem;
                cur = cur.next;
                return elem;
            }
        }
        return new It();
        */
        return new Iterator<T>() {
            Node<T> cur = first;
            public boolean hasNext() { return cur!=null; }
            public T next() {
                T elem = cur.elem;
                cur = cur.next;
                return elem;
            }
        };
    }
}
