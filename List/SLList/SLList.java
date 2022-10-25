public class SLList <T> {
    private class Node {
    T item;
    Node next;

    public Node( T itm, Node n) {
        item = itm;
        next = n;
    }

    public Node( Node n) {
        next = n;
    }
}

    /* Invariant: The first item (if it exists) is at sentinel.next. */
    private Node sentinel;
    private int size;

    /** Creates an empty SLList. */
    public SLList(){
        sentinel = new Node(null);
        size = 0;
    }

    public SLList(T itm) {
        sentinel = new Node(null);
        sentinel.next = new Node(itm, null);
        size = 1;
    }

    /** Add an item to the front of the list. */
    public void addFirst( T itm) {
        sentinel.next = new Node(itm, sentinel.next);
        size++;
    }

    /** Add an item to the end of the list iteratively. */
    public void addLast( T itm) {
        size++;

        Node p = sentinel;
        /* Move p until it reaches the end of the list. */
        while (p.next != null) {
            p = p.next;
        }
        p.next = new Node(itm, null);
    }

    /** Get the number of items in the list immediately. */
    public int size() {
        return size;
    }
    /** Return the first item of the list. */
    public T getFirst() {
        return sentinel.next.item;
    }

    public static void main(String[] args) {
        SLList<Integer> lst = new SLList();
        lst.addLast(20);

        System.out.println(lst.getFirst());
        System.out.println(lst.size());
    }
}
