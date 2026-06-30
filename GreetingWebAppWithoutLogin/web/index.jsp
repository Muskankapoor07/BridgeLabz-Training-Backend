<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Greeting App</title>
</head>
<body>
<h2>Enter Your Name</h2>

<form action="greet" method="post">
    <input type="text" name="userName" required />
    <button type="submit">Get Greeting</button>
</form>
</body>
</html>