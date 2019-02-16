package org.sz.removedublicate;

import org.junit.Test;
import org.sz.removedublicate.interfaces.IDuplicateRemover;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class DuplicateRemoverTest {

    private IDuplicateRemover duplicateRemover;

    @Test
    public void testCollectionRemoveDuplicates() {
        duplicateRemover = new CollectionDuplicateRemover();
        assertThat(duplicateRemover.removeDuplicates(new int[]{2, 1, 4, 2, 3}), is(new int[]{2, 1, 4, 3}));
        assertThat(duplicateRemover.removeDuplicates(new int[]{1}), is(new int[]{1}));
        assertThat(duplicateRemover.removeDuplicates(new int[0]), is(new int[0]));
        assertThat(duplicateRemover.removeDuplicates(null), is(nullValue()));
    }

    @Test
    public void testArrayRemoveDuplicates() {
        duplicateRemover = new ArrayDuplicateRemover();
        assertThat(duplicateRemover.removeDuplicates(new int[]{2, 1, 4, 2, 3}), is(new int[]{2, 1, 4, 3}));
        assertThat(duplicateRemover.removeDuplicates(new int[]{1}), is(new int[]{1}));
        assertThat(duplicateRemover.removeDuplicates(new int[0]), is(new int[0]));
        assertThat(duplicateRemover.removeDuplicates(null), is(nullValue()));
    }
}