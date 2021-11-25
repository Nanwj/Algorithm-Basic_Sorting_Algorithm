package AlgorithmTest;

import bfprt.BFPRTAlgorithm;
import sortalgorithm.base.BaseSort;
import sortalgorithm.count.CountSort;
import sortalgorithm.insertion.InsertionSort;
import sortalgorithm.merge.MergeSort;
import sortalgorithm.quick.QuickSort;
import sortalgorithm.shell.ShellSort;
import org.junit.Before;
import org.junit.Test;
import sortalgorithm.selection.SelectionSort;
import sortalgorithm.bubble.BubbleSort;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

public class ArraySortTest {
    int[] array1;
    int[] expected;
    Random random;

    @Before
    public void setup() {
        random = new Random();
        array1 = new int[10000];
        expected = new int[10000];

        for (int i = 0; i < array1.length; i++) {
            array1[i] = random.nextInt(10000);
        }

        System.arraycopy(array1, 0, expected, 0, array1.length);
    }

    @Test
    public void selectSortedTest() {
        Arrays.sort(expected);
        SelectionSort.sortArray(array1);

        for (int i = 0; i < expected.length; i++) {
            assertEquals("Algothrim.Select sort is not correct",
                    expected[i], array1[i]);
        }
    }



    @Test
    public void bubbleSortedTest() {
        Arrays.sort(expected);
        BubbleSort.sortArray(array1);

        for (int i = 0; i < expected.length; i++) {
            assertEquals("Algothrim.Select sort is not correct",
                    expected[i], array1[i]);
        }
    }

    @Test
    public void insertionSortedTest() {
        Arrays.sort(expected);
        InsertionSort.sortArray(array1);

        for (int i = 0; i < expected.length; i++) {
            assertEquals("Algothrim.Select sort is not correct",
                    expected[i], array1[i]);
        }
    }

    @Test
    public void shellSortedTest() {
        Arrays.sort(expected);
        ShellSort.sortArray(array1);

        for (int i = 0; i < expected.length; i++) {
            assertEquals("Algothrim.Select sort is not correct",
                    expected[i], array1[i]);
        }
    }

    @Test
    public void mergeSortedTest() {
        Arrays.sort(expected);
        MergeSort.sortArray(array1);

        for (int i = 0; i < expected.length; i++) {
            assertEquals("Algothrim.Select sort is not correct",
                    expected[i], array1[i]);
        }
    }

    @Test
    public void quickSortedTest() {
        Arrays.sort(expected);
        QuickSort.sortArray(array1);

        for (int i = 0; i < expected.length; i++) {
            assertEquals("Algothrim.Select sort is not correct",
                    expected[i], array1[i]);
        }
    }

    @Test
    public void countSortedTest() {
        Arrays.sort(expected);
        array1 = CountSort.sortArray(array1);

        for (int i = 0; i < expected.length; i++) {
            assertEquals("Algothrim.Select sort is not correct",
                    expected[i], array1[i]);
        }
    }

    @Test
    public void baseSortedTest() {
        Arrays.sort(expected);
        array1 = BaseSort.sortArray(array1);

        for (int i = 0; i < expected.length; i++) {
            assertEquals("Algothrim.Select sort is not correct",
                    expected[i], array1[i]);
        }
    }

    @Test
    public void bfprtTest() {
        int k;
        for (int i = 0; i < 100; i++) {
            k = (int) (Math.random() * array1.length);
            Arrays.sort(expected);
            assertEquals("bfprt is not correct", expected[k - 1],
                    BFPRTAlgorithm.getKthNumberMethod1(array1, k));
            assertEquals("normal method to find kth element is not correct",
                    expected[k - 1], BFPRTAlgorithm.getKthNumberMethod2(array1, k));
        }
    }
}