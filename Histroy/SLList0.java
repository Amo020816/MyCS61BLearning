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
    private int size;

    /** Creates an empty SLList. **/
    public SLList(){
        first = null;
        size = 0;
    }

    public SLList(int itm) {
        first = new IntNode(itm, null);
        size = 1;
    }

    /** Add an item to the front of the list. **/
    public void addFirst( int itm) {
        first = new IntNode(itm, first);
        size++;
    }

    /** Add an item to the end of the list iteratively. **/
    public void addLast( int itm) {
        size++;

        if (first == null) {
            first = new IntNode(itm, null);
            return;
        }
         
        IntNode p = first;
        /* Move p until it reaches the end of the list. */
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(itm, null);
    }



    /** Get the number of items in the list immediately. **/
    public int size() {
        return size;
    }
    /** Return the first item of the list. **/
    public int getFirst() {
        return first.item;
    }

    public static void main(String[] args) {
        SLList lst = new SLList();
        lst.addLast(20);

        System.out.println(lst.getFirst());
        System.out.println(lst.size());
    }
}
