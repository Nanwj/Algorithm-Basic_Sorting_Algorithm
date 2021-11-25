package sortalgorithm.quick;

import sortalgorithm.somehelpfulmethods.SomeHelpfulSortingMethod;

/**
 * Quick sort algorithm is a simple algorithm in computer science, in this class I encapsulation
 * a method {@link QuickSort#sortArray(int[])} to sort Array containing integers.
 */
public class QuickSort {


    /**
     * sort the array with quick algorithm
     *
     * <p>Principle:</p>
     * <ul>
     *     <li>
     *         Firstly, select first element as a pivot, moves elements less than pivot into left
     *         of pivot, and moves elements grater than pivot into right of pivot.
     *     </li>
     *     <li>
     *         Recursively calling left and right sub-array to sort whole array.
     *     </li>
     * </ul>
     * <p>Attribute:</p>
     * <ul>
     *     <li>Unstable</li>
     *     <li>Time Complexity: O(N*log2(N))</li>
     *     <li>Worst Time Complexity: O(N^2)</li>
     *     <li>Best Time Complexity: O(N*log2(N))</li>
     *     <li>Space Complexity: O(log2(N))</li>
     * </ul>
     *
     * @param array an array to be sorted
     */
    public static void sortArray(int[] array) {
        sortSubArrayDoublePivot(array, 0, array.length - 1);
    }


    /**
     * using quick sort algorithm sort an array with double pivot
     *
     * @param array array to sort
     * @param start start position
     * @param end end position
     * @return sorted array
     */
    public static int[] sortSubArrayDoublePivot(int[] array, int start, int end) {
        int pivot = array[start];
        int left = start;
        int right = end;

        while (left < right) {
            while ((left < right) && array[left] < pivot) {
                left++;
            }
            while ((left < right) && array[right] > pivot) {
                right--;
            }

            // move pivot into middle of sub-array
            if (array[left] == array[right] && (left < right)) {
                left++;
            } else {
                SomeHelpfulSortingMethod.switchElement(array, left, right);
            }
        }

        if (left - 1 > start) {
            array = sortSubArrayDoublePivot(array, start, left - 1);
        }
        if (right + 1 < end) {
            array = sortSubArrayDoublePivot(array, right + 1, end);
        }
        return array;
    }
}
