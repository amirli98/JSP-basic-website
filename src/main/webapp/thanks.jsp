<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 1/4/2021
  Time: 6:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fazil's Java Servlets and JSP</title>
    <link rel="stylesheet" href="styles/main.css">
</head>
<body>
<h1>Thanks for joining our email list</h1>
<p>Here is the information that you entered</p><br>
<label>Email:</label><span>${user.email}</span><br>
<label>First Name:</label><span>${user.firstName}</span><br>
<label>Last Name:</label><span>${user.lastName}</span><br>
<p>To enter another email address,click ont the Back button in your browser or the Return button shown below</p>
<form action="" method="get">
    <input type="hidden" name="action" value="join">
    <input type="submit" value="Return">
</form>
</body>
</html>
