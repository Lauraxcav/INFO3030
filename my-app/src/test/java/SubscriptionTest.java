import org.junit.*;
import static org.junit.Assert.*;

public class SubscriptionTest {

    @Test
    public void testReturnEuro() {
        Subscription s = new Subscription(200,2);
        assertTrue(s.pricePerMonth()==1.0);
    }

    @Test
    public void testRoundUp() {
        Subscription s = new Subscription(200,3);
        assertTrue(s.pricePerMonth()==0.67);
    }
}