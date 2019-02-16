package org.sz.removedublicate;

import org.sz.removedublicate.interfaces.IDuplicateRemover;

import java.util.LinkedHashSet;
import java.util.Set;

public class CollectionDuplicateRemover implements IDuplicateRemover {

    public int[] removeDuplicates(int[] a) {
        if (a == null || a.length == 0 || a.length == 1) return a;
        Set<Integer> set = new LinkedHashSet<>();
        for (int i : a) {
            set.add(i);
        }
        int[] ints = new int[set.size()];
        int i = 0;
        for (Integer value : set) {
            ints[i++] = value;
        }
        return ints;
    }
}