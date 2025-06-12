<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.ContactModel" %>
<html>
<head>
    <title>Edit Contact</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">
</head>
<body>
    <h1>Edit Contact</h1>
    <hr>
    <% ContactModel contact = (ContactModel) request.getAttribute("contact"); %>
    <% if (contact != null) { %>
    <form action="${pageContext.request.contextPath}/EditContactServlet" method="post">
        <input type="hidden" name="id" value="<%= contact.getId() %>">
        Name: <input type="text" name="name" value="<%= contact.getName() %>" required><br><br>
        Phone: <input type="text" name="phone" value="<%= contact.getPhone() %>"><br><br>
        Email: <input type="email" name="email" value="<%= contact.getEmail() %>"><br><br>
        Address: <textarea name="address"><%= contact.getAddress() %></textarea><br><br>
        <input type="submit" value="Update Contact" class="todo-button">
    </form>
    <% } else { %>
    <p style="color: red;">Contact not found!</p>
    <% } %>
    <hr>
    <a href="ListContactServlet" class="todo-button">Back to List</a>
</body>
</html>