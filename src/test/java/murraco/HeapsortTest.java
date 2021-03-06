package murraco;

import java.util.Arrays;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.Test;
import org.junit.runner.RunWith;


import static org.junit.Assert.*;

@RunWith(JUnitQuickcheck.class)

public class HeapsortTest {

    @Property
    public void shouldSortPositiveAndNegative(Integer[] data) {
        //System.out.println(Arrays.toString(data));

        Integer[] copy = data.clone();
        Heapsort.heapSort(copy);
        Arrays.sort(data);

        assertArrayEquals(copy, data);
    }


    @Property
    public void shouldSortStrings(String[] data) {
        //System.out.println(Arrays.toString(data));

        String[] copy = data.clone();
        Heapsort.heapSort(copy);
        Arrays.sort(data);

        assertArrayEquals(copy, data);
    }

    @Property
    public void shouldSortListWithOneValue(Integer n) {
        Integer[] data = {n};
        //System.out.println(Arrays.toString(data));
        Integer[] copy = data.clone();
        Heapsort.heapSort(copy);
        Arrays.sort(data);

        assertArrayEquals(copy, data);
    }

    @Property
    public void shouldSortListWithDoubleValues(Double[] data) {
        //System.out.println(Arrays.toString(data));
        Double[] copy = data.clone();
        Heapsort.heapSort(copy);
        Arrays.sort(data);

        assertArrayEquals(copy, data);
    }


    // Will try to make a quickCheck generator that does this instead.
    @Property
    public void shouldSortListWithRepeatedElements(Integer[] data) {
        for (int i = 0; i < data.length; i++) {
            data[i] = data[0];
        }
        //System.out.println(Arrays.toString(data));
        Integer[] copy = data.clone();
        Heapsort.heapSort(copy);
        Arrays.sort(data);

        assertArrayEquals(copy, data);
    }

    @Property
    public void shouldSwapLeastNumberOfTimesPossible(Integer[] data) {
        for (int i = 0; i < data.length; i++) {
            data[i] = data[0];
        }
        //System.out.println(Arrays.toString(data));
        Integer[] copy = data.clone();
        Heapsort.heapSort(copy);
        Arrays.sort(data);

        int expectedSwaps = 0;
        int realSwaps = Heapsort.getNumberOfSwaps();
        if(data.length != 0){
            expectedSwaps = data.length - 1;
        }

        assertEquals(realSwaps, expectedSwaps);
    }

    @Test(expected = NegativeArraySizeException.class)
    public void shouldThrowNegativeArrayException() {
        Integer[] data = new Integer[-2];
        Heapsort.heapSort(data);
    }

    @Test(expected = NullPointerException.class)
    public void nullElementShouldThrow() {
        Integer[] data = new Integer[2];
        Heapsort.heapSort(data);
    }

    @Test
    public void shouldNotThrowNullPointerException() {
        Integer[] data = new Integer[1];
        Heapsort.heapSort(data);
        Integer[] arr = {null};
        assertArrayEquals(data,arr);
    }

    @Test(expected = NullPointerException.class)
    public void nullArrayShouldThrow() {
        Heapsort.heapSort(null);
    }
}