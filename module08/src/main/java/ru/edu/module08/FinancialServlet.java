package ru.edu.module08;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Hello world!
 *
 */
@WebServlet("/finance")
public class FinancialServlet extends HttpServlet{


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/finance.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String sum = req.getParameter("sum");
        String percentage = req.getParameter("percentage");
        String years = req.getParameter("years");
        int res = 0;
        int percent = 0;
        int year = 0;

        PrintWriter out = resp.getWriter();

        try {
            res = Integer.parseInt(sum);
            percent = Integer.parseInt(percentage);
            year = Integer.parseInt(years);

            out.write("<html>");
            out.write("<body>");
            for (int i = 1; i <= year; i++) {
                res += res * percent / 100;
            }
            out.write("<h1>Результат</h1>");
            out.write("Итоговая сумма = " + res);
            out.write("</body>");
            out.write("</html>");
        }
        catch (NumberFormatException ex) {
            out.write("<html>");
            out.write("<body>");
            out.write("<h1>Результат</h1>");
            out.write("<br>");
            out.write("Значения должны быть только цифровые! ");
            out.write("Иные символы не допускаются!");
            out.write("</body>");
            out.write("</html>");
        }
    }
}
