package edu.lauracavanaugh.advancedjava.week2;

public class ServiceFactory {

    //private StockService stockService;

    private static final ServiceProvider SERVICE = new ServiceProvider();

    private ServiceFactory() {}

    public static ServiceProvider getService() {
        return SERVICE;
    }
}