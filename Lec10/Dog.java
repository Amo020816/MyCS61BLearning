import java.util.Comparator;

public class Dog implements Comparable<Dog>{
    private String name;
    private int size;

    public Dog(String n, int s) {
        name = n;
        size = s;
    }

    public void bark() {
        System.out.println(name + " says: bark");
    }

    /** Return nagetive number if this dog is less than the dog pointed at by rhs, and so forth. */
    public int compareTo(Dog rhs) {
        // Warning: Casting may cause run-time error
        // Dog rhs_dog = (Dog) rhs;

        return this.size - rhs.size;
    }

    private static class NameComparator implements Comparator<Dog> {
        public int compare(Dog a, Dog b) {
            return a.name.compareTo(b.name);
        }
    }

    public static Comparator<Dog> getNameComparator() {
        return new NameComparator();
    }
}
