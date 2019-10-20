package com.origamisoftware.teach.advanced.service;

/**
 * A factory that returns a <CODE>ActivitiesService</CODE> instance.
 */
public class ActivitiesServiceFactory {

    /**
     * Prevent instantiations
     */
    private ActivitiesServiceFactory() {}

    /**
     *
     * @return get a <CODE>StockService</CODE> instance
     */
    public static ActivitiesService getInstance() {
        return new DatabaseActivitiesService();
    }

}
