package com.origamisoftware.teach.advanced.service;

import com.origamisoftware.teach.advanced.model.Stocks_Person;

import java.util.List;

/**
 * a service that defines two methods to get data fromt he Stocks_PErson and Stocks_PersonSymbol tables
 * @author Laura Cavanaugh
 */
public interface PersonService {
    /**
     * Get a list of all people
     *
     * @return a list of Person instances
     * @throws PersonServiceException if a service can not read or write the requested data
     *                                    or otherwise perform the requested operation.
     */
     List<Stocks_Person> getStocksPerson() throws PersonServiceException;

    /**
     * Get a list of all a person's hobbies.
     *
     * @return a list of stock symbols
     * @throws PersonServiceException if a service can not read or write the requested data
     *                                    or otherwise perform the requested operation.
     */
    List<String> getStockPersonSymbols(Stocks_Person stocksPerson) throws PersonServiceException;



}

