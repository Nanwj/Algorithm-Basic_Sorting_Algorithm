package sortalgorithm.count;

import sortalgorithm.somehelpfulmethods.SomeHelpfulSortingMethod;

/**
 * Count sort algorithm is a stable algorithm, usually used to sort array contains many numbers and
 * range of numbers is largely less than its quantity. a method {@link CountSort#sortArray(int[])}
 * to sort Array containing integers.
 */
public class CountSort {

    /**
     * sort the array with count algorithm
     *
     * <p>Principle:</p>
     * <ul>
     *     <li>
     *         Create an another array, the elements in this array represents the number of
     *         its index in original array.
     *     </li>
     *     <li>
     *         Updating original array with previous new array.
     *     </li>
     * </ul>
     * <p>Attribute:</p>
     * <ul>
     *     <li>Stable</li>
     *     <li>Time Complexity: O(N + K)</li>
     *     <li>Worst Time Complexity: O(N + K)</li>
     *     <li>Best Time Complexity: O(N + K)</li>
     *     <li>Space Complexity: O(N + K)</li>
     * </ul>
     *
     * @param array an array to be sorted
     * @return a sorted array
     */
    public static int[] sortArray(int[] array) {
        int maxNumber = SomeHelpfulSortingMethod.getMaxNumberInArray(array);
        int[] result = new int[array.length];
        int[] count = new int[maxNumber + 1];

        for (int i : array) {
            count[i]++;
        }

        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                result[index++] = i;
                count[i]--;
            }
        }

        return result;
    }
}
