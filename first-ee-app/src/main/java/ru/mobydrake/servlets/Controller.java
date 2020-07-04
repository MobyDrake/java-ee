package ru.mobydrake.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.mobydrake.repository.ProductRepository;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Controller", urlPatterns = {"", "/main", "/catalog", "/product", "/order", "/category", "/car"} )
public class Controller extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(Controller.class);

    @Inject
    private ProductRepository productRepository;

    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        switch (req.getServletPath()) {
            case "/":
                req.getRequestDispatcher("/index.xhtml").forward(req, resp);
                break;
            case "/product":
                getServletContext().getRequestDispatcher("/product.xhtml").forward(req, resp);
                break;
            case "/category":
                getServletContext().getRequestDispatcher("/category_all.xhtml").forward(req, resp);
                break;
        }
    }
}
