package edu.algorithms.amz;

import java.util.AbstractMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 *
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 *
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 *
 *
 *
 * Example 1:
 *
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 */
public class KClosestPointToOrigin {

    public static void main(String[] args) {
        int[][] points = new int[2][];
        points[0] = new int[] {1,3};
        points[1] = new int[] {-2,2};

        int[][] kClosestPoints = kClosest(points, 1);
        System.out.println("First Closest Point is: " + kClosestPoints[0][0] + ", " + kClosestPoints[0][1]);
    }

    public static int[][] kClosest(int[][] points, int k) {
        Queue<Map.Entry<Integer, Double>> minHeap = new PriorityQueue<>((a,b) -> a.getValue().compareTo(b.getValue()));
        for(int i = 0; i < points.length; i++) {
            int[] point = points[i];
            double euclidianDistance = calculateEuclideanDistance(point);
            minHeap.offer(new AbstractMap.SimpleEntry<>(i, euclidianDistance));
        }
        int[][] kClosest = new int[k][];
        int pos = 0;
        while (k-- > 0) {
            kClosest[pos++] = points[minHeap.poll().getKey()];
        }
        return kClosest;
    }

    public static double calculateEuclideanDistance(int[] point) {
        return Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
    }
}
