package mockito;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;


public class HamcrestMatchersTest {

    @Test
    public void test() {
        List<Integer> scores = Arrays.asList(99, 100, 101, 105);

        //assert thst scores has 4 items
        assertEquals(scores.size(), 4);

        //assert that scores contais 99
        assertTrue(scores.contains(99));

        //assert that items in score are under 110
        assertThat(scores, everyItem(lessThan(110)));

        //assert array size
        Integer[] marks = {1, 2, 3, 4};
        assertThat(marks, arrayWithSize(4));

    }


}
