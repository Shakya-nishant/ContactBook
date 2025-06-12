<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, model.ContactModel" %>
<html>
<head>
    <title>Contact List</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">
</head>
<body>
    <h1>Contact List</h1>
    <hr>
    <table>
        <tr>
            <th>Name</th>
            <th>Actions</th>
        </tr>
        <% for (ContactModel contact : (List<ContactModel>) request.getAttribute("contacts")) { %>
        <tr>
            <td><%= contact.getName() %></td>
            <td>
                <a href="EditContactServlet?id=<%= contact.getId() %>" class="todo-button">Edit</a>
                <a href="ViewContactServlet?id=<%= contact.getId() %>" class="todo-button">View</a>
                <a href="DeleteContactServlet?id=<%= contact.getId() %>" class="todo-button">Delete</a>
            </td>
        </tr>
        <% } %>
    </table>
    <hr>
    <a href="${pageContext.request.contextPath}/index.jsp" class="todo-button">Back to Home</a>
</body>
</html>