import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QuickBeforeAfterTest {

    @Before // runs before each test
    public void setUp() {
        System.out.println("Before");
    }

    @Test
    public void test() {
        System.out.println("Test 1 executed");
    }

    @Test
    public void test2() {
        System.out.println("Test 2 executed");
    }

    @After // runs after each test
    public void tearDown() {
        System.out.println("After test");
    }

}