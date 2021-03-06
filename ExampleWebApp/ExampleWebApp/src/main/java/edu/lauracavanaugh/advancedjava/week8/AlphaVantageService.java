package edu.lauracavanaugh.advancedjava.week8;

import edu.lauracavanaugh.advancedjava.week2.StockService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * This class knows how to go out to web to get some quotes
 */
public class AlphaVantageService  {

    private static final String API_KEY = "8DCMOVO5MZMVE50Z";
    //https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=DIS&interval=60min&apikey=8DCMOVO5MZMVE50Z
    private static final String host = "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY";

    public String getIntraday(String symbol, String interval) {

        String json = null;

        try {
            //https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=DIS&interval=60min&apikey=8DCMOVO5MZMVE50Z
            String alphaRequest = host + "&symbol=" + symbol + "&interval=" + interval + "&apikey=" + API_KEY;
            URL url = new URL(alphaRequest);
            HttpURLConnection cx = (HttpURLConnection) url.openConnection();
            cx.setRequestMethod("GET");
            cx.setRequestProperty("Content-Type","application/json");
            int status = cx.getResponseCode();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(cx.getInputStream())
            );
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null ) {
                content.append(inputLine);
            }
            in.close();

            cx.disconnect();
            json = content.toString();


        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;

}

    private String convertIntervalToAlpha(StockService.IntervalEnum interval) {
        return "5min";
    }

    private void getQuotesFromJson() {



    }
}
