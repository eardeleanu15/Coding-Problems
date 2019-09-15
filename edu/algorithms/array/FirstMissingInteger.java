package edu.algorithms.array;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 *
 * Example:
 *
 * Given [1,2,0] return 3,
 *
 * [3,4,-1,1] return 2,
 *
 * [-8, -7, -6] returns 1
 */
public class FirstMissingInteger {

    public static void main(String[] args) {
        int arr[] = {-8, 7, -6};
        System.out.println(new FirstMissingInteger().solve(arr));
    }

    public int solve(int[] A) {
        int[] result = new int[A.length];

        for(int i=0; i<result.length; i++){
            result[i] = 0;
        }

        for(int i=0; i < A.length; i++){
            if (A[i] - 1 >= 0 && A[i] - 1 <A.length){
                result[A[i]-1]++;
            }
        }

        for (int i=0; i<result.length; i++){
            if (result[i] == 0){
                return i+1;
            }
        }

        return result.length+1;
    }
}
