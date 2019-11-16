package com.origami.teach.servlet;

import com.origami.teach.model.Mood;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Simple Example of how a servlet can access form submission data
 * and act on it accordingly.
 */
public class MoodSurvey extends HttpServlet {

    private static final String SAD_PARAMETER_KEY = "sad";
    private static final String HAPPY_PARAMETER_KEY = "happy";
    private static final String CHECK_BOX_IS_CHECKED_VALUE = "on";

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {


        String sad = request.getParameter(SAD_PARAMETER_KEY);
        String happy = request.getParameter(HAPPY_PARAMETER_KEY);
        boolean isSad = false;

        // happy and sad will be null, if not se to 'on' when selected.
        if (sad!= null && sad.equals(CHECK_BOX_IS_CHECKED_VALUE)) {
            isSad = true;
        }

        Boolean isHappy = false;
        if (happy!= null && happy.equals(CHECK_BOX_IS_CHECKED_VALUE)) {
            isHappy = true;
        }
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
        Mood mood = new Mood(isHappy, isSad);
        session.setAttribute("mood", mood);

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
                servletContext.getRequestDispatcher("/moodResponse.jsp");
        dispatcher.forward(request, response);

    }
}
