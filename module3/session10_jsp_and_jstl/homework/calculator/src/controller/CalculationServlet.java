package controller;

import model.Calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculationServlet", urlPatterns = "/calculator.jsp")
public class CalculationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstOperand = request.getParameter("firstOperand");
        String secondOperand = request.getParameter("secondOperand");
        String operator = request.getParameter("operator");

        request.setAttribute("firstOperand", firstOperand);
        request.setAttribute("secondOperand", secondOperand);
        request.setAttribute("operator", operator);

        try {
            double result = Calculator.calculate(firstOperand, secondOperand, operator);
            request.setAttribute("result", result);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        request.getRequestDispatcher("calculator/calculator.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
