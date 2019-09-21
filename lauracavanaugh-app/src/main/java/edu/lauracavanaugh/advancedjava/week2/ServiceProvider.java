package edu.lauracavanaugh.advancedjava.week2;

public class ServiceProvider implements StockService {

    private StockQuote stockQuote;

    public ServiceProvider(String symbol, double price) {
        this.stockQuote = new StockQuote(symbol, price);
    }

     public StockQuote getQuote(String symbol) {
        return this.stockQuote;
    }
}
