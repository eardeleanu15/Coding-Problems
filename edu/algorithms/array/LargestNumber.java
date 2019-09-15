package edu.algorithms.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * For example:
 *
 * Given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 *
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber {

    public static void main(String[] args) {
        List<Integer> num = new ArrayList<>();
        num.add(3);
        num.add(30);
        num.add(34);
        num.add(5);
        num.add(9);
        System.out.println(new LargestNumber().largestNumber(num));
    }

    public String largestNumber(final List<Integer> A) {
        // test if list contains only zeros
        boolean onlyZeroList = true;
        for (Integer i : A) {
            if (i != 0) {
                onlyZeroList = false;
                break;
            }
        }
        if (onlyZeroList) {
            return String.valueOf(0);
        }

        // Sort list
        /**
         * Given two numbers X and Y, how should myCompare() decide which number to put first
         * – we compare two numbers XY (Y appended at the end of X) and YX (X appended at the end of Y).
         *
         * If XY is larger, then, in the output, X should come before Y, else Y should come before X.
         *
         * For example, let X and Y be 542 and 60. To compare X and Y, we compare 54260 and 60542.
         * Since 60542 is greater than 54260, we put Y first.
         */
        Collections.sort(A, (x, y) -> {
            String xy = x + String.valueOf(y);
            String yx = y + String.valueOf(x);
            long xyNum = Long.parseLong(xy);
            long yxNum = Long.parseLong(yx);
            if (xyNum == yxNum) {
                return 0;
            } else if (xyNum > yxNum) {
                return 1;
            } else {
                return -1;
            }
        });
        StringBuilder result = new StringBuilder();
        for (int i = A.size() - 1; i>=0; i--) {
            result.append(A.get(i));
        }
        return result.toString();
    }

}
