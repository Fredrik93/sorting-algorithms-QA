package murraco;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import java.util.Arrays;

/*
Some basic quickCheck tests below, mostly there to test quickCheck and
build on it later.
 */

@RunWith(JUnitQuickcheck.class)
public class SortingTest {
    @Property public void sortArray(@InRange(min = "0")Integer[] data) {
        System.out.println(Arrays.toString(data));
        Integer[] clone = data.clone();
        BubbleSort.bubbleSort(data);
        Arrays.sort(clone);
        assertArrayEquals(data, clone);
    }
    @Property public void sortString(String[] data) {
        //System.out.println(Arrays.toString(data));
        String[] clone = data.clone();
        BubbleSort.bubbleSort(data);
        Arrays.sort(clone);
        assertArrayEquals(data, clone);
    }


}