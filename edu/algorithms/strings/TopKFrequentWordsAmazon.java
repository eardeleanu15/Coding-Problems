package edu.algorithms.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given a list of reviews, a list of keywords and an integer k. Find the most popular k keywords in order of most to least frequently mentioned.
 *
 * The comparison of strings is case-insensitive.
 * Multiple occurances of a keyword in a review should be considred as a single mention.
 * If keywords are mentioned an equal number of times in reviews, sort alphabetically.
 *
 * Example:
 *
 * Input:
 * k = 2
 * keywords = ["anacell", "cetracular", "betacellular"]
 * reviews = [
 *   "Anacell provides the best services in the city",
 *   "betacellular has awesome services",
 *   "Best services provided by anacell, everyone should use anacell",
 * ]
 *
 * Output:
 * ["anacell", "betacellular"]
 *
 * Explanation:
 * "anacell" is occuring in 2 different reviews and "betacellular" is only occuring in 1 review.
 */
public class TopKFrequentWordsAmazon {

    public static void main(String[] args) {
        
    }

    private static List<String> solve(int k, String[] keywords, String[] reviews) {
        Map<String, Integer> frequencies = new HashMap<>();
        for (String keyword : keywords) {
            for (String review : reviews) {
                if(review.toLowerCase().contains(keyword.toLowerCase())) {
                    if (frequencies.containsKey(keyword)) {
                        frequencies.put(keyword, frequencies.get(keyword) + 1);
                    } else {
                        frequencies.put(keyword, 1);
                    }
                }
            }
        }

        Queue<Map.Entry<String, Integer>> topFrequencies =
            new PriorityQueue<>((a,b) -> a.getValue().equals(b.getValue()) ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
        List<String> topWords = new ArrayList<>();
        while(!topFrequencies.isEmpty() && k-- > 0) {
            topWords.add(topFrequencies.poll().getKey());
        }
        return topWords;
    }
}
