package com.origamisoftware.teach.advanced.model;


import org.apache.http.annotation.Immutable;

import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is used to a single query to stock service.
 */
@Immutable
public class StockQuery extends StockData{

    private String symbol;
    private Calendar from;
    private Calendar until;
    private IntervalEnum intervalEnum;

    // add a query interval here; used to be in StockService, but kind of makes sense in here too
    public enum IntervalEnum {
        //MINUTE(Calendar.MINUTE),
        //HOUR(Calendar.HOUR_OF_DAY),
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
     * Create a new instance from string data. This constructor will convert
     * dates described as a String to Date objects.
     *
     * @param symbol the stock symbol
     * @param from   the start date as a string in the form of yyyy/MM/dd
     * @param from   the end date as a string in the form of yyyy/MM/dd
     * @param intervalEnum  the interval between stock quotes
     * @throws ParseException if the format of the date String is incorrect. If this happens
     *                        the only recourse is to try again with a correctly formatted String.
     */
    public StockQuery(@NotNull String symbol, @NotNull String from, @NotNull String until, @NotNull IntervalEnum intervalEnum) throws ParseException {
        super();
        this.symbol = symbol;
        this.from = Calendar.getInstance();
        this.until = Calendar.getInstance();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd"); // HH:mm:ss");

        System.out.println(simpleDateFormat);
        // essentially converting mm/dd/yyyy to datetime
        this.from.setTime(simpleDateFormat.parse(from)); // + " 00:00:00"));
        this.until.setTime(simpleDateFormat.parse(until)); //+ " 23:59:59"));
        this.intervalEnum = intervalEnum;
    }

    /**
     * @return get the stock symbol associated with this query
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * @return get the start Calendar associated with this query
     */
    public Calendar getFrom() {
        return from;
    }

    /**
     * @return get the end Calendar associated with this query
     */
    public Calendar getUntil() {
        return until;
    }

    /**
     * @return get the IntervalEnum for the query
     */
    public IntervalEnum getIntervalEnum() {
        return intervalEnum;
    }
}
