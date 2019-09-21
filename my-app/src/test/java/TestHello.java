import org.junit.Test;
import static org.junit.Assert.*;

public class TestHello {

    @org.junit.Test
    public void testFails() {
        String expected = "hey";
        String actual="there";
        assertEquals(expected,actual);
    }

    @org.junit.Test
    public void testPasses() {
        String expected ="Laura";
        String actual = "Laura";
        assertEquals(expected,actual);
    }

    @Test
    public void simpleAdd() {
        int a=2;
        int b=4;
        int expected=6;
        int results=a+b;
        assertTrue(expected==results);
    }

}