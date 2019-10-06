package edu.lauracavanaugh.advancedjava.week2;

import javax.xml.ws.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class StockApplication {

    /**
     * call the basicstockservice methods
     * @param args
     * Symbol, "02/24/19", "09/04/19"
     * @throws ParseException
     */
     public static void main(String[] args) throws ParseException {


        // get the appropriate calendar objects from the args
        String symbol = args[0];

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

        Calendar calFrom = Calendar.getInstance();
        Calendar calTo = Calendar.getInstance();

        Date dateFrom = dateFormat.parse(args[1]);
        Date dateTo = dateFormat.parse(args[2]);

        calFrom.setTime(dateFrom);
        calTo.setTime(dateTo);

         StockService.IntervalEnum stockInterval = StockService.IntervalEnum.DAY;
         for (StockService.IntervalEnum interval : StockService.IntervalEnum.values()) {
             if (args[3].equals(interval)) {
                stockInterval = interval;
             }
         }

        // call the factory to get the service
         StockService basicStockService = ServiceFactory.getService();

         StockQuote stockQuote = basicStockService.getQuote(symbol);
         List<StockQuote> stockQuotes = basicStockService.getQuote(symbol, calFrom, calTo, stockInterval);
    }
}
