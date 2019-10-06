package edu.lauracavanaugh.advancedjava.week2;

import sun.util.calendar.BaseCalendar;
import sun.util.calendar.LocalGregorianCalendar;

import javax.validation.constraints.NotNull;
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

    @NotNull
    public List<StockQuote> getQuote(String symbol, Calendar from,
                                     Calendar until, IntervalEnum interval) {

        List<StockQuote> stockQuotes = new ArrayList<StockQuote>();
        Calendar calendar = Calendar.getInstance();

        // oops - set the calendar to "from"
        calendar.setTime(from.getTime());

        // increment calendar by the chosen interval

        while (calendar.compareTo(from)>=0 && calendar.compareTo(until)<=0) {
            stockQuotes.add(this.getQuote(symbol, calendar));

            // convert the IntervalEnum to a Calendar field
            int field;
            switch (interval) {
                case HOUR: field = Calendar.HOUR_OF_DAY;
                    break;
                case MINUTE: field = Calendar.MINUTE;
                    break;
                default: field = Calendar.DAY_OF_YEAR;
                    break;
            }
            calendar.add(field, 1);
        }

        return stockQuotes;
    }
}
