package isel.poo.list;

public class TestList {
    public static void main(String[] args) {
        LinkList l1 = new LinkList();
        l1.add(27);
        l1.add(10);
        l1.add(50);
        printList(l1);
        l1.remove(0);
        printList(l1);
    }

    private static void printList(LinkList l1) {
        for (int i = 0; i < l1.size(); i++) {
            System.out.println(l1.get(i));
        }
    }
}
