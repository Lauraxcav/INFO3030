package com.origamisoftware.teach.advanced.services;

import com.origamisoftware.teach.advanced.model.StockQuery;
import com.origamisoftware.teach.advanced.model.StockQuote;
import com.origamisoftware.teach.advanced.util.DatabaseConnectionException;
import com.origamisoftware.teach.advanced.util.DatabaseUtils;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * An implementation of the StockService interface that gets
 * stock data from a database.
 */
public class DatabaseStockService implements StockService {

    /**
     * Return the current price for a share of stock  for the given symbol
     * The current price is assumed to be the most recent in the database, by time,
     * so the query is limited to 1 row, ordered by time, descending
     *
     *
     * @param symbol the stock symbol of the company you want a quote for.
     *               e.g. APPL for APPLE
     * @return a  <CODE>BigDecimal</CODE> instance
     * @throws StockServiceException if using the service generates an exception.
     *                               If this happens, trying the service may work, depending on the actual cause of the
     *                               error.
     */
    @Override
    public StockQuote getQuote(String symbol) throws StockServiceException {
        // todo - this is a pretty lame implementation why?
        // I think it's because it's not using a prepared statemnt - or it could use a sqlproc
        // ALSO, you could get sql injected, if user sends in ""* OR 1=1" or something like that that
        // It needs parameters, as in a prepared statement.  I can do that.
        List<StockQuote> stockQuotes = null;
        try {
            Connection connection = DatabaseUtils.getConnection();
            //Statement statement = connection.createStatement();
            String queryString = "SELECT * FROM quotes WHERE symbol = ? ORDER BY time DESC LIMIT 1";  // + symbol + "'";
            PreparedStatement statement = connection.prepareStatement(queryString);// set the parameters into the statement
            statement.setString(1,symbol);

            ResultSet resultSet = statement.executeQuery(); //queryString);
            stockQuotes = new ArrayList<>(resultSet.getFetchSize());
            while(resultSet.next()) {
                String symbolValue = resultSet.getString("symbol");
                Date time = resultSet.getDate("time");
                BigDecimal price = resultSet.getBigDecimal("price");
                stockQuotes.add(new StockQuote(price, time, symbolValue));
            }

        } catch (DatabaseConnectionException | SQLException exception) {
            throw new StockServiceException(exception.getMessage(), exception);
        }
        if (stockQuotes.isEmpty()) {
            throw new StockServiceException("There is no stock data for:" + symbol);
        }
        return stockQuotes.get(0);
    }

    /**
     * Get a historical list of stock quotes for the provide symbol
     *
     * @param symbol the stock symbol to search for
     * @param from   the date of the first stock quote
     * @param until  the date of the last stock quote
     * @return a list of StockQuote instances
     * @throws   StockServiceException if using the service generates an exception.
     * If this happens, trying the service may work, depending on the actual cause of the
     * error.
     */
    @Override
    public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until, StockQuery.IntervalEnum intervalEnum) throws StockServiceException {
        List<StockQuote> stockQuotes = null;
        try {
            Connection connection = DatabaseUtils.getConnection();
            //Statement statement = connection.createStatement();
            String queryString = "SELECT * FROM quotes WHERE symbol = ?  AND ((? <= time) AND (time <= ?)) ";  // + symbol + "'";
            PreparedStatement statement = connection.prepareStatement(queryString);// set the parameters into the statement
            statement.setString(1,symbol);
            java.sql.Date sqlFrom = new java.sql.Date(from.getTime().getTime());
            java.sql.Date sqlUntil = new java.sql.Date(until.getTime().getTime());
            statement.setDate(2, sqlFrom);
            statement.setDate(3, sqlUntil);

            ResultSet resultSet = statement.executeQuery(); //queryString);
            stockQuotes = new ArrayList<>(resultSet.getFetchSize());
            while(resultSet.next()) {
                String symbolValue = resultSet.getString("symbol");
                Date time = resultSet.getDate("time");
                BigDecimal price = resultSet.getBigDecimal("price");
                stockQuotes.add(new StockQuote(price, time, symbolValue));
            }

        } catch (DatabaseConnectionException | SQLException exception) {
            throw new StockServiceException(exception.getMessage(), exception);
        }
        if (stockQuotes.isEmpty()) {
            throw new StockServiceException("There is no stock data for:" + symbol);
        }
        return stockQuotes;
    }
}
