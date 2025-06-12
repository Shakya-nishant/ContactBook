package controller;

import model.ContactDAO;
import model.ContactModel;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/EditContactServlet")
public class EditContactServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ContactModel contact = ContactDAO.getContactById(id);
        
        if (contact != null) {
            request.setAttribute("contact", contact);
            request.getRequestDispatcher("/view/edit-contact.jsp").forward(request, response);
        } else {
            response.sendRedirect("ListContactServlet?error=Contact not found");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ContactModel contact = new ContactModel(
            id,
            request.getParameter("name"),
            request.getParameter("phone"),
            request.getParameter("email"),
            request.getParameter("address")
        );
        
        try {
            if (ContactDAO.updateContact(contact)) {
                response.sendRedirect("ListContactServlet?success=Contact updated successfully");
            } else {
                response.sendRedirect("EditContactServlet?id=" + id + "&error=Failed to update contact");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("EditContactServlet?id=" + id + "&error=Database error");
        }
    }
}