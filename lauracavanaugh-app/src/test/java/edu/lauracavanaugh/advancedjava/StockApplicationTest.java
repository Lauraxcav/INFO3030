package edu.lauracavanaugh.advancedjava;

import edu.lauracavanaugh.advancedjava.week2.StockApplication;
import junit.framework.TestCase;
import org.junit.Test;
import org.mockito.internal.matchers.Null;

import java.text.ParseException;

public class StockApplicationTest extends TestCase {


    @Test
    public void testMain() throws ParseException {

        String[] args = new String[] {"IBM","09/27/2019","09/29/2019"} ;
        StockApplication.main(args);

    }

    /**
     * This is dumb - this should work
     * @throws ParseException
     */
   @Test(expected = NullPointerException.class)
    public void testMainNegative() throws ParseException {
        StockApplication.main(null);
    }
}
