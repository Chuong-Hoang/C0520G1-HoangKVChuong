package controller;

import model.DBUtils;
import model.Dept;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "JstlCoreEx01Servlet", urlPatterns = "/123")
public class JstlCoreEx01Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public JstlCoreEx01Servlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Simulate query data from DB
        List<Dept> list = DBUtils.queryDepartments();

        //Save data as attribute 'departments' in request
        request.setAttribute("departments", list);

        //Create RequestDispatcher and forward to JSP
        request.getRequestDispatcher("/WEB-INF/jsps/jstl_core_example01.jsp").forward(request, response);

    }
}
