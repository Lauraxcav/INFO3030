package com.origamisoftware.teach.advanced.services;

import com.origamisoftware.teach.advanced.model.StockQuery;
import com.origamisoftware.teach.advanced.model.StockQuote;
import com.origamisoftware.teach.advanced.service.PersonStockService;
import com.origamisoftware.teach.advanced.service.PersonService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * A factory that returns a <CODE>Service</CODE> instance.
 * This used to be StockServiceFactory, but now it serves up either a PersonService (get a stocks.person or stocks.person_symbols)
 * or a StockService, which uses java.sql to query the database.
 * I think I prefer java.sql - I'm much more familiar with prepared statements and sql params
 *
 */
public class ServiceFactory {

    /**
     * Prevent instantiations
     */
    private ServiceFactory() {}


    public  static PersonService getPersonServiceInstance() {
        return new PersonStockService();
    }

    /**
     *
     * @return get a <CODE>StockService</CODE> instance
     */
    public static StockService getStockServiceInstance() {
        return new StockService() {
            @Override
            public StockQuote getQuote(String symbol) throws StockServiceException {
                return new StockQuote(new BigDecimal(100), Calendar.getInstance().getTime(), symbol);
            }

            @Override
            public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until, StockQuery.IntervalEnum intervalEnum) throws StockServiceException {
                List<StockQuote> stockQuotes = new ArrayList<>();
                Date aDay = from.getTime();
                while (until.after(aDay))  {
                    stockQuotes.add(new StockQuote(new BigDecimal(100),aDay,symbol));
                    from.add(Calendar.DAY_OF_YEAR, 1);
                    aDay = from.getTime();
                }
                return stockQuotes;            }
        };
    }

}
