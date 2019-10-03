package edu.algorithms.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Find the contiguous subarray within an array, A of length N which has the largest sum.
 *
 * Input Format:
 *
 * The first and the only argument contains an integer array, A.
 * Output Format:
 *
 * Return an integer representing the maximum possible sum of the contiguous subarray.
 * Constraints:
 *
 * 1 <= N <= 1e6
 * -1000 <= A[i] <= 1000
 * For example:
 *
 * Input 1:
 *     A = [1, 2, 3, 4, -10]
 *
 * Output 1:
 *     10
 *
 * Explanation 1:
 *     The subarray [1, 2, 3, 4] has the maximum possible sum of 10.
 *
 * Input 2:
 *     A = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
 *
 * Output 2:
 *     6
 *
 * Explanation 2:
 *     The subarray [4,-1,2,1] has the maximum possible sum of 6.
 */
public class MaxSumContiguousSubarray {

    public static void main(String[] args) {
        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Max Sum Contiguous Subarray is: " + new MaxSumContiguousSubarray().maxSubArray(array));
    }

    public int maxSubArray(final int[] A) {
        if(A.length == 0) {
            return 0;
        }

        List<Integer> subArraySum = new ArrayList<Integer>();

        for (int i = 0; i < A.length; i++) {
            int sum = A[i];
            for (int j = i + 1; j < A.length; j++) {
                if (sum + A[j] > sum) {
                    sum = sum + A[j];
                } else {
                    break;
                }
            }
            subArraySum.add(sum);
        }
        return getMaxElem(subArraySum);
    }

    public int getMaxElem(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return -1;
        }

        int max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (max < list.get(i)) {
                max = list.get(i);
            }
        }
        return max;
    }
}
