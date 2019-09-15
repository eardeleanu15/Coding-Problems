package edu.algorithms.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * For example:
 *
 * Given [1,3],[2,6],[8,10],[15,18],
 *
 * return [1,6],[8,10],[15,18].
 *
 * Make sure the returned intervals are sorted.
 */
public class MergeOverlappingIntervals {


    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(15, 18));
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        List<Interval> mergedIntervals = merge(intervals);
        for (Interval interval: mergedIntervals) {
            System.out.println("[" + interval.start + ", " + interval.end + "]");
        }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals == null) return null;

        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        ArrayList<Interval> merged = new ArrayList<>();

        for (Interval current : intervals) {
            if (merged.isEmpty() || merged.get(merged.size() -1).end < current.start) {
                merged.add(current);
            } else {
                merged.get(merged.size() -1).end = Math.max(current.end,
                    merged.get(merged.size() -1).end);
            }
        }
        return merged;
    }

}


class Interval {
      int start;
      int end;
      Interval(int s, int e) { start = s; end = e; }
 }