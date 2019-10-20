package com.origamisoftware.teach.advanced.model;

import org.junit.Test;

import java.sql.Timestamp;

import static org.junit.Assert.*;

/**
 * Unit test for PersonHobby class
 */
public class Stocks_PersonSymbolTest {

    /**
     * Testing helper method for generating PersonHobby test data
     *
     * @return a PersonHobby object that uses Person and Hobby
     * return from their respective create method.
     */
    public static Stocks_PersonSymbol createPersonSymbol() {
        Stocks_Person person = Stock_PersonTest.createPerson();
        String symbol = "GOOG";
        return new Stocks_PersonSymbol(person, symbol);
    }

    @Test
    public void testPersonSymbolGetterAndSetters() {
        String symbol = "APPL";
        Stocks_Person person = Stock_PersonTest.createPerson();
        Stocks_PersonSymbol personSymbol = new Stocks_PersonSymbol();

        int id = 10;
        personSymbol.setId(id);
        personSymbol.setStocksPerson(person);
        personSymbol.setSymbol(symbol);
        assertEquals("person matches", person, personSymbol.getStocksPerson());
        assertEquals("symbol matches", symbol, personSymbol.getSymbol());
        assertEquals("id matches", id, personSymbol.getId());
    }

    @Test
    public void testEqualsNegativeDifferentPerson() {

        // create regular test stocks_personsymbol
        Stocks_PersonSymbol personSymbol = createPersonSymbol();
        personSymbol.setId(10);

        // create slightly different stocks_person
        Timestamp birthDate = new Timestamp(Stock_PersonTest.birthDayCalendar.getTimeInMillis() + 10000);
        Stocks_Person stocksPerson = new Stocks_Person();
        stocksPerson.setBirthDate(birthDate);
        stocksPerson.setFirstName(Stock_PersonTest.firstName);
        stocksPerson.setLastName(Stock_PersonTest.lastName);

        // create different stocks_personsymbol
        String symbol = "DIS";
        Stocks_PersonSymbol personSymbolDiff = new Stocks_PersonSymbol(stocksPerson, symbol);
        // I wonder if I should set a different id?
        assertFalse("Different stocksPerson", personSymbol.equals(personSymbolDiff));
    }

    @Test
    public void testEquals() {
        Stocks_PersonSymbol personSymbol = createPersonSymbol();
        assertTrue("Same objects are equal", personSymbol.equals(createPersonSymbol()));
    }

    @Test
    public void testToString() {
        Stocks_PersonSymbol personSymbol = createPersonSymbol();
        assertTrue("toString has lastName", personSymbol.toString().contains(Stock_PersonTest.lastName));
        assertTrue("toString has person", personSymbol.toString().contains(Stock_PersonTest.firstName));
        //assertTrue("toString has hobby description", personSymbol.toString().contains(HobbyTest.description));
        assertTrue("toString has symbol name", personSymbol.toString().contains("symbol="+personSymbol.getSymbol()));
        //assertTrue("toString has hobby min age", personSymbol.toString().contains(Integer.toString(HobbyTest.minimumAge)));
    }

}
