package mockito;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;


public class HamcrestMatchersTest {

    @Test
    public void test() {
        List<Integer> scores = Arrays.asList(99, 100, 101, 105);

        //scores have 4 items
        assertEquals(scores.size(), 4);
        assertTrue(scores.contains(99));

    }


}
