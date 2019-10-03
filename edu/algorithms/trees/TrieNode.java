package edu.algorithms.trees;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    boolean isLeaf = false;    // set when node is a leaf node
    Map<Character, TrieNode> children = new HashMap<>();

    public void insert(String key) {
        TrieNode curr = this;
        for (int i = 0; i < key.length(); i++) {
            if (curr.children.get(key.charAt(i)) == null) {
                curr.children.put(key.charAt(i), new TrieNode());
            }
            curr = curr.children.get(key.charAt(i));
        }
        curr.isLeaf = true;
    }
}