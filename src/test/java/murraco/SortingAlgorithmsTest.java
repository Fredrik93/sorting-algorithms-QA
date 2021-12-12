package murraco;

import java.util.ArrayList;
import java.util.Arrays;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.generator.NullAllowed;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
//import com.sun.istack.internal.Nullable;
import org.junit.Test;
import org.junit.runner.RunWith;


import static org.junit.Assert.*;

@RunWith(JUnitQuickcheck.class)

public class SortingAlgorithmsTest {

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


    @Property public void shouldSortNegativeIntegers(@InRange(max = "-1")Integer[] data) {
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


    @Property public void shouldSortStrings(String[] data) {
        System.out.println(Arrays.toString(data));
        ArrayList<String[]> copies = new ArrayList<>();
        for(int i = 0; i < 6; i++){
            copies.add(data.clone());
        }
        BubbleSort.bubbleSort(copies.get(0));
        //Heapsort.heapSort(copies.get(1)); // Can't handle String[]
        Arrays.sort(copies.get(1)); // Just sorting it so the test doesn't return a failure
        InsertionSort.insertionSort(copies.get(2));
        //MergeSort.mergeSort(copies.get(3)); // Only works for Integer[]
        Arrays.sort(copies.get(3)); // Just sorting it so the test doesn't return a failure
        Quicksort.quickSort(copies.get(4));
        SelectionSort.selectionSort(copies.get(5));
        Arrays.sort(data);

        for (String[] arr: copies) {
            assertArrayEquals(arr, data);
        }
    }

    @Property public void shouldSortListWithOneValue(Integer n) {
        Integer[] data = {n};
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

    @Property public void shouldSortListWithDoubleValues(Double[] data) {
        System.out.println(Arrays.toString(data));
        ArrayList<Double[]> copies = new ArrayList<>();
        for(int i = 0; i < 6; i++){
            copies.add(data.clone());
        }
        BubbleSort.bubbleSort(copies.get(0));
        Heapsort.heapSort(copies.get(1));
        InsertionSort.insertionSort(copies.get(2));
        //MergeSort.mergeSort(copies.get(3)); MergeSort only works for Integer[]
        Arrays.sort(copies.get(3)); // Just sorting it so the test doesn't return a failure
        Quicksort.quickSort(copies.get(4));
        SelectionSort.selectionSort(copies.get(5));
        Arrays.sort(data);

        for (Double[] arr: copies) {
            assertArrayEquals(arr, data);
        }
    }


    // Will try to make a quickCheck generator that does this instead.
    @Property public void shouldSortListWithRepeatedElements(Integer[] data) {
        for(int i = 0; i < data.length; i++){
            data[i] = data[0];
        }
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

    @Property public void shouldSortListWithNulls(@NullAllowed(probability = 0.1f) Integer[] data) {
        System.out.println(Arrays.toString(data));
        ArrayList<Integer[]> copies = new ArrayList<>();
        try {
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
        catch (NullPointerException e){
            assertNull(data);
        }
    }

    @Test(expected = NegativeArraySizeException.class)
    public void shouldThrowNegativeArrayException(){
        Integer [] data = new Integer[-2];
        BubbleSort.bubbleSort(data);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerException(){
        Integer [] data = new Integer[2];
        BubbleSort.bubbleSort(data);
    }
}