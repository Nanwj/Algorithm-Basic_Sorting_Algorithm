package sortalgorithm.bubble;

import sortalgorithm.somehelpfulmethods.SomeHelpfulSortingMethod;

/**
 * Bubble sort algorithm is a simple algorithm in computer science, in this class I encapsulation
 * a method {@link BubbleSort#sortArray(int[])} to sort Array containing integers.
 */
public class BubbleSort {

    /**
     * sort the array with bubble algorithm
     *
     * <p>Principle:</p>
     * <ul>
     *     <li>
     *         Repeatedly visit the element in the array and compare with the one next to it, switch them
     *         if the order is incorrect, until the last element.
     *     </li>
     *     <li>
     *         Repeatedly visit the element in the array and compare with the one next to it, switch them
     *         if the order is incorrect, until the second last element.
     *     </li>
     *     <li>
     *         Repeat operation......
     *     </li>
     * </ul>
     * <p>Attribute:</p>
     * <ul>
     *     <li>Stable, since elements are compared one by one.</li>
     *     <li>Time Complexity: O(N^2)</li>
     *     <li>Worst Time Complexity: O(N^2)</li>
     *     <li>Best Time Complexity: O(N) (all elements are already sorted)</li>
     *     <li>Space Complexity: O(1)</li>
     * </ul>
     *
     * @param array an array to be sorted
     */
    public static void sortArray(int[] array) {
        long wapTime = 0;

        // loop the rest of array
        for (int i = array.length; i >= 0; i--) {
            if (bubbleWithLimitLength(array, i, wapTime)) {
                break;
            }
        }
    }

    /**
     * Loop every element from first element to limit element, compare each element with the
     * one next to it, and switch them if left one is larger than right one.
     *
     * @param array an array to be SortAlgorithm.bubble
     * @param limit a position
     * @param switchTime a long represent time of wrap
     * @return true if all of elements are in order, false otherwise.
     */
    public static Boolean bubbleWithLimitLength(int[] array, int limit, long switchTime) {
        for (int i = 0; i < limit - 1; i++) {
            if (array[i] > array[i + 1]) {
                SomeHelpfulSortingMethod.switchElement(array, i, i + 1);
                switchTime++;
            }
        }
        return switchTime == 0;
    }
}
