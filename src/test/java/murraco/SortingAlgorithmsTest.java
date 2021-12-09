package murraco;

import java.util.ArrayList;
import java.util.Arrays;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import org.junit.Test;

import murraco.BubbleSort;
import murraco.Heapsort;
import murraco.InsertionSort;
import murraco.MergeSort;
import murraco.Quicksort;
import murraco.SelectionSort;

import static org.junit.Assert.*;

@RunWith(JUnitQuickcheck.class)

public class SortingAlgorithmsTest {
    @Property
    public void sortArray(Integer[] data) {
        //System.out.println(Arrays.toString(data));
        Integer[] clone = data.clone();
        BubbleSort.bubbleSort(data);
        Arrays.sort(clone);
        assertArrayEquals(data, clone);
    }

    @Property
    public void sortString(String[] data) {
        // System.out.println(Arrays.toString(data));
        String[] clone = data.clone();
        BubbleSort.bubbleSort(data);
        Arrays.sort(clone);
        assertArrayEquals(data, clone);
    }

    @Test
    public void testBubbleSort() {
        final Integer[] data = {4, 3, 0, 11, 7, 5, 15, 12, 99, 1};
        BubbleSort.bubbleSort(data);
        assertEquals("[0, 1, 3, 4, 5, 7, 11, 12, 15, 99]", Arrays.toString(data));
        System.out.println("Det fonkar");
    }


    @Property public void shouldSortPositiveAndNegative(Integer[] data) {
        System.out.println(Arrays.toString(data));
        ArrayList<Integer[]> copies = new ArrayList<>();
        for(int i = 0; i < 6; i++){
            copies.add(data.clone());
        }
        BubbleSort.bubbleSort(copies.get(0));
        Heapsort.heapSort(copies.get(1));
        InsertionSort.insertionSort(copies.get(2));
        MergeSort.mergeSort(copies.get(3));
        Quicksort.quickSort(copies.get(4));
        SelectionSort.selectionSort(copies.get(5));
        Arrays.sort(data);

        for (Integer[] arr: copies) {
            assertArrayEquals(arr, data);
        }

    }

    @Test
    public void shouldSortNegativeIntegers() {
        Integer[] data = {-3465, -1231, -1, -35, -324324, -2};
        BubbleSort.bubbleSort(data);
        assertEquals("[-324324, -3465, -1231, -35, -2, -1]", Arrays.toString(data));
    }

    @Test
    public void shouldSortStrings() {
        String[] data = {"hi", "hello", "banana", "Highway", "Appendix", "Xylophone"};
        InsertionSort.insertionSort(data);
        assertEquals("[Appendix, Highway, Xylophone, banana, hello, hi]", Arrays.toString(data));
    }

    @Test
    public void sortEmptyList() {
        Integer[] data = {};
        Quicksort.quickSort(data);
        assertEquals("[]", Arrays.toString(data));
    }

    @Test
    public void sortListWithOneValue() {
        Integer[] data = {42};
        Heapsort.heapSort(data);
        assertEquals("[42]", Arrays.toString(data));
    }

    @Test
    public void sortListWithDoubleValues() {
        Double[] data = {2.2, 32.4, -32.11, 67876.4323, 2.3};
        BubbleSort.bubbleSort(data);
        //MergeSort.mergeSort(data);
        //Mergesort only tests Integers
        assertEquals("[-32.11, 2.2, 2.3, 32.4, 67876.4323]", Arrays.toString(data));
    }

    @Test
    public void sortListWithRepeatedElements() {
        Integer[] data = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        BubbleSort.bubbleSort(data);
        assertEquals("[5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5]", Arrays.toString(data));
    }

    @Test
    public void testInsertionSort() {
        final Integer[] data = {4, 3, 0, 11, 7, 5, 15, 12, 99, 1};
        InsertionSort.insertionSort(data);
        assertEquals("[0, 1, 3, 4, 5, 7, 11, 12, 15, 99]", Arrays.toString(data));
    }

    @Test
    public void testSelectionSort() {
        final Integer[] data = {4, 3, 0, 11, 7, 5, 15, 12, 99, 1};
        SelectionSort.selectionSort(data);
        assertEquals("[0, 1, 3, 4, 5, 7, 11, 12, 15, 99]", Arrays.toString(data));
    }

    @Test
    public void testMergeSort() {
        final Integer[] data = {4, 3, 0, 11, 7, 5, 15, 12, 99, 1};
        MergeSort.mergeSort(data);
        assertEquals("[0, 1, 3, 4, 5, 7, 11, 12, 15, 99]", Arrays.toString(data));
    }

    @Test
    public void testHeapsort() {
        final Integer[] data = {4, 3, 0, 11, 7, 5, 15, 12, 99, 1};
        Heapsort.heapSort(data);
        assertEquals("[0, 1, 3, 4, 5, 7, 11, 12, 15, 99]", Arrays.toString(data));
    }

    @Test
    public void testQuicksort() {
        final Integer[] data = {4, 3, 0, 11, 7, 5, 15, 12, 99, 1};
        Quicksort.quickSort(data);
        assertEquals("[0, 1, 3, 4, 5, 7, 11, 12, 15, 99]", Arrays.toString(data));
    }

    @Test
    public void testIfNegativeInteger() {
        final Integer[] data = {4, 3, 0, 11, 7, -2, 15, 12, 99, 1};
        BubbleSort.bubbleSort(data);
        InsertionSort.insertionSort(data);
        SelectionSort.selectionSort(data);


    }

}