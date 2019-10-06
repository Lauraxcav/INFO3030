package edu.lauracavanaugh.advancedjava;

import edu.lauracavanaugh.advancedjava.week2.StockApplication;
import edu.lauracavanaugh.advancedjava.week2.StockService;
import org.junit.Test;
import java.text.ParseException;

public class StockApplicationTest {


    @Test
    public void testMain() throws ParseException {

        String interval = StockService.IntervalEnum.DAY.toString();
        String[] args = new String[] {"IBM","09/27/2019","09/29/2019",interval} ;
        StockApplication.main(args);

    }

    /**
     * This is dumb - this should work
     * @throws ParseException, NullPointerException
     */
   @Test(expected = NullPointerException.class)
    public void testMainNegative() throws ParseException, NullPointerException {
        StockApplication.main(null);
    }
}
