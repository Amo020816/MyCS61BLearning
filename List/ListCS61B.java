public interface ListCS61B<Item> {

    /** Inserts X into the back of the list. */
    public void addLast(Item x);

    /** Returns the item from the back of the list. */
    public Item getLast();
    /** Gets the ith item in the list (0 is the front). */
    public Item get(int i);

    /** Returns the number of items in the list. */
    public int size();

    /** Deletes item from back of the list and
     * returns deleted item. */
    public Item removeLast();

    /** Prints out the entire List. */
    default public void print() {
        for (int i = 0; i < size(); i++)
            System.out.print(get(i) + " ");
        System.out.println();
    }
}
