public class VengefulSLList<Item> extends SLList<Item>{
    private SLList<Item> deletedItems = new SLList<>();


    @Override
    public Item removeLast() {
        Item oldBack = super.removeLast();
        deletedItems.addLast(oldBack);
        return oldBack;
    }

    /** Prints deleted items */
    public void printLostItem() {
        deletedItems.print();
    }

    public static void main(String[] args) {

        VengefulSLList<Integer> vs1 = new VengefulSLList<>();

        vs1.addLast(5);
        vs1.addLast(6);
        vs1.addLast(10);
        vs1.addLast(13);

        vs1.removeLast();
        vs1.removeLast();

        System.out.print("The fallen items: ");
        vs1.printLostItem();

        System.out.println(vs1.toString());
    }

}
