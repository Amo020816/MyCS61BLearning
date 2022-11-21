package edu.amo.DisjointSet;

import java.util.Arrays;

public class WeightedQuickUnion implements DisjointSet{

    // store the parent of current index.
    int []parent;

    public WeightedQuickUnion() {
        parent = new int[107];
        Arrays.fill(parent, -1);
    }

    @Override
    public void connect(int obj1, int obj2) {
        int root1 = getRoot(obj1), root2 = getRoot(obj2);
        if (parent[root1] < parent[root2]) {
            // the weight of root1 is greater than root2
            parent[root1] += parent[root2]; // update the weight.
            parent[root2] = root1;
        } else {
            // the weight of root2 is greater than root1
            parent[root2] += parent[root1]; // update the weight.
            parent[root1] = root2;
        }
    }

    @Override
    public boolean isConnect(int obj1, int obj2) {
        return getRoot(obj1) == getRoot(obj2);
    }


    /** Returns the root index of current obj. */
    /*
    private int getRoot(int obj) {
        int root = obj;
        while (parent[root] >= 0) {
            root = parent[root];
        }
        return root;
    }
     */

    private int getRoot(int obj) {
        // getRoot with path compression.

        int root = obj;
        while (parent[root] >= 0) {
            root = parent[root];
        }

        int itr = obj;
        while (parent[itr] >= 0) {
            int next = parent[itr];
            parent[itr] = root;
            itr = next;
        }

        return root;
    }
}
