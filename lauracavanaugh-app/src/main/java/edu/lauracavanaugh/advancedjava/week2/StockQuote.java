package edu.lauracavanaugh.advancedjava.week2;

public class StockQuote {
    private String symbol;
    private double price;

    public StockQuote(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "StockQuote: symbol=" + this.symbol + "," + "price=" + this.price;
    }

    @Override
    public boolean equals(Object o) {

        return o instanceof StockQuote &&
                ((StockQuote) o).getSymbol().equals(this.symbol) &&
                ((StockQuote) o).getPrice() == this.price;
    }

    @Override
    public int hashCode() {
        return (int) (this.symbol.hashCode() + this.price);
    }
}
