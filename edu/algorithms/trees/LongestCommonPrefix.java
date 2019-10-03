package edu.algorithms.trees;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LongestCommonPrefix {

    // Function to find Longest Common Prefix
    public static String findLCP(List<String> dict) {
        // insert all keys into trie
        TrieNode head = new TrieNode();
        for (String s: dict) {
            head.insert(s);
        }

        // traverse the trie and find Longest Common Prefix
        StringBuilder lcp = new StringBuilder();
        TrieNode curr = head;

        // do till we find a leaf node or node has more than 1 children
        while (curr != null && !curr.isLeaf && (curr.children.size() == 1))
        {
            // get iterator to only child
            Iterator<Map.Entry<Character, TrieNode>> it =
                curr.children.entrySet().iterator();

            if (it.hasNext())
            {
                Map.Entry<Character, TrieNode> entry = it.next();
                // append current char to LCP
                lcp.append(entry.getKey());

                // update curr pointer to child node
                curr = entry.getValue();
            }

        }

        return lcp.toString();
    }

    public static void main (String[] args)
    {
        // given set of keys
        List<String> dict = Arrays.asList(
            "code", "coder", "coding"
        );

        System.out.println("Longest Common Prefix is " + findLCP(dict));
    }
}
