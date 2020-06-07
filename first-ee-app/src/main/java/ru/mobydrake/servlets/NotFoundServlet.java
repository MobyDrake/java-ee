package ru.mobydrake.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Error404", urlPatterns = "/error404")
public class NotFoundServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<h1>Ops, we can't find this!</h1>");
        resp.getWriter().println("<h3>404</h3>");

        getServletContext().getRequestDispatcher("/menu").include(req, resp);
    }
}
