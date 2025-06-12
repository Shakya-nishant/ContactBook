package controller;

import model.ContactDAO;
import model.ContactModel;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;



@WebServlet("/ViewContactServlet")
public class ViewContactServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        
        // Retrieve contact from DAO
        ContactModel contact = ContactDAO.getContactById(id);
        
        // Debugging: Print retrieved contact details
        System.out.println("Contact Retrieved: " + contact.getId() + ", " + contact.getName() + ", " + contact.getPhone() + ", " + contact.getEmail() + ", " + contact.getAddress());

        
        // Set contact attribute and forward to JSP
        request.setAttribute("contact", contact);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/view-contact.jsp");
        dispatcher.forward(request, response);

    }
}
