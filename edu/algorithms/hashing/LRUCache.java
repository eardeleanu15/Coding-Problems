package edu.algorithms.hashing;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Design and implement a data structure for LRU (Least Recently Used) cache. It should support the following operations: get and set.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present.
 * When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.
 * The LRU Cache will be initialized with an integer corresponding to its capacity.
 * Capacity indicates the maximum number of unique keys it can hold at a time.
 *
 * Definition of “least recently used” : An access to an item is defined as a get or a set operation of the item.
 * “Least recently used” item is the one with the oldest access time.
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.set(2, 1);
        lruCache.set(1, 1);
        lruCache.set(2, 3);
        lruCache.set(4, 1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }

    // store keys of cache
    public Deque<Integer> keys;

    // store values of cache
    public Map<Integer, Integer> map;

    public int capacity;

    public LRUCache(int capacity) {
        this.keys = new LinkedList<>();
        this.map = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            // move key to first entry in queue
            keys.removeFirstOccurrence(key);
            keys.addFirst(key);

            return map.get(key);
        }
        return -1;
    }

    public void set(int key, int value) {
        if (!map.containsKey(key)) {
            // check if we need to evict last element
            if (keys.size() == this.capacity) {
                int last = keys.removeLast();
                map.remove(last);
            }
        } else {
            // remove key from queue because it will be re-added on first position
            keys.removeFirstOccurrence(key);
        }
        keys.addFirst(key);
        map.put(key, value);
    }
}
