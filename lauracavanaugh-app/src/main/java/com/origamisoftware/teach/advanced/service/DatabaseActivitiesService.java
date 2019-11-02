package com.origamisoftware.teach.advanced.service;

import com.origamisoftware.teach.advanced.model.Hobby;
import com.origamisoftware.teach.advanced.model.Person;
import com.origamisoftware.teach.advanced.model.PersonHobby;
import com.origamisoftware.teach.advanced.util.DatabaseUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class DatabaseActivitiesService implements ActivitiesService {

    /**
     * Get a list of all people
     *
     * @return a list of Person instances
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Person> getPerson() throws ActivitiesServiceException{
        Session session = DatabaseUtils.getSessionFactory().openSession();
        List<Person> returnValue = null;
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(Person.class);

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
            throw new ActivitiesServiceException("Could not get Person data. " + e.getMessage(), e);
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
        }

        return returnValue;

    }

    /**
     * Add a new person or update an existing Person's data
     *
     * @param person a person object to either update or create
     */
    @Override
    public void addOrUpdatePerson(Person person) {
        Session session = DatabaseUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(person);
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

    /**
     * Get a list of all a person's hobbies.
     *
     * @param person the person
     * @return a list of hobby instances
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Hobby> getHobbies(Person person) {
        Session session =  DatabaseUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        List<Hobby> hobbies = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(PersonHobby.class);
            criteria.add(Restrictions.eq("person", person));
            /**
             * NOTE criteria.list(); generates unchecked warning so SuppressWarnings
             * is used - HOWEVER, this about the only @SuppressWarnings I think it is OK
             * to suppress them - in almost all other cases they should be fixed not suppressed
             */
            List<PersonHobby> list = criteria.list();
            for (PersonHobby personHobby : list) {
                hobbies.add(personHobby.getHobby());
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
        return hobbies;

    }

    /**
     * Assign a hobby to a person.
     *
     * @param hobby  The hobby to assign
     * @param person The person to assign the hobby too.
     */
    @Override
    public void addHobbyToPerson(Hobby hobby, Person person) {
        Session session =  DatabaseUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            PersonHobby personHobby = new PersonHobby();
            personHobby.setHobby(hobby);
            personHobby.setPerson(person);
            session.saveOrUpdate(personHobby);
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
