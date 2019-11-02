package edu.lauracavanaugh.advancedjava.week7.services;

import edu.lauracavanaugh.advancedjava.week7.model.Stocks_Quotes;

/**
 * The ORM model to set objects into the database
 */
public interface StockORMService {

    void addOrUpdateQuote(Stocks_Quotes quote);
}
