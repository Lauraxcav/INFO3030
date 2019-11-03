package edu.lauracavanaugh.advancedjava.week8;

import edu.lauracavanaugh.advancedjava.week2.ServiceFactory;
import edu.lauracavanaugh.advancedjava.week2.StockQuote;
import edu.lauracavanaugh.advancedjava.week2.StockService;
import org.junit.Test;

import javax.xml.ws.Service;

import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

public class AdapterClassTest {

    @Test
    public void getQuote() {
        StockService service = ServiceFactory.getStockServiceInstance();
        StockQuote stockQuote = service.getQuote("DIS");
        assertEquals(stockQuote.getSymbol(),"DIS");
        assertTrue(stockQuote.getPrice()>0);
        System.out.println(stockQuote);
    }

    @Test
    public void GetQuotes() {
        StockService service = ServiceFactory.getStockServiceInstance();

        // I don't actually use the calendar or the interval
        // this defaults to the last opening day, and a 5min interval
        // The actual functionality would be done "the next work day", or in version 1.2 (or 1.5 or whatever)
        List<StockQuote> stockQuotes = service.getQuote(
                "DIS", Calendar.getInstance(), Calendar.getInstance(), StockService.IntervalEnum.MINUTE);
        assertEquals(stockQuotes.get(1).getSymbol(),"DIS");
        assertTrue(stockQuotes.get(1).getPrice()>0);
        assertTrue(stockQuotes.size()>0);
        System.out.println(stockQuotes);
    }
}