package edu.lauracavanaugh.advancedjava;

import edu.lauracavanaugh.advancedjava.week2.ServiceProvider;
import edu.lauracavanaugh.advancedjava.week2.StockQuote;
import edu.lauracavanaugh.advancedjava.week2.StockService;
import junit.framework.TestCase;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Week2Test extends TestCase {

    private ServiceProvider mockStockService;
    private String mockSymbol = "ORCL";

    public void setup() {
        this.mockStockService = Mockito.mock(ServiceProvider.class);
        when(mockStockService.getQuote(any(String.class))).thenReturn(new StockQuote(mockSymbol));
    }

    @Test
    public void testServiceProvider()
    {
        String symbol = "IBM";
        double price = 137.34983;

        ServiceProvider mockStockService = Mockito.mock(ServiceProvider.class);
        when(mockStockService.getQuote(any(String.class))).thenReturn(new StockQuote(symbol));

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

}
