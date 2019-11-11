package edu.lauracavanaugh.advancedjava.week9;


import edu.lauracavanaugh.advancedjava.week2.ServiceFactory;
import edu.lauracavanaugh.advancedjava.week2.StockQuote;
import edu.lauracavanaugh.advancedjava.week2.StockService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

/**
 * Simple Example of how a servlet can access form submission data
 * and act on it accordingly.
 */
public class StockSearchServlet extends HttpServlet {

    private static final String SYMBOL_PARAM = "symbol";
    private static final String FROM_DATE_PARAM = "from";
    private static final String TO_DATE_PARAM = "until";
    private static final String INTERVAL_PARAM = "interval";

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {


        String symbol = request.getParameter(SYMBOL_PARAM);
        String fromDate = request.getParameter(FROM_DATE_PARAM);
        String untilDate = request.getParameter(TO_DATE_PARAM);
        String interval = request.getParameter(INTERVAL_PARAM);


       HttpSession session = request.getSession();

         /* Here is where use put an instance of Mood in the session.
          * The HTTP session contains a Map (it stores key value pairs)
          * You can put anything you like in that map.
          * When the session terminates the map goes away.
          *
          * You can also store key / values in the request.
          * However, those values will only be around for the duration of the
          * request and not the entire session.
          *
          */
        //Mood mood = new Mood(isHappy, isSad);
        //session.setAttribute("mood", mood);
        StockService service = ServiceFactory.getStockServiceInstance();

        // I don't actually use the calendar or the interval
        // this defaults to the last opening day, and a 5min interval
        // The actual functionality would be done "the next work day", or in version 1.2 (or 1.5 or whatever)
        List<StockQuote> stockQuotes = service.getQuote(
                symbol, Calendar.getInstance(), Calendar.getInstance(), StockService.IntervalEnum.enumValueOf(interval));
        session.setAttribute("quotes",stockQuotes);

        StockQuote quote = service.getQuote(symbol);
        session.setAttribute("quote", quote);

        /**
        for (StockQuote q : stockQuotes) {
            q.getDate();
            q.getPrice();
            q.getSymbol();


        }
         */
        /* here is how a servlet can 'forward' to a specific JSP page
         * NOTE: you could easily have conditional code here that
         * directed to different pages based on values or business rules
         * related to the data this servlet is processing.
         *
         * e.g

          RequestDispatcher dispatcher;
          if (mood.getHappy()) {
             dispatcher = getServletContext().getRequestDispatcher("/goodMood.jsp");
          } else if (mood.getSad()) {
             dispatcher = getServletContext().getRequestDispatcher("/sadMood.jsp");
          } else {
             dispatcher = getServletContext().getRequestDispatcher("/confusedMood.jsp");
          }

         * However, in this example we only dispatch to one place the moodResponse.jsp page
         *
         */

        ServletContext servletContext = getServletContext();
        RequestDispatcher dispatcher =
                servletContext.getRequestDispatcher("/stockQuoteResults_jstl.jsp");
        dispatcher.forward(request, response);

    }
}
