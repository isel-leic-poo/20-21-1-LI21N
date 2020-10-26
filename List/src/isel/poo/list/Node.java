package isel.poo.list;

class Node {
    Node next;
    int elem;

    Node(int value, Node next) {
        elem = value;
        this.next = next;
    }
}
