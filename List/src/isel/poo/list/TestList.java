package isel.poo.list;

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
        System.out.println( hasElement(l1,27)); // -> true
        System.out.println( hasElement(l1,7));  // -> false
        System.out.println( hasRepeatedElements(l1)); // -> false
        l1.add(27);
        System.out.println( hasRepeatedElements(l1)); // -> true
    }

    private static boolean hasElement(LinkList l, int elem) {
        if (l.size() == 0) return false;
        if (elem == l.getFirst()) return true;
        while (l.hasNext())
            if (l.getNext()==elem) return true;
        return false;
    }

    private static boolean hasRepeatedElements(LinkList l) {
        // TODO:
        return false;
    }

    private static void printList(LinkList l) {
        if (l.size() > 0) {
            System.out.println(l.getFirst());
            while (l.hasNext())
                System.out.println(l.getNext());
        }
        /*
        for (int i = 0; i < l.size(); i++) {
            System.out.println( l.get(i) );
        }
         */
    }
}
