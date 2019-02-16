package org.sz.wordcounter;

public class WordCounter {
    public static int countWords(String s) {
        if (s == null || s.isEmpty()) return 0;
        return s.trim().split("\\P{L}+").length;
    }
}