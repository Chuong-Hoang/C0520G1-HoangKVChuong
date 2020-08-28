import model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerListServlet", urlPatterns = "/show")
public class CustomerListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = new ArrayList<>();
        String img = "<img src=\"image/Chuong.jpg\" height=\"50\" width=\"50\">";
        customerList.add(new Customer("Chuong Hoang", "1988-04-20", "Quang Tri", img));
        customerList.add(new Customer("Quang Nguyen", "1988-04-20", "DN", img));
        customerList.add(new Customer("Tung Si", "1988-04-20", "Quang Binh", img));
        customerList.add(new Customer("Toan Le", "1988-04-20", "DN", img));
        customerList.add(new Customer("Nhat Le", "1988-04-20", "Quang Tri", img));

        request.setAttribute("customerListServlet", customerList);

        request.getRequestDispatcher("list.jsp").forward(request, response);
    }
}
