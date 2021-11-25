package bfprt;

import sortalgorithm.somehelpfulmethods.SomeHelpfulSortingMethod;
import sortalgorithm.merge.MergeSort;

/**
 * the positive of bfprt is that the complexity of algorithm could convergence to O(N)
 * where N is the length of array
 */
public class BFPRTAlgorithm {

    /**
     * find the kth number in list where elements are unordered.
     *
     * <p>
     *     The complexity of this algorithm is O(N)
     * </p>
     *
     * @requires list != null && 1 <= k <= list.length
     * @param list an array to find the kth number
     * @param k the number smallest one in the array
     * @return kth number in the given array
     */
    public static int getKthNumberMethod1(int[] list, int k) {
        // deep copy an array to avoid messing the array
        int[] array = new int[list.length];
        System.arraycopy(list, 0, array, 0, list.length);

        return bfprt(array, 0, array.length - 1, k - 1);
    }


    /**
     * find the kth number in list where elements are unordered.
     *
     * <p>
     *     The complexity of this algorithm is more than O(N)
     * </p>
     *
     * @requires list != null && 1 <= k <= list.length
     * @param list an array to find the kth number
     * @param k the number smallest one in the array
     * @return kth number in the given array
     */
    public static int getKthNumberMethod2(int[] list, int k) {
        // deep copy an array to avoid messing the array
        int[] array = new int[list.length];
        System.arraycopy(list, 0, array, 0, list.length);

        return normalFind(array, 0, array.length - 1, k - 1);
    }

    /**
     * An algorithm to find the kth number in given left from left to right
     *
     * <p>
     *     Progress:
     *     <ul>
     *         <li>Find a specific pivot randomly in the list.</li>
     *         <li>Sort the array with pivot and get the index range of pivot</li>
     *         <li>Check whether the given index is located between this range, if so return pivot.
     *         Otherwise check the other side by recursion</li>
     *     </ul>
     * </p>
     *
     * @requires list != null && 0 <= left <= index <= right < list.length - 1
     * @ensure /result is the kth number in sorted list.
     * @param list an array to find kth number
     * @param left the start index to find kth number
     * @param right the end index to find kth number
     * @param index the kth number
     * @return a number which is kth number in given list
     */
    public static int normalFind(int[] list, int left, int right, int index) {
        // there is only one element between left and right, return it straightly.
        if (left == right) {
            return list[left];
        }

        // find a pivot to reduce (3 * N / 10) dataset in next time of recursion
        int pivot = list[left + (int) (Math.random() * (right - left + 1))];

        // quick sort the list from left to right and get the range of pivot
        int[] rangeOfPivot = rangeOfPivot(list, left, right, pivot);


        if (index >= rangeOfPivot[0] && index <= rangeOfPivot[1]) {
            // the k is located in the range of pivot, return this pivot
            return list[index];
        } else if (index < rangeOfPivot[0]) {
            // the k is less than the index of pivot, find the left side of pivot
            return bfprt(list, left, rangeOfPivot[0] - 1, index);
        } else {
            // the k is greater than index of pivot, find the right side of pivot
            return bfprt(list, rangeOfPivot[1] + 1, right, index);
        }
    }


    /**
     * An algorithm to find the kth number in given left from left to right
     *
     * <p>
     *     Progress:
     *     <ul>
     *         <li>Find a specific pivot by calling public static method
     *         {@link BFPRTAlgorithm#mediumOfMedium(int[], int, int)}</li>
     *         <li>Sort the array with pivot and get the index range of pivot</li>
     *         <li>Check whether the given index is located between this range, if so return pivot.
     *         Otherwise check the other side by recursion</li>
     *     </ul>
     * </p>
     *
     * <p>
     *     By finding pivot in this algorithm, if the k is not in the range of pivot, then
     *     at least (3 * N / 10) dataset could reduce in next time of recursion.
     * </p>
     *
     * @requires list != null && 0 <= left <= index <= right < list.length - 1
     * @ensure /result is the kth number in sorted list.
     * @param list an array to find kth number
     * @param left the start index to find kth number
     * @param right the end index to find kth number
     * @param index the kth number
     * @return a number which is kth number in given list
     */
    public static int bfprt(int[] list, int left, int right, int index) {
        // there is only one element between left and right, return it straightly.
        if (left == right) {
            return list[left];
        }

        // find a pivot to reduce (3 * N / 10) dataset in next time of recursion
        int pivot = mediumOfMedium(list, left, right);

        // quick sort the list from left to right and get the range of pivot
        int[] rangeOfPivot = rangeOfPivot(list, left, right, pivot);


        if (index >= rangeOfPivot[0] && index <= rangeOfPivot[1]) {
            // the k is located in the range of pivot, return this pivot
            return list[index];
        } else if (index < rangeOfPivot[0]) {
            // the k is less than the index of pivot, find the left side of pivot
            return bfprt(list, left, rangeOfPivot[0] - 1, index);
        } else {
            // the k is greater than index of pivot, find the right side of pivot
            return bfprt(list, rangeOfPivot[1] + 1, right, index);
        }
    }


    /**
     * Find the range of numbers located in the list whose value is exactly same as pivot
     *
     * <p>
     *     Loop the elements located between left to right, and sort them with pivot.
     *     For the element less than pivot, put them on the left hand site between left to right,
     *     for the element greater than pivot, put them on the right hand site,
     *     for those equal to pivot, put them at the medium.
     * </p>
     *
     * @requires list != null && pivot != null && 0 <= left < right <= list.length - 1
     * @ensure /result = [index_1, index_2] where index_1 <= index_2 &&
     *          index_1 is the first index of pivot in sorted list (from left to right) &&
     *          index_2 is the last index of pivot in sorted list (from left to right) &&
     *          for all elements which index i is between index_1 to index_2, list[i] = pivot
     * @param list the array to find the kth number
     * @param left the start index to find kth number
     * @param right the end index to find kth number
     * @param pivot the pivot to quick sort array
     * @return an array contains the start and end index of element which value is equal to pivot
     */
    public static int[] rangeOfPivot(int[] list, int left, int right, int pivot) {
        // the last index of number which is less than pivot
        int lessIndex = left - 1;

        // the first index of number which is larger than pivot
        int moreIndex = right + 1;

        // the index of element which is checked currently
        int currentIndex = left;

        while (currentIndex < moreIndex) {
            if (list[currentIndex] < pivot) {
                /*
                switch the position of two element, which are current index and the one
                next(right) to the less index, then current index plus 1
                the elements between less and current index are all pivot,
                so don't need to compare, just add the current index
                */
                SomeHelpfulSortingMethod.switchElement(list, ++lessIndex, currentIndex++);
            } else if (list[currentIndex] > pivot) {
                /*
                 switch the position of two element, which are current index and the one
                 next(left) to the mare index, then check the current position
                */
                SomeHelpfulSortingMethod.switchElement(list, --moreIndex, currentIndex);
            } else {
                currentIndex++;
            }
        }

        return new int[] {lessIndex + 1, moreIndex - 1};
    }


    /**
     * An method to find M (approximately medium number in list)
     * and use quick algorithm to find the kth number in list
     *
     * <p>
     *     Principle:
     *     <ul>
     *         <li>Separator the list into several sub-arrays, which size are 5.
     *         if there are some rest elements, also put them into a sub-array. </li>
     *         <li>Sorted the elements from each sub-array from small to large. </li>
     *         <li>Create an array named medium array to contains the medium number
     *         of each sub-array. </li>
     *         <li>Return the medium number of medium array as M. </li>
     *     </ul>
     * </p>
     *
     * @requires 0 <= left < right < list.length - 1
     * @ensure /result = mediumArray[(mediumArray.length) / 2]
     * @param list the original array to find kth number
     * @param left the start position to find medium (usually is 0)
     * @param right the end position to find medium (usually is list.len - 1)
     * @return the medium number in medium array as pivot
     */
    public static int mediumOfMedium(int[] list, int left, int right) {
        // the number of sub-array which size is 5
        int sizeOfSet = right - left + 1;

        // the number of sub-array which size is less than 5
        int extraSetNum = sizeOfSet % 5 == 0 ? 0 : 1;

        // the medium array which contains elements are mediums of each sub-array
        int[] mediumList = new int[sizeOfSet / 5 + extraSetNum];

        for (int m = 0; m < mediumList.length; m++) {
            // index of start of each sub-array
            int firstIndexInArray = left + m * 5;

            /*
             get the medium of each sub-array, which start index is firstIndexInArray,
             and end index is the minimal number of right boundary and start index + 5.
            */
            mediumList[m] = getMedium(list,
                    firstIndexInArray, Math.min(right, firstIndexInArray + 4));
        }

        return bfprt(mediumList, 0, mediumList.length - 1, mediumList.length / 2);
    }


    /**
     * Calculate the medium number of given sub-array
     *
     * @requires 0 <= left < right < list.length - 1
     * @ensure /result = list[(left + right) / 2]
     * @param list the array to find medium number
     * @param left the start index of sub-array
     * @param right the end index of sub-array
     * @return medium number of sub-array which is start from left and end at right
     */
    public static int getMedium(int[] list, int left, int right) {
        // import sort algorithm to sort sub-array which indexes are from left to right
        MergeSort.sortSubArray(list, left, right);
        return list[(left + right) / 2];
    }


    // public static void main(String[] args) {
    //     // int[] a = {5, 9, 3, 2, 8, 4, 1, 2, 0, 9, 6, 7, 8, 3, 4, 9, 2, 1, 8, 6};
    //     int[] a = {5, 4, 3, 2, 1, 1, 2, 3, 4, 5};
    //     int kThNumber;
    //     for (int i = 1; i <= 10; i++) {
    //         kThNumber = getKthNumber(a, i);
    //         System.out.println("the " + i + "th number in list is: " + kThNumber);
    //     }
    // }
}
