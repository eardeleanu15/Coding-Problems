package edu.algorithms.amz;

/**
 * Given two version numbers, version1 and version2, compare them.
 *
 * Version numbers consist of one or more revisions joined by a dot '.'.
 * Each revision consists of digits and may contain leading zeros. Every revision contains at least one character.
 * Revisions are 0-indexed from left to right, with the leftmost revision being revision 0, the next revision being revision 1, and so on.
 * For example 2.5.33 and 0.1 are valid version numbers.
 *
 * To compare version numbers, compare their revisions in left-to-right order.
 * Revisions are compared using their integer value ignoring any leading zeros. This means that revisions 1 and 001 are considered equal.
 * If a version number does not specify a revision at an index, then treat the revision as 0.
 * For example, version 1.0 is less than version 1.1 because their revision 0s are the same, but their revision 1s are 0 and 1 respectively, and 0 < 1.
 *
 * Return the following:
 *
 * If version1 < version2, return -1.
 * If version1 > version2, return 1.
 * Otherwise, return 0.
 *
 *
 * Example 1:
 *
 * Input: version1 = "1.01", version2 = "1.001"
 * Output: 0
 * Explanation: Ignoring leading zeroes, both "01" and "001" represent the same integer "1".
 */
public class CompareVersionNumbers {

    public static void main(String[] args) {
        System.out.println("Compare result for versions '1.01' and '1.001': " + compareVersion("1.01", "1.001"));
    }

    public static int compareVersion(String version1, String version2) {
        String[] version1Revisions = version1.split("\\.");
        String[] version2Revisions = version2.split("\\.");
        int result = 0 ;

        for (int i = 0; i < Math.min(version1Revisions.length, version2Revisions.length); i++) {
            int vers1Rev = Integer.parseInt(version1Revisions[i]);
            int vers2Rev = Integer.parseInt(version2Revisions[i]);
            if (vers1Rev < vers2Rev) {
                return -1;
            } else if (vers1Rev > vers2Rev) {
                return 1;
            }
        }

        // versions have common prefix
        if (version1Revisions.length > version2Revisions.length) {
            for (int i = Math.min(version1Revisions.length, version2Revisions.length); i < version1Revisions.length; i++) {
                int vers1Rev = Integer.parseInt(version1Revisions[i]);
                if (vers1Rev != 0) {
                    return 1;
                }
            }
        } else if (version2Revisions.length > version1Revisions.length) {
            for (int i = Math.min(version1Revisions.length, version2Revisions.length); i < version2Revisions.length; i++) {
                int vers2Rev = Integer.parseInt(version2Revisions[i]);
                if (vers2Rev != 0) {
                    return -1;
                }
            }
        }
        return result;
    }
}
