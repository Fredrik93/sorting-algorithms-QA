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

public class QuicksortTest {

    @Property
    public void shouldSortPositiveAndNegative(Integer[] data) {
        //System.out.println(Arrays.toString(data));

        Integer[] copy = data.clone();
        Quicksort.quickSort(copy);
        Arrays.sort(data);

        assertArrayEquals(copy, data);
    }



    @Property
    public void shouldSortStrings(String[] data) {
        //System.out.println(Arrays.toString(data));

        String[] copy = data.clone();
        Quicksort.quickSort(copy);
        Arrays.sort(data);

        assertArrayEquals(copy, data);
    }

    @Property
    public void shouldSortListWithOneValue(Integer n) {
        Integer[] data = {n};
        //System.out.println(Arrays.toString(data));
        Integer[] copy = data.clone();
        Quicksort.quickSort(copy);
        Arrays.sort(data);

        assertArrayEquals(copy, data);
    }

    @Property
    public void shouldSortListWithDoubleValues(Double[] data) {
        //System.out.println(Arrays.toString(data));
        Double[] copy = data.clone();
        Quicksort.quickSort(copy);
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
        Quicksort.quickSort(copy);
        Arrays.sort(data);

        assertArrayEquals(copy, data);
    }

    @Property
    public void shouldSortListWithNulls(@NullAllowed(probability = 0.1f) Integer[] data) {
        try {
            if(data.length != 0){
                data [data.length-1] = null;
            }
            Integer[] copy = data.clone();
            if(data.length > 1){
                try{
                    Quicksort.quickSort(copy);
                }catch (NullPointerException e){
                    e.getMessage();
                    return;
                }
            }
            Arrays.sort(data);
            // System.out.println(Arrays.toString(data));
            assertArrayEquals(copy, data);
        } catch (NullPointerException e) {
            assertNull(data);
        }
    }

    @Test(expected = NegativeArraySizeException.class)
    public void shouldThrowNegativeArrayException() {
        Integer[] data = new Integer[-2];
        Quicksort.quickSort(data);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerException() {
        Integer[] data = new Integer[2];
        Quicksort.quickSort(data);
    }
}