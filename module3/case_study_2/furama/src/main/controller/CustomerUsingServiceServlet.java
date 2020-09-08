package main.controller;

import main.bo.customer_using_service_bo.CustomerUsingServiceBOImplement;
import main.model.customer_model.Customer;
import main.model.customer_using_service_model.CustomerUsingService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerUsingServiceServlet", urlPatterns = "/customer-using-services")
public class CustomerUsingServiceServlet extends HttpServlet {
    CustomerUsingServiceBOImplement customerUsingServiceBO = new CustomerUsingServiceBOImplement();

    // Attributes
    String element_name = "customer-using-service";

    // Object's properties
    String title_a = "Customer ID";//a
    String title_b = "Customer Name";//b
    String title_c = "Contract ID";//c
    String title_d = "Contract Detail ID";//d
    String title_e = "Service ID";//e
    String title_f = "Service Name";//f
    String title_g = "Attach Service ID";//g
    String title_h = "Attach Service Name";//h
    /* ......... Extra ......... */

//        this.customerId = customerId;
//        this.customerName = customerName;
//        this.contractId = contractId;
//        this.contractDetailId = contractDetailId;
//        this.serviceId = serviceId;
//        this.serviceName = serviceName;
//        this.attachServiceId = attachServiceId;
//        this.attachServiceName = attachServiceName;

    // Titles
    String list_element = element_name + " List";
    String create_element = "Create new " + element_name;
    String delete_element = "Delete " + element_name;
    String edit_element = "Edit " + element_name;
    String view_element = "View " + element_name;
    String msg_create = "New " + element_name + " has been successfully created.";
    String msg_edit = "This " + element_name + " has been successfully updated.";
    String msg_delete = "Really want to delete this " + element_name + "?";
    String originalLink = "/" + element_name + "s";

    // Link JSP
    String listJSP = element_name + "/" + element_name + "_" + "list.jsp";
    String createJSP = element_name + "/" + element_name + "_" + "create.jsp";
    String editJSP = element_name + "/" + element_name + "_" + "edit.jsp";
    String deleteJSP = element_name + "/" + element_name + "_" + "delete.jsp";
    String viewJSP = element_name + "/" + element_name + "_" + "view.jsp";

    // Initial set attributes
    protected void initSetAttribute(HttpServletRequest request) {

        request.setAttribute("title_a", title_a);
        request.setAttribute("title_b", title_b);
        request.setAttribute("title_c", title_c);
        request.setAttribute("title_d", title_d);
        request.setAttribute("title_e", title_e);
        request.setAttribute("title_f", title_f);
        request.setAttribute("title_g", title_g);
        request.setAttribute("title_h", title_h);
        //extra....

        request.setAttribute("element_name", element_name);
        request.setAttribute("list_element", list_element);
        request.setAttribute("create_element", create_element);
        request.setAttribute("delete_element", delete_element);
        request.setAttribute("edit_element", edit_element);
        request.setAttribute("view_element", view_element);
        request.setAttribute("originalLink", originalLink);
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
    //_______________________________________________________________________________


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        initSetAttribute(request);

        // 1.1. SHOW LIST :showCustomerUsingServiceList __________________________________

        List<CustomerUsingService> eList = this.customerUsingServiceBO.findAll();
        int count = eList.size();
        request.setAttribute("eList", eList);
        request.setAttribute("count", count);
        forwardJSP(request, response, listJSP);

        /* ---------------------- end ------------------------ */
    }
}
