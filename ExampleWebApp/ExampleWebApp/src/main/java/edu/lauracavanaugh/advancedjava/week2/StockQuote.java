package edu.lauracavanaugh.advancedjava.week2;

import java.util.Calendar;

/*
This is the simple container class to hold Stock information.
It's just an Object, with properties like "symbol" and "price" and now "date"
 */
public class StockQuote {
    private String symbol;
    private double price;
    private Calendar date;
    // can't seem to call a method even with a param in jstl, so this becomes a property
    private String formattedDate;

    /*
    I guess my StockQuote object must be called with a ServiceFactory,
    to provide the Service which can get the quote from the outside world somehow.
     */
    public StockQuote(){}
    public StockQuote(String symbol) {
        this(symbol,0,Calendar.getInstance());
    }
    public StockQuote(String symbol, double price, Calendar date) {
        this.symbol = symbol;
        this.price = price;
        this.date = date;
        this.formattedDate = getFormattedDate(date);
    }

    public String getSymbol() { return this.symbol; }
    public double getPrice() { return price; }
    public Calendar getDate() { return this.date; }
    public String getFormattedDate() { return this.formattedDate; }
    /*
    JSTL allows only methods with params?
     */
    public String getFormattedDate(Calendar cal) {
        return cal.get(Calendar.YEAR) + "/" + cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.DAY_OF_MONTH) + " " +
                cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND);
    }
    @Override
    public String toString() {
        return "StockQuote: symbol=" + this.symbol + "," + "price=" + this.price + "date=" + this.date;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof StockQuote &&
                ((StockQuote) o).getSymbol().equals(this.symbol) && ((StockQuote) o).getPrice() == this.price
                && ((StockQuote) o).getDate() == this.date;

    }

    @Override
    public int hashCode() {
        return (int) (this.symbol.hashCode() + this.price + this.date.hashCode());
    }
}
