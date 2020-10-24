package edu.algorithms.amz;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 * Example 1:
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 *
 * Example 2:
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] num1 = {1,2};
        int[] num2 = {3,4};
        System.out.println("Median of the two sorted arrays is: " + findMedianSortedArrays(num1, num2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length;
        int[] merged = new int[size];
        int i = 0;
        int j = 0;
        int pos = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                merged[pos++] = nums1[i++];
            } else {
                merged[pos++] = nums2[j++];
            }
        }

        while (i < nums1.length) {
            merged[pos++] = nums1[i++];
        }
        while (j < nums2.length) {
            merged[pos++] = nums2[j++];
        }
        double median;
        if (size % 2 != 0) {
            median = merged[size / 2];
        } else {
            median = (((double) merged[size / 2]) + merged[(size - 1)/ 2]) / 2;
        }
        return median;
    }
}
