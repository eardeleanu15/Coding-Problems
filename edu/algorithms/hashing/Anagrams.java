package edu.algorithms.hashing;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of strings, return all groups of strings that are anagrams.
 * Represent a group by a list of integers representing the index in the original list.
 * Look at the sample case for clarification.
 *
 * Anagram : a word, phrase, or name formed by rearranging the letters of another, such as 'spar', formed from 'rasp'
 *
 * Example :
 *
 * Input : cat dog god tca
 * Output : [[1, 4], [2, 3]]
 * The indices are 1 based ( the first element has index 1 instead of index 0).
 *
 * Ordering of the result : You should not change the relative ordering of the words / phrases within the group.
 * Within a group containing A[i] and A[j], A[i] comes before A[j] if i < j.
 */
public class Anagrams {

    static final int NO_OF_CHARS = 256;

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("cat");
        strings.add("dog");
        strings.add("god");
        strings.add("tca");

        // Create a count array and initialize all values as 0

        ArrayList<ArrayList<Integer>> anagrams = new Anagrams().anagrams(strings);
    }

    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        ArrayList<ArrayList<Integer>> anagrams = new ArrayList<>();
        ArrayList<Integer> visited = new ArrayList<>();

        if (A == null) {
            return anagrams;
        }

        for (int i=0; i < A.size(); i++) {
            if (visited.contains(i + 1)) {
                continue;
            } else {
                ArrayList<Integer> anagram = new ArrayList<>();
                anagram.add(i + 1);
                visited.add(i + 1);

                for (int j = i + 1; j < A.size(); j++) {
                    if (areAnagram(A.get(i), A.get(j))) {
                        anagram.add(j + 1);
                        visited.add(j + 1);
                    }
                }
                anagrams.add(anagram);
            }

        }

        return anagrams;
    }

    public boolean areAnagram(String s1, String s2) {
        // check length of two strings
        if (s1.length() != s2.length()) {
            return false;
        }

        // Create a count array and initialize all values as 0
        int[] count = new int[NO_OF_CHARS];

        // For each character in input strings, increment count in
        // the corresponding count array
        for (int i=0; i < s1.length(); i++) {
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }

        // See if there is any non-zero value in count array
        for (int i = 0; i < NO_OF_CHARS; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

}
