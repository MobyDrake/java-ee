package ru.mobydrake.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/calc")
public class Calc extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        int oper = Integer.parseInt(req.getParameter("oper"));
        double val1 = Double.parseDouble(req.getParameter("firstNum"));
        double val2 = Double.parseDouble(req.getParameter("secondNum"));
        double result = 0;
        switch(oper){
            case 1: result = val1 + val2;
                break;
            case 2: result = val1 - val2;
                break;
            case 3: result = val1 / val2;
                break;
            case 4: result = val1 * val2;
                break;
        }
        PrintWriter out = resp.getWriter();
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Calc</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Результаты расчетов</h2>");
            out.println("<div>Число №1 = "+val1+" </div>");
            out.println("<div>Число №2 = "+val2+" </div>");
            out.println("<div>Ответ = "+result+" </div>");
            out.println("<div><a href='calculator.jsp'>Вернуться на страницу с калькулятором</div>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
}
