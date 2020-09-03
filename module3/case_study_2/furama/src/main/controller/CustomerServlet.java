package main.controller;

import main.bo.customer_bo.CustomerBO;
import main.bo.customer_bo.CustomerBOImplement;
import main.bo.customer_bo.SortingCustomerName;
import main.model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customers"})
public class CustomerServlet extends HttpServlet {
    CustomerBO customerBO = new CustomerBOImplement();

    // Attributes
    String element_name = "customer";

    String name_list = element_name + " List";
    String create_element = "Create new " + element_name;
    String delete_element = "Delete " + element_name;
    String edit_element = "Edit " + element_name;
    String view_element = "View " + element_name;
    String msg_create = "New " + element_name + " has been successfully created.";
    String msg_edit = "This " + element_name + " has been successfully updated.";

    // Object's properties
    String title_a = "Name";//a
    String title_b = "Birthday";//b
    String title_c = "Gender";//c
    String title_d = "Id-Card";//d
    String title_e = "Phone";//e
    String title_f = "Email";//f
    String title_g = "Address";//g
    String title_h = "Customer-Type";//h
    /* ......... Extra ......... */

    // Link JSP
    String listJSP = "furama/" + element_name + "/customer_list.jsp";
    String createJSP = "furama/" + element_name + "/create.jsp";
    String editJSP = "furama/" + element_name + "/edit.jsp";
    String deleteJSP = "furama/" + element_name + "/delete.jsp";
    String viewJSP = "furama/" + element_name + "/view.jsp";
    String linkToHome = "/home";

    // Initial set attributes
    protected void initSetAttribute(HttpServletRequest request) {
        request.setAttribute("element_name", element_name);
        request.setAttribute("name_list", name_list);
        request.setAttribute("create_element", create_element);
        request.setAttribute("delete_element", delete_element);
        request.setAttribute("edit_element", edit_element);
        request.setAttribute("view_element", view_element);

        request.setAttribute("title_a", title_a);
        request.setAttribute("title_b", title_b);
        request.setAttribute("title_c", title_c);
        request.setAttribute("title_d", title_d);
        request.setAttribute("title_e", title_e);
        request.setAttribute("title_f", title_f);
        request.setAttribute("title_g", title_g);
        request.setAttribute("title_h", title_h);
        //extra....
    }

    // Forward to JSP
    protected void forwardJSP(HttpServletRequest request, HttpServletResponse response, String linkJSP) {
        RequestDispatcher dispatcher = request.getRequestDispatcher(linkJSP);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException ex) {
            ex.printStackTrace();
        }
    }

    // Redirect to JSP [HOME]
    protected void redirectTo(HttpServletResponse response, String linkToJSP) {
        try {
            response.sendRedirect(linkToJSP);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    // POST (1) ----------------------------------------------------------------------
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        initSetAttribute(request);

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                //createCustomer(request, response);
                break;
            case "edit":
                //editCustomer(request, response);
                break;
            case "delete":
                //deleteCustomer(request, response);
                break;
            case "search":
                //searchCustomer(request, response);
                break;
            default:
                break;
        }
    }


    // GET (2) -----------------------------------------------------------------------
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        initSetAttribute(request);

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                //showCreateForm(request, response);
                break;
            case "edit":
                //showEditForm(request, response);
                break;
            case "delete":
                //showDeleteForm(request, response);
                break;
            case "view":
                //showViewForm(request, response);
                break;
            default:
                showCustomerList(request, response);
                break;
        }
        // . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . .
    }

    private void showCustomerList(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customers = this.customerBO.findAll();
        // Sort by name
        //customers.sort(new SortingCustomerName());
        request.setAttribute("customers", customers);
        forwardJSP(request, response, listJSP);
    }

}
