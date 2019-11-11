<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="person" class="com.origami.teach.model.Person" scope="request"/>
<jsp:setProperty name="person" property="*" />
<html>
<head>
    <title><%= person.getFirstName() %></title>
</head>
<body>

Yo, <%= person.getFirstName() %>

</body>
</html>
