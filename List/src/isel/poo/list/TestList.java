package isel.poo.list;

public class TestList {
    public static void main(String[] args) {
        LinkList<Integer> l1 = new LinkList<>();
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

        LinkList<String> ls = new LinkList<>();
        ls.add("abc");
        ls.add("xpto");
        printList(ls);
    }

    private static int countElements(Iterable<Integer> l, int elem) {
        int count = 0;
        for (Integer integer : l)
            if (integer == elem) ++count;
        return count;
    }

    private static boolean hasRepeatedElements(Iterable<Integer> l) {
        for (Integer elem : l)
            if (countElements(l, elem) > 1) return true;
        return false;
    }

    private static <T> void printList(Iterable<T> l) {
        for (T t : l)
            System.out.println(t);
    }
}
