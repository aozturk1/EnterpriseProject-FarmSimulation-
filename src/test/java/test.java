import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class test {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    //TESTING

    //test description
    @Test
    public void test() {
        assertEquals(2, 4-2);
    }

    @Test
    public void testFactorial() {
        assertEquals(1, Main.factorial(0));
        assertEquals(1, Main.factorial(1));
        assertEquals(2, Main.factorial(2));
        assertEquals(6, Main.factorial(3));
        assertEquals(24, Main.factorial(4));
        assertEquals(120, Main.factorial(5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFactorialNegative() {
        Main.factorial(-1);
    }

}