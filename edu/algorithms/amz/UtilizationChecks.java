package edu.algorithms.amz;

/**
 * A company monitors the average utilization of cloud instances for services every second in order to adopt instances based on demand.
 *
 * If average utilization in the past second is below 25%, it performs the action to half the number of instances running taking the ceiling if the half does not represent an integer.
 * If the number of instances equals one, do nothing.
 *
 * If the avg. utilization is between 25%-60%, do nothing.
 *
 * Finally, if the average utilization is above 60%, perform the action of doubling the number of instances if the number of instances does not exceed 2*10^8.
 *
 * Every time an action is performed, the following 10 seconds are ignored.
 *
 * Example
 *
 * averageUtil: [24, 25, 5, 6, 7, 10, 80, 5, 12, 16, 34, 27, 17, 50]
 * instances: 2
 * The average utilization of the first second is below 25%, no action is performed (averageUtil[0] < 25).
 *
 * The following average utilization is between 25% and 60% (25≤averageUtil[1]≤60), therefore instances are halved: 2/2 = 1.
 *
 * After performing the action, the function does not regard the utilization of the following ten seconds (averageUtil[2] - averageUtil[11]).
 *
 * averageUtil[12] is below 25%, however since instances == 1, it does nothing.
 *
 * The last element of the input list is 25≤averageUtil[13]≤60 and it does nothing.
 *
 * Afterwards, there are no more values to consider and the function returns the current number of instances.
 */
public class UtilizationChecks {

    public static void main(String[] args) {
        int[] averageUtil = {25, 23, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 76, 80};
        int instances = 2;
        System.out.println("Final instances: " + finalInstances(averageUtil, instances));
    }

    public static int finalInstances(int[] averageUtil, int instances) {
        boolean actionPerformed = false;
        int seconds = 0;
        double finalInstances = instances;
        double maxInstances = 2 * Math.pow(10, 8);

        for (int i = 0; i < averageUtil.length; i++) {
            if (actionPerformed) {
                if (++seconds == 10) {
                    actionPerformed = false;
                    seconds = 0;
                }
            } else {
                if (averageUtil[i] < 25 && finalInstances != 1) {
                    finalInstances = Math.ceil(finalInstances / 2);
                    actionPerformed = true;
                } else if (averageUtil[i] > 60 && finalInstances < maxInstances) {
                    finalInstances *= 2;
                    actionPerformed = true;
                }
            }
        }

        return (int) finalInstances;
    }

}
