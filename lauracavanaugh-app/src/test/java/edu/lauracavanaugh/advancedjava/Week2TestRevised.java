package edu.lauracavanaugh.advancedjava;

import edu.lauracavanaugh.advancedjava.week2.ServiceFactory;
import edu.lauracavanaugh.advancedjava.week2.ServiceProvider;
import edu.lauracavanaugh.advancedjava.week2.StockQuote;
import junit.framework.TestCase;
import org.mockito.Mockito;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class Week2TestRevised extends TestCase {
    private ServiceProvider mockStockService = ServiceFactory.getService();
    private String mockSymbol = "ORCL";

    public void setup() {
        this.mockStockService = Mockito.mock(ServiceProvider.class);
        when(mockStockService.getQuote(any(String.class))).thenReturn(new StockQuote(mockSymbol));
    }


}
