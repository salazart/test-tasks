package org.sz.wordcounter;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WordCounterTest {
    @Test
    public void testCountWords() {
        assertThat(WordCounter.countWords("Hello"), is(1));
        assertThat(WordCounter.countWords("Hello! How are you? I am fine"), is(7));
        assertThat(WordCounter.countWords("  Hello!  How    are  you? I am  fine"), is(7));
        assertThat(WordCounter.countWords(" Hello!    How are you?   I am fine "), is(7));
    }
}