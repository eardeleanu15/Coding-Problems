package edu.algorithms.searching;

/**
 * ou are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which returns whether version is bad.
 * Implement a function to find the first bad version. You should minimize the number of calls to the API.
 *
 * Input: n = 5, bad = 4
 * Output: 4
 * Explanation:
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * Then 4 is the first bad version.
 */
public class FirstBadVersion {

    public static void main(String[] args) {
        System.out.println("First Bad Version is: " + firstBadVersion(8));
    }

    public static int firstBadVersion(int n) {
        int firstBadVersion = 1;
        if (n != 1) {
            int badPos = 0;
            int low = 1;
            int high = n;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (isBadVersion(mid)) {
                    badPos = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            firstBadVersion = badPos;
        }
        return firstBadVersion;
    }

    public static boolean isBadVersion(int n) {
        if (n >= 4) {
            return true;
        }
        return false;
    }
}
