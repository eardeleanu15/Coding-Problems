package edu.algorithms.linkedlists;

import java.util.ArrayList;
import java.util.List;

/**
 * [[1, 3, 7],
 *  [2, 6, 9],
 *  [4, 5, 8]]
 *
 * =>
 *  [1, 2, 3, 4, 5, …, 9]
 */
public class MergeLists {

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

        List<Integer> merged = new MergeLists().merge(lists);
    }

    public List<Integer> merge(List<List<Integer>> subLists) {

        while (subLists.size() != 1) {
            subLists = mergeLists(subLists);
        }

        return subLists.get(0);
    }



    public List<List<Integer>> mergeLists(List<List<Integer>> subLists) {

        List<Integer> firstList = subLists.get(0);
        List<Integer> secondList = subLists.get(1);

        List<Integer> merged = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < firstList.size() && j < secondList.size()) {
            if (firstList.get(i) < secondList.get(j)) {
                merged.add(firstList.get(i));
                i++;
            } else {
                merged.add(secondList.get(j));
                j++;
            }
        }

        // we still have elements in the first list
        // iterate until the end of first list
        while (i < firstList.size()) {
            merged.add(firstList.get(i));
            i++;
        }


        // we still have elements in the first list
        // iterate until the end of first list
        while(j < secondList.size()) {
            merged.add(secondList.get(j));
            j++;
        }

        subLists.remove(firstList);
        subLists.remove(secondList);
        subLists.add(0, merged);
        return subLists;
    }


}
