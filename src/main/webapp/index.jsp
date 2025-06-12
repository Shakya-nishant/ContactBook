<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contact Book</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">
</head>
<body>
    <h1>Contact Book</h1>
    <hr>
    <div class="button-container">
        <a href="ListContactServlet" class="todo-button">Contact List</a>
        <a href="${pageContext.request.contextPath}/view/add-contact.jsp" class="todo-button">Add Contact</a>
    </div>
    <hr>
</body>
</html>