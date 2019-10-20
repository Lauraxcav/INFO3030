package com.origamisoftware.teach.advanced.services;

import com.origamisoftware.teach.advanced.service.PersonService;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * JUnit test for <CODE>StockServiceFactory</CODE>
 */
public class ServiceFactoryTest {

    @Test
    public void testGetPersonServiceInstance() {
        PersonService personService = ServiceFactory.getPersonServiceInstance();
        assertNotNull(personService);
    }
    @Test
    public void testGetStocksServiceInstance() {
        StockService stockService = ServiceFactory.getStockServiceInstance();
        assertNotNull(stockService);
    }
}
