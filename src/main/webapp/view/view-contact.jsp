<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.ContactModel" %>
<html>
<head>
    <title>View Contact</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">
</head>
<body>
    <h1>Contact Details</h1>
    <hr>
    <% ContactModel contact = (ContactModel) request.getAttribute("contact"); %>
    <% if (contact != null) { %>
    <table>
        <tr><th>ID:</th><td><%= contact.getId() %></td></tr>
        <tr><th>Name:</th><td><%= contact.getName() %></td></tr>
        <tr><th>Phone:</th><td><%= contact.getPhone() %></td></tr>
        <tr><th>Email:</th><td><%= contact.getEmail() %></td></tr>
        <tr><th>Address:</th><td><%= contact.getAddress() %></td></tr>
    </table>
    <% } else { %>
    <p style="color: red;">Contact not found!</p>
    <% } %>
    <hr>
    <a href="ListContactServlet" class="todo-button">Back to List</a>
</body>
</html>