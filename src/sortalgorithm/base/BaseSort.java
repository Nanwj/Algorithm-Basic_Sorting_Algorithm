package sortalgorithm.base;

import sortalgorithm.somehelpfulmethods.SomeHelpfulSortingMethod;

import java.util.Arrays;

/**
 * Base sort algorithm is a non-comparative integer sorting algorithm, in this class
 * I encapsulation a method {@link BaseSort#sortArray(int[])} to sort Array containing integers.
 */
public class BaseSort {

    /**
     * sort the array with base algorithm
     *
     * <p>Principle:</p>
     * <ul>
     *     <li>
     *         sort array with its one digit, then sort with ten digit based on one digit.
     *     </li>
     *     <li>
     *         Repeatedly sorting array until max digit.
     *     </li>
     *     <li>
     *         Repeat operation......
     *     </li>
     * </ul>
     * <p>Attribute:</p>
     * <ul>
     *     <li>Stable</li>
     *     <li>Time Complexity: O(N * K)</li>
     *     <li>Worst Time Complexity: O(N * K)</li>
     *     <li>Best Time Complexity: O(N * K)</li>
     *     <li>Space Complexity: O(N + K)</li>
     * </ul>
     *
     * @param array an array to be sorted
     * @return a sorted array
     */
    public static int[] sortArray(int[] array) {
        int maxDigits = SomeHelpfulSortingMethod.getMaxNumberInArray(array);
        int digits = 0;

        while (maxDigits != 0) {
            maxDigits = maxDigits / 10;
            digits++;
        }

        int[] result = new int[array.length];
        int[] count = new int[10];

        for (int i = 0; i < digits; i++) {
            int division = (int) Math.pow(10, i);

            for (int element : array) {
                int num = (element / division) % 10;
                count[num]++;
            }

            // count with base of number
            for (int j = 1; j < count.length; j++) {
                count[j] = count[j] + count[j - 1];
            }

            // update array with sorted base
            for (int j = array.length - 1; j >= 0; j--) {
                int num = (array[j] / division) % 10;
                result[--count[num]] = array[j];
            }

            // paste sorted array onto original array
            System.arraycopy(result, 0, array, 0, array.length);
            Arrays.fill(count, 0);
        }

        return result;
    }
}
