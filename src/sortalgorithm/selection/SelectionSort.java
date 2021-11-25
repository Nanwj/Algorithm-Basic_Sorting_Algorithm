package sortalgorithm.selection;

import sortalgorithm.somehelpfulmethods.SomeHelpfulSortingMethod;

/**
 * Selection sort algorithm is a simple and intuitive algorithm, in this class I encapsulation
 * a method {@link SelectionSort#sortArray(int[])} to sort Array containing integers.
 */
public class SelectionSort {


    /**
     * sort the array with selection algorithm
     *
     * <p>Principle:</p>
     * <ul>
     *     <li>
     *         Select the smallest integer using a loop and then switch it with the element at the
     *         beginning of the sequence.
     *     </li>
     *     <li>
     *         Select the smallest integer in the rest of sequence, then switch it with the element
     *         on second position
     *     </li>
     *     <li>
     *         Repeat operation......
     *     </li>
     * </ul>
     * <p>Attribute:</p>
     * <ul>
     *     <li>Unstable, For example: {(7) 2, 3, [7], 1} sorted to {1, 2, 3, [7], (7)} after
     *     first loop, in which position of 7 changed</li>
     *     <li>Time Complexity: O(N^2)</li>
     *     <li>Worst Time Complexity: O(N^2)</li>
     *     <li>Best Time Complexity: O(N^2)</li>
     *     <li>Space Complexity: O(1)</li>
     * </ul>
     *
     * @param array an array to be sorted
     */
    public static void sortArray(int[] array) {
        // loop the rest of array
        for (int i = 0; i < array.length - 1; i++) {
            int minPosition = i;

            // find the smallest element position in rest of sequence
            for (int j = i + 1; j < array.length; j++) {
                minPosition = array[j] < array[minPosition] ? j : minPosition;
            }

            // switch the position with the ith element in sequence
            SomeHelpfulSortingMethod.switchElement(array, i, minPosition);
        }
    }
}
