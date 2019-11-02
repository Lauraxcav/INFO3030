package edu.lauracavanaugh.advancedjava.week7.services;


import com.origamisoftware.teach.advanced.util.DatabaseUtils;
import edu.lauracavanaugh.advancedjava.week7.model.Stocks_Quotes;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


/**
 *
 */
public class StocksQuotesService implements StockORMService {

    /**
     * Add a new quote or update an existing quote
     * @param quote a quote object to either update or create
     */
    @Override
    public void addOrUpdateQuote(Stocks_Quotes quote) {

        Session session = DatabaseUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(quote);
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
    }


}
