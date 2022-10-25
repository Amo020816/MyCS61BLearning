// import java.lang.reflect.Array;

/** Array based list.
 *  @author Josh Hug
 */

public class AList <Item> {

    private Item []items;
    private int size;

    /** Creates an empty list. */
    public AList() {
        items = (Item[]) new Object[20];
        size = 0;
    }

    /** Resize the underlying array to the target capacity. */
    private void resize(int capacity) {
        Item []new_items =(Item[]) new Object[capacity];
        System.arraycopy(items, 0, new_items, 0, size);
        items = new_items;
    }

    /** Inserts X into the back of the list. */
    public void addLast(Item x) {

        if (items.length  == size) {
            resize(2 * items.length + 1);
        }
        items[size] = x;
        size++;
    }

    /** Returns the item from the back of the list. */
    public Item getLast() {
        if (size == 0)
            return null;
        return items[size - 1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public Item get(int i) {
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
    public Item removeLast() {
        Item x = getLast();
        items[size - 1] = null;
        size--;
        return x;
    }

}
