import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;


public class ComparingArrayTest {


    @Test
    public void arraySortTest_RandomArray() {
        int[] numbers = {12, 3, 4, 1};
        int[] expected = {1, 3, 4, 12};
        Arrays.sort(numbers);

        assertArrayEquals(expected, numbers);
    }


    @Test(expected = NullPointerException.class) // the exception is expected
    public void arraySortTest_NullArray() {
        int[] numbers = null;
        Arrays.sort(numbers);
    }


    @Test(timeout = 1000) // tests performance
    public void arraySort_Performance() {
        int[] array = {12, 23, 4};

        for (int i = 1; i <= 1000000; i++) {
            array[0] = i;
            Arrays.sort(array);
        }
    }




}
