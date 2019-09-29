package edu.lauracavanaugh.advancedjava.week2;

/**
 * Factory to return StockService.
 * This is supposed to be
 * "a factory class that returns an implementation of that interface"
 */
public class ServiceFactory {

    // what if there are lots of types of services available and we want to be able to use more than one?
    private BasicStockService anyService = new BasicStockService();

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
        return SERVICE;
    }

    public BasicStockService getAnyService(String serviceName) {
        // there would be if statements here to return the correct type of service
        /*
        if servicename="yahoo" return YahooService();
        if servicename="google" return GoogleService();
        etc.
         */
        return anyService;
    }
}