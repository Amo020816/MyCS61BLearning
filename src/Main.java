public class Main {
    public static void main(String[] args) {
        AList<Integer> alst = new AList<>();
        alst.addLast(10);
        alst.addLast(50);
        DLList<Integer> dllst = new DLList<>();
        dllst.addLast(10);
        dllst.addLast(30);
        dllst.addLast(40);
        dllst.removeLast();

        ListCS61B<Integer> integerListCS61B = new DLList<>();
        integerListCS61B.addLast(8);

        System.out.println(integerListCS61B.get(0));

        SLList<Integer> slList = new SLList<>();
        slList.addLast(50);
        slList.addLast(30);
        slList.addLast(445);
        slList.removeLast();

        slList.print();

    }
}