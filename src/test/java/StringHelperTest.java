import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringHelperTest {

    StringHelper helper;

    @Before
    public void before() {
        helper = new StringHelper();
    }

    @Test
    public void truncateAInFirst2PositionsTest_AInFirst2Positions() {
        assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
    }


    @Test
    public void truncateAInFirst2PositionsTest_AInFirstPosition() {
        assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
    }


    @Test
    public void areFirstAndLastTwoCharactersTheSameTest_BasicNegativeScenario() {
        assertFalse(helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
    }


    @Test
    public void areFirstAndLastTwoCharactersTheSameTest_BasicPositiveScenario() {
        assertTrue(helper.areFirstAndLastTwoCharactersTheSame("ABAB"));
    }

}
