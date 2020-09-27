package edu.algorithms.array;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 *
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
 * Example:
 *
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * Output: [1,2,2,3,5,6]
 *
 *
 * Constraints:
 *
 * -10^9 <= nums1[i], nums2[i] <= 10^9
 * nums1.length == m + n
 * nums2.length == n
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {2, 0};
        int[] nums2 = {1};
        merge(nums1, 1, nums2, 1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n != 0) {
            int i = 0;
            int j = 0;
            int pos;
            while (i < m && j < n) {
                if (nums1[i] <= nums2[j]) {
                    i++;
                } else {
                    pos = i;
                    // right shift elements
                    for (int k = nums1.length - 2; k >= pos; k--) {
                        nums1[k + 1] = nums1[k];
                    }
                    nums1[pos] = nums2[j];
                    i++;
                    j++;
                    m++;
                }
            }
            pos = i;
            while (j < n) {
                nums1[pos] = nums2[j];
                pos++;
                j++;
            }
        }
    }
}
