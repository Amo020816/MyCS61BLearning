public class GDLList<T> {
    private class Node {
        public T item;
        public Node prev;
        public Node next;

        public Node(T itm, Node p, Node n) {
            item = itm;
            prev = p;
            next = n;
        }

        public Node(Node p, Node n) {
            prev = p;
            next = n;
        }
    }

    /*
    Invariant:
        The first item (if it exists) is at sentinel.next.
        The last item (if it exists) is at sentinel.prev.
    */
    private Node sentinel;
    private int size;

    /** Create an empty list.*/
    public GDLList() {
        sentinel = new Node(null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public GDLList(T x) {
        sentinel = new Node(null, null);
        sentinel.next = new Node(x, sentinel, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    /** Add an item to the front of the list. */
    public void addFirst(T x) {
        Node new_node = new Node(x, sentinel, sentinel.next);
        sentinel.next.prev = new_node;
        sentinel.next = new_node;
        size++;
    }

    /** Add an item to the last of the list. */
    public void addLast(T x) {
        Node new_node = new Node(x, sentinel.prev, sentinel);
        sentinel.prev.next = new_node;
        sentinel.prev = new_node;
        size++;
    }

    /** Get the number of items. */
    public int size() {
        return size;
    }

    /** Get the first item of the list. */
    public T getFirst() {
        if (size < 1) {
            throw new RuntimeException("The list is an empty list.");
        }
        return sentinel.next.item;
    }

    /** Get the last item of the list. */
    public T getLast() {
        if (size < 1) {
            throw new RuntimeException("The list is an empty list.");
        }
        return sentinel.prev.item;
    }

    public static void main(String[] args) {
        GDLList<Integer> lst = new GDLList<>();
        lst.addFirst(10);
        lst.addLast(50);
        System.out.println(lst.getFirst());
        System.out.println(lst.getLast());
    }
}
