package sortalgorithm.shell;

import sortalgorithm.somehelpfulmethods.SomeHelpfulSortingMethod;

/**
 * Shell sort algorithm is an improved algorithm of insertion sort, in this class I encapsulation
 * a method {@link ShellSort#sortArray(int[])} to sort Array containing integers.
 */
public class ShellSort {


    /**
     * sort the array with shell algorithm
     *
     * <p>Principle:</p>
     * <ul>
     *     <li>
     *         calculate the stride with Knuth sequence(h = 3*h + 1, h start with 1),
     *         sort a sub-array contains the first element,
     *         fifth element, (1 + stride)th element.... with (1 + 2*stride)th algorithm.
     *     </li>
     *     <li>
     *         sort a sub-array contains the second element, (2 + stride)th element,
     *         (2 + 2*stride)th element... with insertion algorithm.
     *     </li>
     *     <li>
     *         Repeat operation...... then try with stride of (previous-stride - 1) / 3,
     *         until stride is 1.
     *     </li>
     * </ul>
     * <p>Attribute:</p>
     * <ul>
     *     <li>Unstable, since element might jump</li>
     *     <li>Time Complexity: O(N^(7/6))</li>
     *     <li>Worst Time Complexity: O(N^2)</li>
     *     <li>Best Time Complexity: O(N) (all elements are already sorted)</li>
     *     <li>Space Complexity: O(1)</li>
     * </ul>
     *
     * @param array an array to be sorted
     */
    public static void sortArray(int[] array) {
        int knuth = 1;
        while (knuth <= array.length / 3) {
            knuth = knuth * 3 + 1;
        }

        for (int gap = knuth; gap > 0; gap = (gap - 1) / 3) {
            sortArrayWithGap(array, gap);
        }
    }

    /**
     * sort sub-array with given gap
     *
     * @param array array to sort element
     * @param gap a stride to improve efficient of algorithm
     */
    public static void sortArrayWithGap(int[] array, int gap) {
        for (int i = gap; i < array.length; i++) {
            for (int j = i; j > gap - 1; j -=  gap) {
                if (array[j] < array[j - gap]) {
                    SomeHelpfulSortingMethod.switchElement(array, j, j - gap);
                }
            }
        }
    }





//
//    /**
//     * another sort method using my own opinion
//     * @param array array to be sorted
//     */
//    public static void mySortArray(int[] array) {
//        int gap = (int) Math.ceil(Math.sqrt(array.length));
//        while (gap >= 1) {
//            sortUnderGivenGap(array, gap);
//            gap /= 2;
//        }
//    }
//
//
//    /**
//     * a method sorted by myself.
//     * @param array array to be sorted
//     * @param gap the stride to loop
//     */
//    public static void sortUnderGivenGap(int[] array, int gap) {
//        int start = 0;
//        while (start < gap) {
//            overwriteSortedSubArray(array, start, gap,
//                    getSortedSubArray(array, start, gap));
//            start++;
//        }
//    }
//
//    /**
//     * a method to get the sub array of given array with start position and gap
//     *
//     * @requires array != null && 0 <= start <= array.length && 0 < gap < array.length
//     * @ensure \result result[0] = array[start] && result[i] = array[start + gap]
//     *          && result[2] = array[start + gap * 2] ...
//     * @param array an array to get sub array
//     * @param start start position
//     * @param gap gap between element
//     * @return a sub array of given array
//     */
//    public static int[] getSortedSubArray(int[] array, int start, int gap) {
//        List<Integer> newList = new ArrayList<>();
//        for (int i = start; i < array.length; i += gap) {
//            newList.add(array[i]);
//        }
//
//        int[] result = new int[newList.size()];
//        for (int i = 0; i < newList.size(); i++) {
//            result[i] = newList.get(i);
//        }
//
//        InsertionSort.sortArray(result);
//        return result;
//    }
//
//    /**
//     * over write the array with sorted sub array
//     *
//     * @requires array != null && subArray != null && 0 <= start <= array.length
//     * && 0 < gap < array.length
//     * @ensure \result array[start] = subArray[0] && array[start + gap] = subArray[1]
//     * && array[start + gap * 2] = subArray[2] ...
//     *
//     * @param array an array to overwrite
//     * @param start a position to start over write
//     * @param gap the gap between element to be over write
//     * @param subArray a sorted to be used to over write
//     */
//    public static void overwriteSortedSubArray(int[] array,
//                                               int start,
//                                               int gap,
//                                               int[] subArray) {
//        int index = 0;
//        for (int i = start; i < array.length; i += gap) {
//            array[i] = subArray[index];
//            index++;
//        }
//    }
}
