package edu.algorithms.trees;

import java.util.ArrayList;
import java.util.List;

// A class to represent Trie Tree
public class Trie
{
    // define alphabet size (26 characters for a - z)
    private static final int CHAR_SIZE = 26;

    boolean isLeaf;
    List<Trie> children = null;

    // Constructor
    Trie() {
        isLeaf = false;
        children = new ArrayList<>();

        for (int i = 0; i < CHAR_SIZE; i++)
            children.add(null);
    }

    // Iterative function to insert a string in Trie Data Structure
    public void insert(String key)
    {
        System.out.println("Inserting \"" + key + "\"");

        // start from root node
        Trie curr = this;

        // do for each character of the key
        for (int i = 0; i < key.length(); i++)
        {
            // create a new Trie node if path does not exist
            if (curr.children.get(key.charAt(i) - 'a') == null)
                curr.children.set(key.charAt(i) - 'a', new Trie());

            // go to the next node
            curr = curr.children.get(key.charAt(i) - 'a');
        }

        // mark current node as leaf
        curr.isLeaf = true;
    }

    // Iterative function to search a key in Trie. It returns true
    // if the key is found in the Trie, else it returns false
    public boolean search(String key)
    {
        System.out.print("Searching \"" + key + "\" : ");

        Trie curr = this;

        // do for each character of the key
        for (int i = 0; i < key.length(); i++)
        {
            // go to the next node
            curr = curr.children.get(key.charAt(i) - 'a');

            // if string is invalid (reached end of path in Trie)
            if (curr == null)
                return false;
        }

        // return true if current node is a leaf node and we have reached
        // the end of the string
        return curr.isLeaf;
    }
};

class Main
{
    // Memory efficient implementation of Trie Data Structure in Java
    public static void main (String[] args)
    {
        // construct a new Trie node
        Trie head = new Trie();

        head.insert("techie");
        head.insert("techi");
        head.insert("tech");

        System.out.println(head.search("tech"));			// print true
        System.out.println(head.search("techi"));			// print true
        System.out.println(head.search("techie"));			// print true
        System.out.println(head.search("techiedelight"));	// print false

        head.insert("techiedelight");

        System.out.println(head.search("tech"));			// print true
        System.out.println(head.search("techi"));			// print true
        System.out.println(head.search("techie"));			// print true
        System.out.println(head.search("techiedelight"));	// print true
    }
}
