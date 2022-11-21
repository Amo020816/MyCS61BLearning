package edu.amo.DisjointSet;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestDisjointSet {
    @Test
    public void basicTest() {
        DisjointSet disjointSet = new WeightedQuickUnion();

        disjointSet.connect(1, 3);
        disjointSet.connect(4, 5);
        disjointSet.connect(3, 9);
        disjointSet.connect(2, 4);

        assertTrue(disjointSet.isConnect(2, 5));
        assertTrue(disjointSet.isConnect(1, 9));
        assertFalse(disjointSet.isConnect(0, 1));
    }
}
