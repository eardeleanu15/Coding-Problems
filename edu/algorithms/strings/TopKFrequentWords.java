package edu.algorithms.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given a non-empty list of words, return the k most frequent elements.
 *
 * Your answer should be sorted by frequency from highest to lowest.
 * If two words have the same frequency, then the word with the lower alphabetical order comes first.
 *
 * Example:
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 *     with the number of occurrence being 4, 3, 2 and 1 respectively.
 */
public class TopKFrequentWords {

    public static void main(String[] args) {
        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is", "baby", "cold"};
        List<String> topK = topKFrequent(words, 4);
    }

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> frequencies = new HashMap<>();
        // O(N)
        for (String word: words) {
            if (frequencies.containsKey(word)) {
                frequencies.put(word, frequencies.get(word) + 1);
            } else {
                frequencies.put(word, 1);
            }
        }
        Queue<Map.Entry<String, Integer>> sortedFrequencies =
            new PriorityQueue<>((a, b) -> a.getValue().equals(b.getValue()) ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
        sortedFrequencies.addAll(frequencies.entrySet());

        List<String> topKFrequent = new ArrayList<>();
        while (!sortedFrequencies.isEmpty() && k-- > 0){
            topKFrequent.add(sortedFrequencies.poll().getKey());
        }
        return topKFrequent;
    }

}
