package ru.mobydrake.servlets;

import ru.mobydrake.entities.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Controller", urlPatterns = {"", "/main", "/catalog", "/product", "/order", "/info", "/car"} )
public class Controller extends HttpServlet {

    private List<Product> productList = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        productList.add(new Product(1L, "black pen", "something helpful", 10.2));
        productList.add(new Product(2L, "bread", "something helpful", 3.2));
        productList.add(new Product(3L, "egg", "something helpful", 7.9));
        productList.add(new Product(4L, "milk", "something helpful", 9.2));
        productList.add(new Product(5L, "note", "something helpful", 10.2));
        productList.add(new Product(6L, "razor", "something helpful", 3.5));
        productList.add(new Product(7L, "book", "something helpful", 15.5));
        productList.add(new Product(8L, "red pen", "something helpful", 10.2));
        productList.add(new Product(9L, "blue pen", "something helpful", 10.2));
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
                req.setAttribute("products", productList);
                req.getRequestDispatcher("/WEB-INF/views/catalog.jsp").forward(req, resp);
                break;
            case "/car":
                req.getRequestDispatcher("/WEB-INF/views/catalog.jsp").forward(req, resp);
                break;
            case "/info":
                req.getRequestDispatcher("/WEB-INF/views/info.jsp").forward(req, resp);
                break;
            case "/product":
                req.getRequestDispatcher("/WEB-INF/views/product.jsp").forward(req, resp);
                break;
            case "/order":
                req.getRequestDispatcher("/WEB-INF/views/order.jsp").forward(req, resp);
                break;
        }
    }
}
