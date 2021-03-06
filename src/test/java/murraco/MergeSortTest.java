package murraco;

import java.util.Arrays;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.Test;
import org.junit.runner.RunWith;


import static org.junit.Assert.*;

@RunWith(JUnitQuickcheck.class)

public class MergeSortTest {

    @Property
    public void shouldSortPositiveAndNegative(Integer[] data) {
        //System.out.println(Arrays.toString(data));

        Integer[] copy = data.clone();
        MergeSort.mergeSort(copy);
        Arrays.sort(data);

        assertArrayEquals(copy, data);
    }



    /*@Property
    public void shouldSortStrings(String[] data) {
        //System.out.println(Arrays.toString(data));

        String[] copy = data.clone();
        MergeSort.mergeSort(copy);
        Arrays.sort(data);

        assertArrayEquals(copy, data);
    }*/

    @Property
    public void shouldSortListWithOneValue(Integer n) {
        Integer[] data = {n};
        //System.out.println(Arrays.toString(data));
        Integer[] copy = data.clone();
        MergeSort.mergeSort(copy);
        Arrays.sort(data);

        assertArrayEquals(copy, data);
    }

    /*@Property
    public void shouldSortListWithDoubleValues(Double[] data) {
        //System.out.println(Arrays.toString(data));
        Double[] copy = data.clone();
        MergeSort.mergeSort(copy);
        Arrays.sort(data);

        assertArrayEquals(copy, data);
    }*/


    // Will try to make a quickCheck generator that does this instead.
    @Property
    public void shouldSortListWithRepeatedElements(Integer[] data) {
        for (int i = 0; i < data.length; i++) {
            data[i] = data[0];
        }
        //System.out.println(Arrays.toString(data));
        Integer[] copy = data.clone();
        MergeSort.mergeSort(copy);
        Arrays.sort(data);

        assertArrayEquals(copy, data);
    }

    @Test(expected = NegativeArraySizeException.class)
    public void shouldThrowNegativeArrayException() {
        Integer[] data = new Integer[-2];
        MergeSort.mergeSort(data);
    }

    @Test(expected = NullPointerException.class)
    public void nullElementShouldThrow() {
        Integer[] data = new Integer[2];
        MergeSort.mergeSort(data);
    }

    @Test
    public void shouldNotThrowNullPointerException() {
        Integer[] data = new Integer[1];
        MergeSort.mergeSort(data);
        Integer[] arr = {null};
        assertArrayEquals(data,arr);
    }

    @Test(expected = NullPointerException.class)
    public void nullArrayShouldThrow() {
        MergeSort.mergeSort(null);
    }
}