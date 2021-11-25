package sortalgorithm.insertion;

import sortalgorithm.somehelpfulmethods.SomeHelpfulSortingMethod;

/**
 * Insertion sort algorithm is a simple and intuitive algorithm, in this class I encapsulation
 * a method {@link InsertionSort#sortArray(int[])} to sort Array containing integers.
 */
public class InsertionSort {

    /**
     * sort an array with insertion algorithm
     *
     * <p>Principle:</p>
     * <ul>
     *     <li>
     *         start from the second element insert it into correct position within sub-array
     *         contains first two elements
     *     </li>
     *     <li>
     *         get the third element and insert it into correct position within sub-array
     *         contains first three elements
     *     </li>
     *     <li>
     *         Repeat operation......
     *     </li>
     * </ul>
     * <p>Attribute:</p>
     * <ul>
     *     <li>Stable, relative position of elements with same value would not change</li>
     *     <li>Time Complexity: O(N^2)</li>
     *     <li>Worst Time Complexity: O(N^2)</li>
     *     <li>Best Time Complexity: O(N)</li>
     *     <li>Space Complexity: O(1)</li>
     * </ul>
     *
     * @param array an array to sorted
     */
    public static void sortArray(int[] array) {
        for (int i = 1; i < array.length; i++) {
            checkCard(array, i);
        }
    }

    /**
     * Try to insert element of given position into correct position.
     *
     * @param array an array to sorted
     * @param index the position that the element will be move to correct position
     */
    public static void checkCard(int[] array, int index) {
        // an element might be inserted into forward position
        int elementInserted = array[index];

        // the element would be inserted into the first one
        if (elementInserted < array[0]) {
            SomeHelpfulSortingMethod.insertElement(array, index, 0);
            return;
        }

        /*
         find the element less than or equal to the inserted value
         and insert the element at the index position behind it
        */
        for (int i = index - 1; i >= 0; i--) {
            if (elementInserted >= array[i]) {
                SomeHelpfulSortingMethod.insertElement(array, index, i + 1);
                break;
            }
        }
    }
}
