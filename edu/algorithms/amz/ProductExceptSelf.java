package edu.algorithms.amz;

/**
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 *
 * Example:
 *
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.
 *
 * Note: Please solve it without division and in O(n).
 */
public class ProductExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] productExceptSelf = productExceptSelf(nums);

        for (Integer i : productExceptSelf) {
            System.out.print(i + " ");
        }
    }

    /**
     * Initialize two empty arrays, L and R where for a given index i, L[i] would contain the product of all the numbers to the left of i and R[i]
     * would contain the product of all the numbers to the right of i.
     * We would need two different loops to fill in values for the two arrays.
     *
     * For the array L, L[0]L[0] would be 1 since there are no elements to the left of the first element.
     * For the rest of the elements, we simply use L[i] = L[i - 1] * nums[i - 1]L[i]=L[i−1]∗nums[i−1].
     * Remember that L[i] represents product of all the elements to the left of element at index i.
     *
     * For the other array, we do the same thing but in reverse i.e. we start with the initial value of 1 in R[length - 1]R[length−1] where length
     * is the number of elements in the array, and keep updating R[i] in reverse.
     * Essentially, R[i] = R[i + 1] * nums[i + 1]R[i]=R[i+1]∗nums[i+1].
     * Remember that R[i] represents product of all the elements to the right of element at index i.
     *
     * Once we have the two arrays set up properly, we simply iterate over the input array one element at a time, and for each element at index i,
     * we find the product except self as L[i] * R[i]L[i]∗R[i].
     */
    public static int[] productExceptSelf(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums;
        }
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        // initialize left array
        // no element to the left of the first element
        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i-1] * nums[i-1];
        }

        // initialize right array
        // no element to the right of the last element
        right[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i+1] * nums[i+1];
        }
        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            output[i] = left[i] * right[i];
        }
        return output;
    }
}
