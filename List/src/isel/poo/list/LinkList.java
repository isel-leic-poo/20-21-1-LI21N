package isel.poo.list;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.ListIterator;

public class LinkList<T> extends AbstractList<T> {

    private static class Node<T> {
        Node<T> next;
        Node<T> prev;
        T elem;
        Node(T value, Node<T> next, Node<T> prev) {
            elem = value;
            this.next = next;
            this.prev = prev;
            if (prev!=null) prev.next = this;
            if (next!=null) next.prev = this;
        }
        T remove() {
            if (next!=null) next.prev = prev;
            if (prev!=null) prev.next = next;
            return elem;
        }
    }

    private Node<T> first = null;
    private Node<T> last = null;
    private int counter = 0;

    public void addFirst(T value) {
        first = new Node<>(value,first,null);
        if (last==null) last = first;
        ++counter;
    }
    public boolean add(T value) {
        last = new Node<>(value,null,last);
        if (first==null) first = last;
        ++counter;
        return true;
    }
    public int size() {
        return counter;
    }
    public T get(int idx) {
        for(Node<T> n=first ; ; --idx, n=n.next )
            if (idx==0) return n.elem;
    }

    public T remove(int idx) {
        T elem;
        if (idx==0) {
            elem = first.remove();
            first = first.next;
            if (first==null) last = null;
        }
        else {
            Node<T> p = first.next;
            for(--idx; idx>0 ;--idx )
                p = p.next;
            elem = p.remove();
            if (p.next==null) last=p.prev;
        }
        --counter;
        return elem;
    }

    private class Iter implements Iterator<T> {
        Node<T> cur = first;
        public boolean hasNext() {
            return cur!=null;
        }
        public T next() {
            T elem = cur.elem;
            cur = cur.next;
            return elem;
        }
    }
    public Iterator<T> iterator() { return new Iter(); }

    private class ListIter extends Iter implements ListIterator<T> {
        int idx = 0;
        int dir = 0;   // -1 prev ; 0 ??? ; 1 next
        public T next() {
            ++idx; dir=1;
            return super.next();
        }
        public boolean hasPrevious() { return cur.prev != null; }
        public T previous() {
            cur = cur.prev;
            --idx; dir=-1;
            return cur.elem;
        }
        public int nextIndex() { return idx; }
        public int previousIndex() { return idx-1; }
        public void remove() { throw new UnsupportedOperationException();  }
        public void set(T t) {
            switch (dir) {
                case 0: throw new IllegalStateException();
                case 1: cur.prev.elem = t; return;
                case -1: cur.elem = t;
            }
        }
        public void add(T t) {
            Node<T> n = new Node<>(t,cur, cur!=null ? cur.prev : last );
            if (cur==first) first = n;
            if (cur==null) last = n;
        }
    }
    public ListIterator<T> listIterator() { return new ListIter(); }
}
