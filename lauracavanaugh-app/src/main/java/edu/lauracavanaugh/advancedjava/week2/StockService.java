package edu.lauracavanaugh.advancedjava.week2;

import java.util.Calendar;
import java.util.List;

/*
This is the StockService interface that we had to write
 */
public interface StockService {

    /**
     * How often to poll a stock quote
     * Poll each minute, each hour, or each day
     */
    public enum IntervalEnum {
        MINUTE,HOUR,DAY;
    }
    /**
     * Return the current price for a share of stock for the given symbol
     * @param symbol the stock symbol of the company you want a quote for.
     * e.g. APPL for APPLE
     * @return a <CODE>StockQuote </CODE> instance
     */
    StockQuote getQuote(String symbol);

    /**
     * Get a historical list of stock quotes for the provided
     * symbol
     * @param symbol the stock symbol to search for
     * @param from the date of the first stock quote
     * @param until the date of the last stock quote
     * @return a list of StockQuote instances.
     * One for each day in the range specified.
     */
    List<StockQuote> getQuote(String symbol, Calendar from,
                              Calendar until, IntervalEnum interval);
}