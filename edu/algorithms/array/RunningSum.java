package edu.algorithms.array;

/**
 * Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
 *
 * Return the running sum of nums.
 *
 * Input: nums = [1,2,3,4]
 * Output: [1,3,6,10]
 * Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
 */
public class RunningSum {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        for (Integer i : runningSum(nums)) {
            System.out.print(i + " ");
        }
    }

    public static int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n];
        if (n != 0) {
            // initialize first value
            sum[0] = nums[0];
            for (int i = 1; i < n; i++) {
                sum[i] = sum[i-1] + nums[i];
            }
        }
        return sum;
    }
}
