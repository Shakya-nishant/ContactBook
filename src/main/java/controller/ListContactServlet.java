package controller;

import model.ContactDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;


@WebServlet("/ListContactServlet")
public class ListContactServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("contacts", ContactDAO.getAllContacts());
        request.getRequestDispatcher("/view/list-contact.jsp").forward(request, response);    }
}