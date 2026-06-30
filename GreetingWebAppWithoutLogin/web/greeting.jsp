<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.greet.model.Greeting" %>

<html>
<head>
    <title>Greeting Result</title>
</head>
<body>

<%
    Greeting greeting = (Greeting) request.getAttribute("greeting");
%>

<h2><%= greeting.getMessage() %></h2>

<a href="index.jsp">Go Back</a>

</body>
</html>