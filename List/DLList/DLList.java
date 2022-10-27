public class DLList<Item> implements ListCS61B<Item>{
    private class Node {
        public Item data;
        public Node prev;
        public Node next;

        public Node(Item itm, Node p, Node n) {
            data = itm;
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
    public DLList() {
        sentinel = new Node(null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public DLList(Item x) {
        sentinel = new Node(null, null);
        sentinel.next = new Node(x, sentinel, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    /** Add an item to the front of the list. */
    public void addFirst(Item x) {
        Node new_node = new Node(x, sentinel, sentinel.next);
        sentinel.next.prev = new_node;
        sentinel.next = new_node;
        size++;
    }

    /** Add an item to the last of the list. */
    @Override
    public void addLast(Item x) {
        Node new_node = new Node(x, sentinel.prev, sentinel);
        sentinel.prev.next = new_node;
        sentinel.prev = new_node;
        size++;
    }

    /** Get the number of items. */
    @Override
    public int size() {
        return size;
    }

    /** Get the first item of the list. */
    public Item getFirst() {
        if (size < 1) {
            throw new RuntimeException("The list is an empty list.");
        }
        return sentinel.next.data;
    }

    /** Get the last item of the list. */
    @Override
    public Item getLast() {
        if (size < 1) {
            throw new RuntimeException("The list is an empty list.");
        }
        return sentinel.prev.data;
    }

    /** Remove the last item of the list */
    @Override
    public Item removeLast() {
        if (size < 1) {
            throw new RuntimeException("Can not remove an item from an empty list.");
        }
        Item x = getLast();
        Node last_node = sentinel.prev;
        sentinel.prev.data = null;
        last_node.prev.next = sentinel;
        sentinel.prev = last_node.prev;
        size--;
        return x;
    }

    /** Get the i-th item of the list. */
    @Override
    public Item get(int k) {
        Node iterator = get(k, sentinel.next);
        if (iterator == null)
            throw new RuntimeException("invalid access to DLList");
        return iterator.data;
    }

    /** A helper method of get */
    private Node get(int k, Node itr) {
        if (itr == null) {
            return null;
        }
        if (k == 0)
            return itr;
        else
            return get(k - 1, itr.next);
    }

    /** Prints out the entire DLList. */
    @Override
    public void print() {
        for (Node itr = sentinel.next; itr != sentinel; itr = itr.next) {
          System.out.print(itr.data + " ");
        }
        System.out.println();
    }
}
