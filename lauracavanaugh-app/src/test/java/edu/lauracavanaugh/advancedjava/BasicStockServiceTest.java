package edu.lauracavanaugh.advancedjava;

import edu.lauracavanaugh.advancedjava.week2.BasicStockService;
import edu.lauracavanaugh.advancedjava.week2.StockQuote;
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
        assertTrue(this.mockStockService.getQuote(mockSymbol).equals(testQuote));
        assertTrue(testQuote.equals(this.mockStockService.getQuote(mockSymbol)));
    }

    @Test
    public void testList() {
        setup();
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.DAY_OF_YEAR,-2);
        Calendar today = Calendar.getInstance();
        BasicStockService basicStockService = new BasicStockService();
        List<StockQuote> myTestQuotes =  basicStockService.getQuote(mockSymbol, startDate, today);
    }

}
