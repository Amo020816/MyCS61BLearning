// import java.lang.reflect.Array;

/** Array based list.
 *  @author Josh Hug
 */

public class AList {

    private int []items;
    private int size;

    /** Creates an empty list. */
    public AList() {
        items = new int[20];
        size = 0;
    }

    /** Resize the underlying array to the target capacity. */
    private void resize(int capacity) {
        int []new_items = new int[capacity];
        System.arraycopy(items, 0, new_items, 0, size);
        items = new_items;
    }

    /** Inserts X into the back of the list. */
    public void addLast(int x) {

        if (items.length  == size) {
            resize(2 * items.length + 1);
        }
        items[size] = x;
        size++;
    }

    /** Returns the item from the back of the list. */
    public int getLast() {
        if (size == 0)
            return 0;
        return items[size - 1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        if (i >= size) {
            throw new RuntimeException("invalid access to AList");
        }

        return items[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public int removeLast() {
        int x = getLast();
        size--;
        return x;
    }

}
