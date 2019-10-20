package com.origamisoftware.teach.advanced.model;

import org.junit.Test;

import java.sql.Timestamp;
import java.util.Calendar;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for Hobby class
 */
public class Stock_PersonTest {


    public  static final Calendar birthDayCalendar = Calendar.getInstance();

    static {
        birthDayCalendar.set(1949, Calendar.AUGUST, 31);
    }

    public static final String firstName = "Richard";
    public static final String lastName = "Gere";
    public static final Timestamp birthDate = new Timestamp(birthDayCalendar.getTimeInMillis());

    /**
     * Testing helper method for generating Person test data
     *
     * @return a Person object that uses static constants for data.
     */
    public static Stocks_Person createPerson() {
        Stocks_Person stocksPerson = new Stocks_Person();
        stocksPerson.setBirthDate(birthDate);
        stocksPerson.setFirstName(firstName);
        stocksPerson.setLastName(lastName);
        return stocksPerson;
    }

    @Test
    public void testPersonGettersAndSetters() {
        Stocks_Person stocksPerson = createPerson();
        int id = 10;
        stocksPerson.setId(id);
        assertEquals("first name matches", firstName, stocksPerson.getFirstName());
        assertEquals("last name matches", lastName, stocksPerson.getLastName());
        assertEquals("birthday matches", birthDate, stocksPerson.getBirthDate());
        assertEquals("id matches", id, stocksPerson.getId());

    }



}
