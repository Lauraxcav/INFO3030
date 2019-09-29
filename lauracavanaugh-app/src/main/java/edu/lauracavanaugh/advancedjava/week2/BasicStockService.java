package edu.lauracavanaugh.advancedjava.week2;

import sun.util.calendar.BaseCalendar;
import sun.util.calendar.LocalGregorianCalendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/*
This is the class known as BasicStockService in the class notes.
It implements the interface.
Week Two said: A BasicStockService implementation. This can be dead simple. It has to return
an instance of a StockQuote. That instance can be 'hard coded'
 */
public class BasicStockService implements StockService {

    public StockQuote getQuote(String symbol) {
        return new StockQuote(symbol);
    }
    public StockQuote getQuote(String symbol, Calendar date){
        return new StockQuote(symbol);
    }

    public List<StockQuote> getQuote(String symbol, Calendar from,
                                     Calendar until) {

        List<StockQuote> stockQuotes = new ArrayList<StockQuote>();
        Calendar calendar = Calendar.getInstance();

        while (calendar.after(from) && calendar.before(until)) {
            stockQuotes.add(this.getQuote(symbol, calendar));
            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }


        return stockQuotes;
    }
}
