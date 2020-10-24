package edu.algorithms.amz;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * You have an array of logs.  Each log is a space delimited string of words.
 *
 * For each log, the first word in each log is an alphanumeric identifier.  Then, either:
 *
 * Each word after the identifier will consist only of lowercase letters, or;
 * Each word after the identifier will consist only of digits.
 * We will call these two varieties of logs letter-logs and digit-logs.
 * It is guaranteed that each log has at least one word after its identifier.
 *
 * Reorder the logs so that all of the letter-logs come before any digit-log.
 * The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.
 * The digit-logs should be put in their original order.
 *
 * Return the final order of the logs.
 *
 * Example 1:
 *
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 * Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 */
public class ReorderedLogFiles {

    public static void main(String[] args) {
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        String[] reorderedLogs = reorderLogFiles(logs);
        for (String log : reorderedLogs) {
            System.out.println(log);
        }
    }

    public static String[] reorderLogFiles(String[] logs) {
        int n = logs.length;
        if (n == 0) {
            return new String[] {};
        }
        String[] reorderedLogs = new String[n];
        List<String> digitLogs = new LinkedList<>();
        Queue<String> letterLogs = new PriorityQueue<>(
            (s1,s2) -> {
                String s1WithoutIdentifier = s1.substring(s1.indexOf(" ") + 1);
                String s2WithoutIdentifier = s2.substring(s2.indexOf(" ") + 1);
                return s1WithoutIdentifier.equals(s2WithoutIdentifier) ? s1.compareTo(s2) : s1WithoutIdentifier.compareTo(s2WithoutIdentifier);
            });

        for (String log : logs) {
            String logWithoutIdentifier = log.substring(log.indexOf(" ") + 1);
            if (Character.isDigit(logWithoutIdentifier.charAt(0))) {
                digitLogs.add(log);
            } else {
                letterLogs.offer(log);
            }
        }
        int pos = 0;
        while (!letterLogs.isEmpty()) {
            reorderedLogs[pos++] = letterLogs.poll();
        }
        for(String digitLog : digitLogs) {
            reorderedLogs[pos++] = digitLog;
        }
        return reorderedLogs;
    }

}
