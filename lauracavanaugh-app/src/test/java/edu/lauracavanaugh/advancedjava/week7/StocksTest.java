package edu.lauracavanaugh.advancedjava.week7;

import org.junit.Test;

import static org.junit.Assert.*;

public class StocksTest {

    @Test
    public void unmarshalXmlToObject() {

        //Stocks stocks = new Stocks();
        //stocks.unmarshalXmlToObject();
        Stocks stocks = Stocks.unmarshalXmlToObject();
        System.out.println(stocks);
        assertEquals("Stocks.stocks size", stocks.stocks.size(), 49);

    }

    @Test
    public void unmarshalXmlToObjectOtherWay() {
        Stocks stocksOtherWay = Stocks.unmarshalXmlToObjectOtherWay();
        System.out.println(stocksOtherWay);
        assertEquals("Stocks.stocks (other way)", stocksOtherWay.stocks.size(),49);
    }

    @Test
    public void addOrUpdateDatabase() {

        Stocks stocks = Stocks.unmarshalXmlToObject();
        Stocks.addOrUpdateDatabase(stocks);

    }
}