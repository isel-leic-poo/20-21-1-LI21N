package isel.poo.list;
import isel.poo.IntIterator;

public class LinkList {

    private static class Node {
        Node next;
        int elem;
        Node(int value, Node next) {
            elem = value;
            this.next = next;
        }
    }

    private Node first = null;
    private Node last = null;
    private int counter = 0;

    public void addFirst(int value) {
        first = new Node(value,first);
        if (last==null) last = first;
        ++counter;
    }
    public void add(int value) {
        Node n = new Node(value,null);
        if (first==null) first = n;
        else last.next = n;
        last = n;
        ++counter;
    }
    public int size() {
        return counter;
    }
    public int get(int idx) {
        for(Node n=first ; ; --idx, n=n.next )
            if (idx==0) return n.elem;
    }

    public void remove(int idx) {
        if (idx==0) {
            first = first.next;
            if (first==null) last = null;
        }
        else {
            Node p = first;
            for(--idx; idx>0 ;--idx )
                p = p.next;
            p.next = p.next.next;
            if (p.next==null) last=p;
        }
        --counter;
    }

    // ---------------- Percorrer a list -----------
    /*
    private class It implements IntIterator {
        Node cur = first;
        public boolean hasNext() { return cur!=null; }
        public int next() {
            int elem = cur.elem;
            cur = cur.next;
            return elem;
        }
    }
    */
    public IntIterator getIterator() {
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
    }
}
