package com.origamisoftware.teach.advanced.services;

import com.origamisoftware.teach.advanced.model.*;
import com.origamisoftware.teach.advanced.service.*;
import com.origamisoftware.teach.advanced.util.DatabaseUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Unit tests for the DatabaseStocksService
 */
public class PersonStockServiceTest {

    private PersonService personService;

    /**
     * this sets up the stocks.person and stocks.person_symbol tables
     * @throws Exception
     */
    private void initDb() throws Exception {
        DatabaseUtils.initializeDatabase(DatabaseUtils.initializationFile);
    }

    // do not assume db is correct
    @Before
    public void setUp() throws Exception {
        // we could also copy db state here for later restore before initializing
        initDb();
        personService = ServiceFactory.getPersonServiceInstance();
    }

    // clean up after ourselves. (this could also restore db from initial state
    @After
    public void tearDown() throws Exception {
        initDb();
    }

    @Test
    public void testGetInstance() {
        assertNotNull("Make sure personService is available", personService);
    }

    @Test
    public void testGetPerson() throws Exception {
        personService = ServiceFactory.getPersonServiceInstance();
        List<Stocks_Person> personList = personService.getStocksPerson();
        assertFalse("Make sure we get some Person objects from service", personList.isEmpty());
    }



    @Test
    public void testGetSymbolsByPerson() throws PersonServiceException {

        // get each person in the stocks_person table
        List<Stocks_Person> personList = personService.getStocksPerson();

         for (Stocks_Person stocksPerson : personList) {
            List<String> personSymbols = personService.getStockPersonSymbols(stocksPerson);

            assertTrue("person_symbols is >0", personSymbols.size()>0);
            // now I have the symbols for each person!
            for (String symbol : personSymbols) {
                assertTrue("symbol is one of these","APPL GOOG DIS AMZN".contains(symbol) );

            }
        }

    }


}
