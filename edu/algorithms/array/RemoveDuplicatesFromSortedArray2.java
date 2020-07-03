package edu.algorithms.array;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 *
 * Given nums = [1,1,2],
 *
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 *
 * It doesn't matter what you leave beyond the returned length.
 */
public class RemoveDuplicatesFromSortedArray2 {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 2, 2, 3, 4, 6};
        int n = removeDuplicates(nums);
        System.out.println("Array without duplicates: ");
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int removeDuplicates(int[] nums) {
        int duplicates = 0;
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int insertPos = 1;
        int previous = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == previous) {
                duplicates++;
            } else  {
                nums[insertPos++] = nums[i];
                previous = nums[i];
            }
        }
        return nums.length - duplicates;
    }
}
