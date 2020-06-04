package ru.mobydrake.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MenuServlet", urlPatterns = "/menu")
public class MenuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<a href= '/first-ee-app/main'>main</a>");
        resp.getWriter().println("<a href= '/first-ee-app/product'>product</a>");
        resp.getWriter().println("<a href= '/first-ee-app/catalog'>catalog</a>");
        resp.getWriter().println("<a href= '/first-ee-app/cart'>cart</a>");
        resp.getWriter().println("<a href= '/first-ee-app/order'>order</a>");
    }
}
