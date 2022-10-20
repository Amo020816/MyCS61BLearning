public class SLList {
    private static class IntNode {
    int item;
    IntNode next;

    public IntNode( int itm, IntNode n) {
        item = itm;
        next = n;
    }
}

    /* Invariant: The first item (if it exists) is at sentinel.next. */
    private IntNode sentinel;
    private int size;

    /** Creates an empty SLList. */
    public SLList(){
        sentinel = new IntNode(0, null);
        size = 0;
    }

    public SLList(int itm) {
        sentinel = new IntNode(0, null);
        sentinel.next = new IntNode(itm, null);
        size = 1;
    }

    /** Add an item to the front of the list. */
    public void addFirst( int itm) {
        sentinel.next = new IntNode(itm, sentinel.next);
        size++;
    }

    /** Add an item to the end of the list iteratively. */
    public void addLast( int itm) {
        size++;

        IntNode p = sentinel;
        /* Move p until it reaches the end of the list. */
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(itm, null);
    }

    /** Get the number of items in the list immediately. */
    public int size() {
        return size;
    }
    /** Return the first item of the list. */
    public int getFirst() {
        return sentinel.next.item;
    }

    public static void main(String[] args) {
        SLList lst = new SLList();
        lst.addLast(20);

        System.out.println(lst.getFirst());
        System.out.println(lst.size());
    }
}
