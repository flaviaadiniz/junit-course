import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class StringHelperParameterizedTest {

    StringHelper helper = new StringHelper();

    private String input;
    private String expectedOutput;


    public StringHelperParameterizedTest(String input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }


    @Parameterized.Parameters
    public static Collection<String[]> testConditions() {
        String[][] expectedOutputs = {{"AACD", "CD"}, {"ACD", "CD"}};
        return Arrays.asList(expectedOutputs);
    }


    @Test
    public void truncateAInFirst2PositionsTest() {
        assertEquals(expectedOutput, helper.truncateAInFirst2Positions(input));
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
