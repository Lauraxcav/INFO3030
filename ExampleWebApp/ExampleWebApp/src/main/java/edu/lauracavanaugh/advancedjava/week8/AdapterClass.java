package edu.lauracavanaugh.advancedjava.week8;

import edu.lauracavanaugh.advancedjava.week2.StockQuote;
import edu.lauracavanaugh.advancedjava.week2.StockService;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import java.text.SimpleDateFormat;
import java.util.*;

/// For lack of a better name
public class AdapterClass implements StockService {

    private AlphaVantageService alphaVantageService;

    public AdapterClass(AlphaVantageService alphaVantageService) {
        this.alphaVantageService = alphaVantageService;
    }

    public StockQuote getQuote(String symbol) {
        StockQuote stockQuote = null;

        try {
            String json = alphaVantageService.getIntraday(symbol, IntervalEnum.FIVE_MIN.getValue());
            System.out.println(json);

            Object obj = new org.json.simple.parser.JSONParser().parse(json);
             JSONObject jsonObject = (JSONObject) obj;
            Map timeSeries = ((Map)jsonObject.get("Time Series (5min)"));

            Iterator<Map.Entry> itr = timeSeries.entrySet().iterator();
            //while (itr.hasNext()) {
            itr.next();
                Map.Entry pair = itr.next();
                String dateTime = (String) pair.getKey();
                /**
                String dateTimeValues = (String) pair.getValue();

                Object objDateTime = new JSONParser().parse(dateTimeValues);
                JSONObject jsonDateTime = (JSONObject) objDateTime;
                String closePrice = (String) jsonDateTime.get("4. close");
                 **/
                Object objValues = pair.getValue();
                JSONObject jsonValues = (JSONObject) objValues;
                String closePrice = (String) jsonValues.get("4. close");

            //}

            double price = new Double(closePrice);

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
            Calendar cal = Calendar.getInstance();
            Date date = dateFormat.parse(dateTime);
            cal.setTime(date);

           stockQuote = new StockQuote(symbol,price,cal);

        } catch (ParseException | java.text.ParseException e) {
            e.printStackTrace();
        }

        return stockQuote;
    }

    @Override
    public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until, IntervalEnum interval) {

        List<StockQuote> stockQuotes = new ArrayList<>();

        try {
            String json = alphaVantageService.getIntraday(symbol, interval.getValue());
            System.out.println(json);

            Object obj = new org.json.simple.parser.JSONParser().parse(json);
            JSONObject jsonObject = (JSONObject) obj;
            Map timeSeries = ((Map) jsonObject.get("Time Series (5min)"));

            Iterator<Map.Entry> itr = timeSeries.entrySet().iterator();
            while (itr.hasNext()) {
                //itr.next();
                Map.Entry pair = itr.next();
                String dateTime = (String) pair.getKey();
                /**
                 String dateTimeValues = (String) pair.getValue();

                 Object objDateTime = new JSONParser().parse(dateTimeValues);
                 JSONObject jsonDateTime = (JSONObject) objDateTime;
                 String closePrice = (String) jsonDateTime.get("4. close");
                 **/
                Object objValues = pair.getValue();
                JSONObject jsonValues = (JSONObject) objValues;
                String closePrice = (String) jsonValues.get("4. close");

                double price = new Double(closePrice);

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
                Calendar cal = Calendar.getInstance();
                Date date = dateFormat.parse(dateTime);
                cal.setTime(date);

                StockQuote stockQuote = new StockQuote(symbol, price, cal);
                stockQuotes.add(stockQuote);
            }

        } catch (ParseException | java.text.ParseException e) {
            e.printStackTrace();
        }

        return stockQuotes;
    }

}

