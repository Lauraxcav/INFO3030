package edu.lauracavanaugh.advancedjava.week2;

public class ServiceProvider implements StockService {

    private StockQuote stockQuote;

    public ServiceProvider() { }

     public StockQuote getQuote(String symbol) {
        return this.stockQuote;
    }
}
