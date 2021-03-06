package edu.lauracavanaugh.advancedjava.week2;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
This is the StockService interface that we had to write
 */
public interface StockService {

    /**
     * How often to poll a stock quote
     * Poll each minute, each hour, or each day
     */
    public enum IntervalEnum {
        MINUTE(Calendar.MINUTE),
        HOUR(Calendar.HOUR_OF_DAY),
        DAY(Calendar.DAY_OF_YEAR),
        WEEK(Calendar.WEEK_OF_YEAR),
        YEAR(Calendar.YEAR);

        private final int value;
        private static Map<Integer, IntervalEnum> map = new HashMap<Integer, IntervalEnum>();

        static {
            for (IntervalEnum intervalEnum : IntervalEnum.values()) {
                map.put(intervalEnum.value, intervalEnum);
            }
        }
        private IntervalEnum(int calendarEnum) {
            this.value = calendarEnum;
        }

        // convert int to IntervalEnum
        public static IntervalEnum valueOf(int intervalEnum) {
            return map.get(intervalEnum);
        }

        // convert IntervalEnum to int
        public int getValue() {
            return value;
        }
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