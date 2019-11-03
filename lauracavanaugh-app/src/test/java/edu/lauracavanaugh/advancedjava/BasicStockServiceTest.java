package edu.lauracavanaugh.advancedjava;

import edu.lauracavanaugh.advancedjava.week2.BasicStockService;
import edu.lauracavanaugh.advancedjava.week2.StockQuote;
import edu.lauracavanaugh.advancedjava.week2.StockService;
import junit.framework.TestCase;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Calendar;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BasicStockServiceTest extends TestCase {

    private BasicStockService mockStockService;
    private String mockSymbol = "ORCL";
    private Calendar mockStart = Calendar.getInstance();
    private Calendar mockEnd = Calendar.getInstance();

    public void setup() {
        this.mockStockService = Mockito.mock(BasicStockService.class);
        when(mockStockService.getQuote(any(String.class))).thenReturn(new StockQuote(mockSymbol));
        mockStart.add(Calendar.DAY_OF_YEAR,-2);

    }

    @Test
    public void testBasicStockService()
    {
       setup();
        assertEquals(mockStockService.getQuote(mockSymbol).getSymbol(),mockSymbol);
        //BasicStockService mockStockService = Mockito.mock(BasicStockService.class);
        //when(mockStockService.getQuote(any(String.class))).thenReturn(new StockQuote(symbol));

    }

    @Test
    public void testSymbol() {
        setup();
        assertEquals(mockStockService.getQuote(mockSymbol).getSymbol(),mockSymbol);
    }

    @Test
    public void testEquals() {
        setup();
        StockQuote testQuote = new StockQuote(this.mockSymbol);
        //assertTrue(this.mockStockService.getQuote(mockSymbol).equals(testQuote));
        //assertTrue(testQuote.equals(this.mockStockService.getQuote(mockSymbol)));
    }

    @Test
    public void testList() {
        setup();
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.DAY_OF_YEAR,-2);
        Calendar today = Calendar.getInstance();
        BasicStockService basicStockService = new BasicStockService();


        List<StockQuote> myTestQuotes =  basicStockService.getQuote(mockSymbol, startDate, today, StockService.IntervalEnum.DAY);
        // will return 3 quotes, one for each day, inclusive: [today-2, today-1, and today]
        assertEquals(myTestQuotes.size(),3);

        myTestQuotes = basicStockService.getQuote(mockSymbol, today, today, StockService.IntervalEnum.DAY);
        // will return 1 quote for [today]
        assertEquals(myTestQuotes.size(), 1);
    }

    @Test
    public void testIntervalEnumHOUR() {
        setup();
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.HOUR_OF_DAY,-2);
        Calendar today = Calendar.getInstance();
        BasicStockService basicStockService = new BasicStockService();
        List<StockQuote> myTestQuotes =  basicStockService.getQuote(mockSymbol, startDate, today, StockService.IntervalEnum.HOUR);

        // will return 3 quotes, one for each day, inclusive: [hour-2, hour-1, hour]
        assertEquals(myTestQuotes.size(),3);

        myTestQuotes = basicStockService.getQuote(mockSymbol, today, today, StockService.IntervalEnum.HOUR);
        // will return 1 quote for [hour]
        assertEquals(myTestQuotes.size(), 1);

    }

    @Test
    public void testIntervalEnumMINUTE() {
        setup();
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MINUTE,-2);
        Calendar today = Calendar.getInstance();
        BasicStockService basicStockService = new BasicStockService();
        List<StockQuote> myTestQuotes =  basicStockService.getQuote(mockSymbol, startDate, today, StockService.IntervalEnum.MINUTE);
        // will return 3 quotes, one for each day, inclusive: [today-2, today-1, and today]
        assertEquals(myTestQuotes.size(),3);

        myTestQuotes = basicStockService.getQuote(mockSymbol, today, today, StockService.IntervalEnum.MINUTE);
        // will return 1 quote for [minute]
        assertEquals(myTestQuotes.size(), 1);
    }

}
