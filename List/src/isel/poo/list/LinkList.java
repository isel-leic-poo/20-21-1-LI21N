package isel.poo.list;

public class LinkList {
    Node first = null;
    //  TODO:  count

    public void add(int value) {
        first = new Node(value,first);
    }
    public int size() {
        Node n = first;
        for( int count=0 ;  ; ++count , n=n.next )
            if ( n==null ) return count;
    }
    public int get(int idx) {
        for(Node n=first ; ; --idx, n=n.next )
            if (idx==0) return n.elem;
    }

    public void remove(int idx) {
        if (idx==0) first = first.next;
        else {
            // TODO: only -> Node p
            Node p = first;
            --idx;
            for(Node n=first.next ; ; --idx, p=n, n=n.next )
                if (idx==0) {
                    p.next = n.next;
                    return;
                }
        }
    }
}
