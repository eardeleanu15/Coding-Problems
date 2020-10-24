package edu.algorithms.amz;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.
 * It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 *
 * Words in the list of banned words are given in lowercase, and free of punctuation.
 * Words in the paragraph are not case sensitive.  The answer is in lowercase.
 *
 * Example:
 *
 * Input:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * Output: "ball"
 * Explanation:
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"),
 * and that "hit" isn't the answer even though it occurs more because it is banned.
 */
public class MostCommonWord {

    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println("Most common word is: " + mostCommonWord(paragraph, banned));
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        String sanitizedParagraph  = paragraph
            .replace("!"," ")
            .replace("?"," ")
            .replace("'"," ")
            .replace(","," ")
            .replace(";"," ")
            .replace("."," ");
        String[] words = sanitizedParagraph.split("\\s+");
        Map<String, Integer> wordFrequencies = new HashMap<>();
        for (String word : words) {
            String lowerCaseWord = word.toLowerCase();
            if (wordFrequencies.containsKey(lowerCaseWord)) {
                wordFrequencies.put(lowerCaseWord, wordFrequencies.get(lowerCaseWord) + 1);
            } else {
                wordFrequencies.put(lowerCaseWord, 1);
            }
        }
        Queue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        maxHeap.addAll(wordFrequencies.entrySet());
        String mostCommonWord = "";
        while (!maxHeap.isEmpty()) {
            String commonWord = maxHeap.poll().getKey();
            if (Arrays.stream(banned).noneMatch(commonWord::equals)) {
                mostCommonWord = commonWord;
                break;
            }
        }
        return mostCommonWord;
    }
}
