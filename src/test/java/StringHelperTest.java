import org.junit.Test;

import static org.junit.Assert.*;

public class StringHelperTest {

    StringHelper helper = new StringHelper();

    @Test
    public void truncateAInFirst2PositionsTest_AInFirst2Positions() {
        assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
    }


    @Test
    public void truncateAInFirst2PositionsTest_AInFirstPosition() {
        assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
    }

}
