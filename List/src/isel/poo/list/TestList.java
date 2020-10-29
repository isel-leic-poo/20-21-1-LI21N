package isel.poo.list;
import isel.poo.IntIterator;

public class TestList {
    public static void main(String[] args) {
        LinkList l1 = new LinkList();
        l1.add(27);
        l1.add(10);
        l1.add(50);
        l1.addFirst(5);
        printList(l1);
        l1.remove(2);
        printList(l1);
        System.out.println( countElements(l1,27)); // -> 1
        System.out.println( countElements(l1,7));  // -> 0
        System.out.println( hasRepeatedElements(l1)); // -> false
        l1.add(27);
        System.out.println( countElements(l1,27)); // -> 2
        System.out.println( hasRepeatedElements(l1)); // -> true
    }

    private static int countElements(LinkList l, int elem) {
        IntIterator it = l.getIterator();
        int count = 0;
        while ( it.hasNext() )
            if ( it.next() == elem ) ++count;
        return count;
    }

    private static boolean hasRepeatedElements(LinkList l) {
        for (IntIterator it = l.getIterator(); it.hasNext() ; )
            if (countElements(l,it.next())>1) return true;
        return false;
    }

    private static void printList(LinkList l) {
        for (IntIterator it = l.getIterator(); it.hasNext() ; )
            System.out.println( it.next() );
    }
}
