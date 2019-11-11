<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--

This example JSP uses JTSL rather than scriplets to access data.

In the MoodSurvey servlet, an instance of a Mood is placed in the http session.

The code on this page gets that instance of out the session and uses'
it values to determine what to display to the user.

--%>

<%-- get the Mood instance out of the session context --%>
<jsp:useBean id="mood" class="com.origami.teach.model.Mood" scope="session">
    <c:set target='${mood}'  value='${sessionScope.get("mood")}'/>
</jsp:useBean>

<html>
<head>
    <title>Mood Response</title>
</head>
<body>

<%--

Now use the mood values to see what message to send to the user
Note the use of c:if which is a JSTL tag the makes it easy to do if statements in
JSP code. There JSTL tags for all common  operations
--%>

Here is the result of call mood.toString() but using JSTL: <br>
<c:out value="${mood}"/>  <%-- out is like using System.out.println - the ouput will go the page --%>
<P>
<c:if test="${mood.happy}">
    I am glad you are happy!
</c:if>
<P>
<c:if test="${mood.sad}">
    I am unhappy you are sad!
</c:if>
<P>
<c:if test="${mood.sad and mood.happy}" >
    I am confused! How you can be both happy and sad at once?
</c:if>


<P>
    Thanks for taking our survey.
</P>

</body>
</html>
