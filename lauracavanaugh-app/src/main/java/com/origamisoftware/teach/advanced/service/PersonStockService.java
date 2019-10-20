package com.origamisoftware.teach.advanced.service;

import com.origamisoftware.teach.advanced.model.Stocks_Person;
import com.origamisoftware.teach.advanced.model.Stocks_PersonSymbol;
import com.origamisoftware.teach.advanced.util.DatabaseUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * The implementation of PersonService - using hibernate to adapt the tables to the objects Stocks_Person and Stocks_PersonSYmbol
 * @author Laura Cavanaugh
 */
public class PersonStockService implements PersonService {

    /**
     * Get a list of all people
     *
     * @return a list of Person instances
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Stocks_Person> getStocksPerson() throws PersonServiceException
    {
        Session session = DatabaseUtils.getSessionFactory().openSession();
        List<Stocks_Person> returnValue = null;
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(Stocks_Person.class);

            /**
             * NOTE criteria.list(); generates unchecked warning so SuppressWarnings
             * is used - HOWEVER, this about the only @SuppressWarnings I think it is OK
             * to suppress them - in almost all other cases they should be fixed not suppressed
             */
            returnValue = criteria.list();

        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
            throw new PersonServiceException("Could not get stocks_person data. " + e.getMessage(), e);
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
        }

        return returnValue;

    }

    public List<String> getStockPersonSymbols(Stocks_Person stocksPerson) throws PersonServiceException {
        Session session =  DatabaseUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        List<String> personSymbols = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(Stocks_PersonSymbol.class);
            criteria.add(Restrictions.eq("stocksPerson", stocksPerson));
            /**
             * NOTE criteria.list(); generates unchecked warning so SuppressWarnings
             * is used - HOWEVER, this about the only @SuppressWarnings I think it is OK
             * to suppress them - in almost all other cases they should be fixed not suppressed
             */
            List<Stocks_PersonSymbol> list = criteria.list();
            for (Stocks_PersonSymbol stocksPersonSymbol : list) {
                personSymbols.add(stocksPersonSymbol.getSymbol());
            }
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
        }
        return personSymbols;
    }
}
