<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<jsp:useBean id="person" class="com.origami.teach.model.Person" scope="request"/>
<jsp:setProperty name="person" property="*"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Simple, Yet Exciting, Form Example</title>

</head>
<body>

<h2>
    Please introduce yourself: <br>
</h2>

<P></P>

<form name="myform" action="formExampleNextPage.jsp" method="post">
    First Name : <input type="text" name="firstName"
                        value='<%= person.getFirstName() == null ? "" : person.getFirstName() %>'><br>
    Last Name : <input type="text" name="lastName"
                       value='<%= person.getLastName()== null ? "" : person.getLastName() %>'><br>
    <input type="SUBMIT" value="OK">
    <input type="HIDDEN" name="submit" value="true">
</form>

</body>
</html>