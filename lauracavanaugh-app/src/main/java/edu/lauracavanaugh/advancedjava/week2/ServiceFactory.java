package edu.lauracavanaugh.advancedjava.week2;

import edu.lauracavanaugh.advancedjava.week8.AdapterClass;
import edu.lauracavanaugh.advancedjava.week8.AlphaVantageService;
import jdk.nashorn.internal.ir.annotations.Immutable;

/**
 * Factory to return StockService.
 * This is supposed to be
 * "a factory class that returns an implementation of that interface"
 */
@Immutable
public class ServiceFactory {


    /*
    To keep programmer from constructing a new Service
     */
    private ServiceFactory() {}

    /*
    This is the factory method, getService()
     */
    public static StockService getService() {
        // In here we can decide which service to return
        // but for now, we're returning a BasicStockService
        //return new BasicStockService();
        return new BasicStockService();
    }

    public static StockService getStockServiceInstance() {
        return new AdapterClass(new AlphaVantageService());
    }


}