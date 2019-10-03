package edu.algorithms.trees;

import java.util.ArrayList;

public class ShortestUniquePrefix {

    public static void main(String[] args) {
        ArrayList<String> animals = new ArrayList<>();
        animals.add("zebra");
        animals.add("dog");
        animals.add("duck");
        animals.add("dove");

        ArrayList<String> sup = new ShortestUniquePrefix().prefix(animals);
        System.out.println("STOP");
    }

    public ArrayList<String> prefix(ArrayList<String> A) {
        TrieNode head = new TrieNode();
        for (String s : A) {
            head.insert(s);
        }
        ArrayList<String> prefix = new ArrayList<>();
        for (String s : A) {
            TrieNode curr = null;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (curr == null) {
                    curr = head.children.get(s.charAt(i));
                }
                if (curr.children.size() == 1 || curr.children.size() == 0) {
                    // append char at prefix
                    sb.append(s.charAt(i));
                    prefix.add(sb.toString());
                    break;
                } else if (curr.children.size() > 1) {
                    sb.append(s.charAt(i));
                    curr = curr.children.get(s.charAt(i + 1));
                }
            }
        }
        return prefix;
    }
}


