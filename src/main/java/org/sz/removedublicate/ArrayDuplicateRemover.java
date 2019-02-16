package org.sz.removedublicate;

import org.sz.removedublicate.interfaces.IDuplicateRemover;

public class ArrayDuplicateRemover implements IDuplicateRemover {

    @Override
    public int[] removeDuplicates(int[] a) {
        if (a == null || a.length == 0 || a.length == 1) return a;
        int[] b = new int[a.length];
        int bIndex = 0;
        for (int i : a) {
            if (!contains(b, i)) {
                b[bIndex++] = i;
            }
        }
        int[] result = new int[bIndex];
        System.arraycopy(b, 0, result, 0, result.length);
        return result;
    }

    private boolean contains(int[] b, int element) {
        for (int i : b) {
            if (b[i] == element) {
                return true;
            }
        }
        return false;
    }
}