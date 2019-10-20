package com.origamisoftware.teach.advanced.service;

import com.origamisoftware.teach.advanced.model.Hobby;
import com.origamisoftware.teach.advanced.model.Person;

import java.util.List;

/**
 *
 */
public interface ActivitiesService {

    /**
     * Get a list of all people
     *
     * @return a list of Person instances
     * @throws ActivitiesServiceException if a service can not read or write the requested data
     *                                    or otherwise perform the requested operation.
     */
    List<Person> getPerson() throws ActivitiesServiceException;

    /**
     * Add a new person or update an existing Person's data
     *
     * @param person a person object to either update or create
     * @throws ActivitiesServiceException if a service can not read or write the requested data
     *                                    or otherwise perform the requested operation.
     */
    void addOrUpdatePerson(Person person) throws ActivitiesServiceException;

    /**
     * Get a list of all a person's hobbies.
     *
     * @return a list of hobby instances
     * @throws ActivitiesServiceException if a service can not read or write the requested data
     *                                    or otherwise perform the requested operation.
     */
    List<Hobby> getHobbies(Person person) throws ActivitiesServiceException;

    /**
     * Assign a hobby to a person.
     *
     * @param hobby  The hobby to assign
     * @param person The person to assign the hobby too.
     * @throws ActivitiesServiceException if a service can not read or write the requested data
     *                                    or otherwise perform the requested operation.
     */
    public void addHobbyToPerson(Hobby hobby, Person person) throws ActivitiesServiceException;

}
