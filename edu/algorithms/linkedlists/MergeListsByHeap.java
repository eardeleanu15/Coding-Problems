package edu.algorithms.linkedlists;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * [[1, 3, 7],
 *  [2, 6, 9],
 *  [4, 5, 8]]
 *
 * =>
 *  [1, 2, 3, 4, 5, …, 9]
 */
public class MergeListsByHeap {

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        first.add(3);
        first.add(7);

        List<Integer> second = new ArrayList<>();
        second.add(2);
        second.add(6);
        second.add(9);

        List<Integer> third = new ArrayList<>();
        third.add(4);
        third.add(5);
        third.add(8);


        lists.add(first);
        lists.add(second);
        lists.add(third);

        List<Integer> merged = new MergeListsByHeap().merge(lists);
    }

    public List<Integer> merge(List<List<Integer>> subLists) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (List<Integer> list : subLists) {
            for (Integer i : list) {
                minHeap.add(i);
            }
        }

        List<Integer> mergedList = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            mergedList.add(minHeap.poll());
        }

        return mergedList;
    }
}
