public class SLList <Item> implements ListCS61B<Item> {
    private class Node {
    Item data;
    Node next;

    public Node( Item itm, Node n) {
        data = itm;
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

    public SLList(Item itm) {
        sentinel = new Node(null);
        sentinel.next = new Node(itm, null);
        size = 1;
    }

    /** A helper method to get the k-th node, -1-th is sentinel */
    private Node getNode(int k) {
        Node p = sentinel;
        for (int i = -1; i < k; i++)
            p = p.next;
        return p;
    }

    /** Add an item to the front of the list. */
    public void addFirst( Item itm) {
        sentinel.next = new Node(itm, sentinel.next);
        size++;
    }

    /** Add an item to the end of the list iteratively. */
    @Override
    public void addLast( Item itm) {
        Node p = getNode(size - 1);

        p.next = new Node(itm, null);
        size++;
    }

    /** Get the number of items in the list immediately. */
    @Override
    public int size() {
        return size;
    }
    /** Return the first item of the list. */
    public Item getFirst() {
        if (size < 1)
            throw new RuntimeException("Can not getFirst from an empty SLList.");
        return sentinel.next.data;
    }


    /** Return the last item of the list. */
    @Override
    public Item getLast() {
        if (size < 1)
            throw new RuntimeException("Can not getLast from an empty SLList.");
        Node itr = getNode(size - 1);
        return itr.data;
    }

    /** Return the k-th item of the List. */
    @Override
    public Item get(int k) {
        if (size < k)
            throw new RuntimeException(k + "-th elements does not exist in the List");
        Node itr = getNode(k);
        return itr.data;
    }

    /** Remove the last item from the list */
    @Override
    public Item removeLast() {
        if (size < 1)
            throw new RuntimeException("Can not removeLast from an empty SLList. ");

        Node prev = getNode(size - 2);

        Item lastItem = prev.next.data;
        prev.next.data = null;
        prev.next = null;
        size--;
        return lastItem;
    }

    /** Prints out the entire SLList */
    @Override
    public void print() {
        for (Node itr = sentinel.next; itr != null; itr = itr.next)
            System.out.print(itr.data + " ");
        System.out.println();
    }
}
