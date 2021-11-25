package sortalgorithm.merge;

import sortalgorithm.somehelpfulmethods.SomeHelpfulSortingMethod;

/**
 * Merge Sort (Merge Sort) is an effective and stable sorting algorithm based on
 * the merge operation., in this class I encapsulation a method
 * {@link MergeSort#sortArray(int[])} to sort Array containing integers.
 */
public class MergeSort {

    /**
     * sort the array with merge algorithm
     *
     * <p>Principle:</p>
     * <ul>
     *     <li>
     *         Using recursion {@link MergeSort#sortSubArray(int[], int, int)}to make
     *         each sub-array in order, and combining these sub-arrays in order.
     *     </li>
     *     <li>
     *         Using some while loops to update corresponding sub-array.
     *     </li>
     * </ul>
     * <p>Attribute:</p>
     * <ul>
     *     <li>Stable, since elements are compared in terms of pairs.</li>
     *     <li>Time Complexity: O(N*log2(N))</li>
     *     <li>Worst Time Complexity: O(N*log2(N))</li>
     *     <li>Best Time Complexity: O(N*log2(N))</li>
     *     <li>Space Complexity: O(N)</li>
     * </ul>
     *
     * @param array an array to be sorted
     */
    public static void sortArray(int[] array) {
        sortSubArray(array, 0, array.length - 1);
    }


    /**
     * a recursion to merge the array
     *
     * @param array an array to merged
     * @param left the start index of the array
     * @param end the end index of the array
     */
    public static void sortSubArray(int[] array, int left, int end) {
        if (left == end) {
            return;
        }

        int mid = left + (end - left) / 2;

        // sort the left sub-array
        sortSubArray(array, left, mid);
        // sort the right sub-array
        sortSubArray(array, mid + 1, end);

        // sort ordered left and right sub-array into a whole array
        merge(array, left, mid + 1, end);
    }


    /**
     * merge sub-array with given information
     *
     * <p>Requires:</p>
     * <p>array != null and left Pointer and right Pointer are the indexes in the range of array,
     * left Pointer is less or equal to right Pointer</p>
     * <p>Ensure</p>
     * <p>the element from leftPointer to rightBoundary was sorted</p>
     *
     * @param array an array to merged
     * @param leftPointer start position of left subArray to sort
     * @param rightPointer start position of right subArray to sort
     * @param endPointer end position of right sybArray
     */
    public static void merge(int[] array, int leftPointer, int rightPointer, int endPointer) {
        int[] result = new int[endPointer - leftPointer + 1];
        int i = leftPointer;
        int j = rightPointer;
        int k = 0;

        while (i < rightPointer && j <= endPointer) {
            if (array[i] < array[j]) {
                result[k++] = array[i++];
            } else {
                result[k++] = array[j++];
            }
        }

        while (i < rightPointer) {
            result[k++] = array[i++];
        }

        while (j <= endPointer) {
            result[k++] = array[j++];
        }

        // past result on the corresponding position of array.
        SomeHelpfulSortingMethod.pastSubArray(array, leftPointer, endPointer, result);
    }
}