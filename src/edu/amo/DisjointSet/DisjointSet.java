package edu.amo.DisjointSet;

public interface DisjointSet {
    /** Connect two items. */
    public void connect(int obj1, int obj2);

    /** Check if two items are connected. */
    public boolean isConnect(int obj1, int obj2);
}
