package ru.mobydrake.servlets;

import ru.mobydrake.entities.Product;
import ru.mobydrake.repository.ProductRepository;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Controller", urlPatterns = {"", "/main", "/catalog", "/product", "/order", "/info", "/car"} )
public class Controller extends HttpServlet {

    @Inject
    private ProductRepository productRepository;

    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        switch (req.getServletPath()) {
            case "/":
            case "/main":
                req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
                break;
            case "/catalog":
                req.getRequestDispatcher("/WEB-INF/views/catalog.xhtml").forward(req, resp);
                break;
            case "/car":
                req.getRequestDispatcher("/WEB-INF/views/catalog.jsp").forward(req, resp);
                break;
            case "/info":
                req.getRequestDispatcher("/WEB-INF/views/info.jsp").forward(req, resp);
                break;
            case "/product":
                req.getRequestDispatcher("/WEB-INF/views/product.xhtml").forward(req, resp);
                break;
            case "/order":
                req.getRequestDispatcher("/WEB-INF/views/order.jsp").forward(req, resp);
                break;
        }
    }
}
