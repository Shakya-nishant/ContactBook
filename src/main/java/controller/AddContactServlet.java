package controller;

import model.ContactModel;
import model.ContactDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/AddContactServlet")
public class AddContactServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ContactModel contact = new ContactModel(
            request.getParameter("name"),
            request.getParameter("phone"),
            request.getParameter("email"),
            request.getParameter("address")
        );
        
        try {
            if (ContactDAO.addContact(contact) != -1) {
                response.sendRedirect("ListContactServlet");
            } else {
                response.sendRedirect("view/add-contact.jsp?error=Failed to add contact");
            }
        } catch (SQLException e) {
            response.sendRedirect("view/add-contact.jsp?error=Database error");
        }
    }
}