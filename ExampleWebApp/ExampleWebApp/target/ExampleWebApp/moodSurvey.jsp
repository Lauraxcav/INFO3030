<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Mood Survey</title>
</head>
<body>


How are you feeling? <br>

<P></P>

<form name="myform" action="servlets/ServletForwardingExample/" method="post">
    Are you happy?  <input type="checkbox" name="happy" title="happy">
                       <br>
    Are you sad?  <input type="checkbox" name="sad" title="sad" >
    <br>
    <input type="SUBMIT" value="OK">
    <input type="HIDDEN" name="submit" value="true">
</form>
</body>
</html>
