package sortalgorithm.somehelpfulmethods;

import java.util.StringJoiner;

/**
 * a class stores some useful static method for sorting algorithm
 */
public class SomeHelpfulSortingMethod {

    /**
     * count the number of unique element in the array
     *
     * @param list an array to count unique element
     * @return number of unique element in an array
     */
    public static int getMaxNumberInArray(int[] list) {
        int maxVal = list[0];
        for (int val : list) {
            if (maxVal < val) {
                maxVal = val;
            }
        }
        return maxVal;
    }

    /**
     * switch two element in the given array
     *
     * @param array an array to switch two position of element
     * @param a position of a element
     * @param b position of another element
     */
    public static void switchElement(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    /**
     * Print the array list
     * @param array an array will be printed
     */
    public static void printArray(int[] array) {
        StringJoiner sortedArray = new StringJoiner(", ",
                "The sorted array is: [", "]");
        for (int element : array) {
            sortedArray.add(element + "");
        }
        System.out.println(sortedArray);
        System.out.println(printPosition(sortedArray.toString(), array));
    }

    /**
     * print position information
     *
     * @param arrayInformation string of array
     * @param array an array
     * @return string information of position
     */
    public static String printPosition(String arrayInformation, int[] array) {
        StringJoiner sortedPosition1 = new StringJoiner("  ",
                " ".repeat(arrayInformation.indexOf('[') + 1), " ");
        StringJoiner sortedPosition2 = new StringJoiner("  ",
                " ".repeat(arrayInformation.indexOf('[') + 1), " ");

        for (int position = 0; position < array.length; position++) {
            sortedPosition1.add("^");
        }
        for (int position = 0; position < array.length; position++) {
            sortedPosition2.add(position + "");
        }

        return sortedPosition1.toString() + System.lineSeparator()
                + sortedPosition2.toString();
    }

    /**
     * a method to insert the element in given old position to new position
     * and  all elements between these boundary would move to next position
     *
     * <p>Requires</p>
     * <p>array != null, oldPos larger than newPos and no less than 0</p>
     * <p>Ensure</p>
     * <p>array[oldPos] = array[oldPos - 1], ... , array[newPos + 1] = array[newPos],
     * array[newPos] = array[oldPos]</p>
     *
     * @param array an array to do insertion operation
     * @param oldPos an old position of an element to be inserted
     * @param newPos a new position of an element to be inserted
     */
    public static void insertElement(int[] array, int oldPos, int newPos) {
        int temp = array[oldPos];
        for (int i = oldPos; i > newPos; i--) {
            array[i] = array[i - 1];
        }
        array[newPos] = temp;
    }

    /**
     * paste a sub Array to the array
     *
     * <p>Requires</p>
     * <p>array != null, sub-array != null, end - start + 1 = sub-array.length</p>
     * <p>Ensure</p>
     * <p>array[start] = subArray[0], array[start + 1] = subArray[1],
     * array[end] = subArray[subArray.length - 1]</p>
     *
     * @param array an array to be pasted
     * @param start start position to paste
     * @param end end position to paste
     * @param subArray a subArray to past into array
     */
    public static void pastSubArray(int[] array, int start, int end, int[] subArray) {
        int index = 0;
        for (int i = start; i <= end; i++) {
            array[i] = subArray[index++];
        }
    }
}
