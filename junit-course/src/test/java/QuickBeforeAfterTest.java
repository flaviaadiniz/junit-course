import org.junit.*;

public class QuickBeforeAfterTest {

    @BeforeClass // runs only once, before the whole class is run - must be static
    public static void beforeClass() {
        System.out.println("Before class");
    }


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

    @AfterClass // runs onyl once, after the whole class is run - must be static
    public static void afterClass() {
        System.out.println("After class");
    }


}