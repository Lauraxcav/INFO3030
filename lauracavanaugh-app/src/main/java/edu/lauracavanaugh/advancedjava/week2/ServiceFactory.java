package edu.lauracavanaugh.advancedjava.week2;

import jdk.nashorn.internal.ir.annotations.Immutable;

/**
 * Factory to return StockService.
 * This is supposed to be
 * "a factory class that returns an implementation of that interface"
 */
@Immutable
public class ServiceFactory {


    // use this if there's only one type of service.  I think.
    private static final BasicStockService SERVICE = new BasicStockService();

    /*
    To keep programmer from constructing a new Service
     */
    private ServiceFactory() {}

    /*
    This is the factory method, getService()
     */
    public static BasicStockService getService() {
        // In here we can decide which service to return
        // but for now, we're returning a BasicStockService
        //return new BasicStockService();
        return SERVICE;
    }


}