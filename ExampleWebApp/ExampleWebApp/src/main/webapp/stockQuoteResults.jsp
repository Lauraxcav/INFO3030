<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="quote" class="edu.lauracavanaugh.advancedjava.week2.StockQuote" scope="session"/>
<jsp:setProperty name="quote" property="*" />


<body>
<html>
    <head>
        <title>Your Stock Results via not jstl!</title>
    </head>
    <body>
        <table>
            <thead>
                <th>Symbol</th>
                <th>Price</th>
                <th>Date-Time</th>
            </thead>
            <tbody>
                <td><%= quote.getSymbol() %></td>
                <td><%= quote.getPrice() %></td>
                <td><%= quote.getDate() %></td>
            </tbody>
        </table>

    </body>
</html>