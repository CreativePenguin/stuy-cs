package hw.platek.queue;

public class Node<E> {
    private Node<E> next;
    private final E VALUE;

    public Node(E value, Node<E> next) {
        this.next = next;
        VALUE = value;
    }

    //accessor methods
    public Node<E> getNext() { return next; }
    public E getValue() { return VALUE; }

    public void setNext(Node<E> x) { next = x; }

    public static int max(Node<Integer> p) {
        int val = 0;
        maxH(p, val);
    }

    private static int maxH(Node<Integer> p, int val) {
        if(p.getValue() == null) return val;
        if(p.getValue() > val) return maxH(p.getNext(), p.getValue());
        else return maxH(p.getNext(), val);
    }

    public static void print(Node<Integer> p) {
        if(p.getValue() == null) return;
        System.out.println(p.getValue());
        print(p.getNext());
    }

    private static void printR(Node<Integer> p) {
        if(p.getValue() == null) return;
        print(p.getNext());
        System.out.println(p.getValue());
    }

    public static int length(Node<Integer> p) {
        if(p.getValue() == null) return 0;
        return length(p.getNext()) + 1;
    }

    public static void main(String[] args) {
        max(new Node<Integer>(3, new Node<Integer>(15, new Node<Integer>(-10, null))));
    }
}
