<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Contact</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">
</head>
<body>
    <h1>Add New Contact</h1>
    <hr>
    <form action="${pageContext.request.contextPath}/AddContactServlet" method="post">
        Name: <input type="text" name="name" required><br><br>
        Phone: <input type="text" name="phone"><br><br>
        Email: <input type="email" name="email"><br><br>
        Address: <textarea name="address"></textarea><br><br>
        <input type="submit" value="Add Contact" class="todo-button">
    </form>
    <hr>
    <a href="${pageContext.request.contextPath}/index.jsp" class="todo-button">Back to Home</a>
</body>
</html>