<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="quote" class="edu.lauracavanaugh.advancedjava.week2.StockQuote" scope="session">
    <c:set target='${quote}' value='${sessionScope.get("quote")}' />
</jsp:useBean>
<jsp:useBean id="quotes" class="java.util.ArrayList" scope="session">
    <c:set target='${quotes}' value='${sessionScope.get("quotes")}' />
</jsp:useBean>

<html>
    <head>
        <title>Your Stock Results via jstl!</title>
    </head>
    <body>
        <table>
            <thead>
                <th>Symbol</th>
                <th>Price</th>
                <th>Date-Time</th>
            </thead>
             <tbody>
                <c:forEach var="quote" items="${sessionScope.quotes}">
                  <tr>
                    <td><c:out value="${quote.symbol}" /></td>
                    <td><c:out value="${quote.price}" /></td>
                    <td><c:out value="${quote.formattedDate}" /></td>
                  </tr>
                </c:forEach>
             </tbody>
        </table>

    </body>
</html>