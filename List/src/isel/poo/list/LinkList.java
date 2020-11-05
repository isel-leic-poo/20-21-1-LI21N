package isel.poo.list;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.ListIterator;

public class LinkList<T> extends AbstractList<T> {

    private static class Node<T> {
        Node<T> next;
        Node<T> prev;  // TODO: modificar addFirst, add, e remove
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
    public boolean add(T value) {
        Node<T> n = new Node<>(value,null);
        if (first==null) first = n;
        else last.next = n;
        last = n;
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
            elem = first.elem;
            first = first.next;
            if (first==null) last = null;
        }
        else {
            Node<T> p = first;
            for(--idx; idx>0 ;--idx )
                p = p.next;
            elem = p.next.elem;
            p.next = p.next.next;
            if (p.next==null) last=p;
        }
        --counter;
        return elem;
    }

    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> cur = first;
            public boolean hasNext() {
                return cur!=null;
            }
            public T next() {
                T elem = cur.elem;
                cur = cur.next;
                return elem;
            }
        };
    }
    public ListIterator<T> listIterator() {
        return null; // TODO: implementar
    }
}
