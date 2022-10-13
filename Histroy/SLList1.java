public class SLList {
    private static class IntNode {
    int item;
    IntNode next;

    public IntNode( int itm, IntNode n) {
        item = itm;
        next = n;
    }
}

    private IntNode first;

    public SLList(){
        first = null;
    }

    public SLList(int itm) {
        first = new IntNode(itm, null);
    }

    /** Add an item to the front of the list. **/
    public void addFirst( int itm) {
        first = new IntNode(itm, first);
    }

    /** Add an item to the end of the list iteratively. **/
    public void addLast( int itm) {
        IntNode p = first;

        /* Move p until it reaches the end of the list. */
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(itm, null);
    }


    /** Return the size of the list starts at IntNode p.**/
    private static int size(IntNode p) {
        if (p.next == null)
            return 1;
        return size(p.next) + 1;
    }

    /** Get the number of items in the list recursively. **/
    // Create a private static helper method to accomplish.
    public int size() {
        return size(first);
    }
    /** Return the first item of the list. **/
    public int getFirst() {
        return first.item;
    }

    public static void main(String[] args) {
        SLList lst = new SLList();
        lst.addFirst(10);
        lst.addFirst(5);
        lst.addFirst(4);
        lst.addLast(20);

        System.out.println(lst.getFirst());
        System.out.println(lst.size());
    }
}
