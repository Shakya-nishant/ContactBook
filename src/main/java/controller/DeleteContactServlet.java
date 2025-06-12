package controller;

import model.ContactDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/DeleteContactServlet")
public class DeleteContactServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        if (ContactDAO.deleteContact(id)) {
            response.sendRedirect("ListContactServlet");
        } else {
            response.sendRedirect("ListContactServlet?error=Delete failed");
        }
    }
}