<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Stock Quotes</title>
</head>
    <body>

        <form name="frmGetStockQuery" action="servlets/StockSearchServlet/" method="post">
            <title>Stock Quote Query</title>
            <p>
                Symbol:
                <select name="symbol">
                    <option>DIS</option>
                    <option>GOOG</option>
                </select>
            </p>
            <p>
                From Date: <input name="from" value="" />
            </p>
            <p>
                To Date: <input name="until" value="" />
            </p>
            <p>
                Interval:
                <select name="interval">
                    <option>5min</option>
                    <option>60min</option>
                </select>
            </p>
            <input type="SUBMIT" value="OK">
            <input type="HIDDEN" name="submit" value="true">
        </form>
    </body>
</html>