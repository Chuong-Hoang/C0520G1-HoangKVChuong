package main.controller;

import main.bo.customer_bo.CustomerBO;
import main.bo.customer_bo.CustomerBOImplement;
import main.bo.customer_bo.CustomerSortByNameBO;
import main.common.Validation;
import main.model.customer_model.Customer;

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

    // Set invalid message
    private static final String ID_INVALID = "The ID must be as format 'KH-XXXX'";
    private static final String NAME_INVALID = "The name not valid";
    private static final String BIRTHDAY_INVALID = "The birthday must made the age not less than 18";
    private static final String CARD_ID_INVALID = "The ID card number is not valid";
    private static final String EMAIL_INVALID = "The email is not valid";
    private static final String PHONE_INVALID = "The phone number must have 10 or 11 digits";
    private static final String INTEGER_INVALID = "The number is not valid";
    private static final String DOUBLE_INVALID = "The number is not valid";

    // Attributes
    String element_name = "customer";

    // Object's properties
    String title_id = "ID";//id
    String title_a = "Name";//a
    String title_b = "Birthday";//b
    String title_c = "Gender";//c
    String title_d = "Id-Card";//d
    String title_e = "Phone";//e
    String title_f = "Email";//f
    String title_g = "Address";//g
    String title_h = "Customer-Type ID";//h
    /* ......... Extra ......... */

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

        request.setAttribute("title_id", title_id);
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


    // POST (A) ---------------------------------------------------------------------
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        initSetAttribute(request);

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    createCustomer(request, response); //$$$$$$$$$$$
                    break;
                case "edit":
                    editCustomer(request, response); //$$$$$$$$$$$
                    break;
                case "delete":
                    deleteCustomer(request, response); //$$$$$$$$$$$
                    break;
                case "search":
                    searchCustomer(request, response); //$$$$$$$$$$$
                    break;
                default:
                    break;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    //.................................. POST end ........................................

    // 3. create
    private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String id = request.getParameter("id");
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        String c = request.getParameter("c");
        String d = request.getParameter("d");
        String e = request.getParameter("e");
        String f = request.getParameter("f");
        String g = request.getParameter("g");
        String h = request.getParameter("h");

        //IF NOT VALIDATE
        Customer el = new Customer(id, a, b, c, d, e, f, g, h);
        this.customerBO.create(el);
        //request.setAttribute("el", el);
        request.setAttribute("msg_create", msg_create);
        forwardJSP(request, response, createJSP);

//        // VALIDATE input _____________________________________________________________________________________________
//        boolean isValidALL = false;
//        boolean isValid_id = Validation.checkCode(id); //<!-- $$$$$$$$$$$$ -->
//        boolean isValid_a = Validation.checkName(a); //<!-- $$$$$$$$$$$$ -->
//        boolean isValid_b = Validation.checkBirthday(b); //<!-- $$$$$$$$$$$$ -->
//        boolean isValid_d = Validation.checkIdCard(d); //<!-- $$$$$$$$$$$$ -->
//        boolean isValid_e = Validation.checkPhoneNumber(e); //<!-- $$$$$$$$$$$$ -->
//        boolean isValid_f = Validation.checkEmail(f); //<!-- $$$$$$$$$$$$ -->
//
//        // *******************************************************
//        if (!isValid_id) {
//            request.setAttribute("msg_invalid_id", ID_INVALID);
//        }
//        if (!isValid_a) {
//            request.setAttribute("msg_invalid_a", NAME_INVALID);
//        }
//        if (!isValid_b) {
//            request.setAttribute("msg_invalid_b", BIRTHDAY_INVALID);
//        }
//        if (!isValid_d) {
//            request.setAttribute("msg_invalid_d", CARD_ID_INVALID);
//        }
//        if (!isValid_e) {
//            request.setAttribute("msg_invalid_e", PHONE_INVALID);
//        }
//        if (!isValid_f) {
//            request.setAttribute("msg_invalid_f", EMAIL_INVALID);
//        }
//        // *********************************************************
//
//        isValidALL = isValid_id && isValid_a && isValid_b && isValid_d && isValid_e && isValid_f;
//        if (isValidALL) {
//            Customer el = new Customer(id, a, b, c, d, e, f, g, h);
//            this.customerBO.create(el);
//            //request.setAttribute("el", el);
//            request.setAttribute("msg_create", msg_create);
//        } else {
//            request.setAttribute("msg_create", "Input not valid!");
//            request.setAttribute("id", id);
//            request.setAttribute("a", a);
//            request.setAttribute("b", b);
//            request.setAttribute("c", c);
//            request.setAttribute("d", d);
//            request.setAttribute("e", e);
//            request.setAttribute("f", f);
//            request.setAttribute("g", g);
//            request.setAttribute("h", h);
//        }
//        forwardJSP(request, response, createJSP);
//        // validate ends here..........._______________________________________________________________________________
    }
    /* ---------------------- end ------------------------ */

    // 4. edit
    private void editCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String id = request.getParameter("id");

        String idNew = request.getParameter("idNew");
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        String c = request.getParameter("c");
        String d = request.getParameter("d");
        String e = request.getParameter("e");
        String f = request.getParameter("f");
        String g = request.getParameter("g");
        String h = request.getParameter("h");

        //IF NOT VALIDATE
        Customer el = new Customer(idNew,  a,b,c,d,e,f,g,h); //<!-- $$$$$$$$$$$$ -->
        this.customerBO.update(id, el);
        request.setAttribute("el", el);
        request.setAttribute("msg_edit", msg_edit);
        forwardJSP(request, response, editJSP);

//        // VALIDATE input _____________________________________________________________________________________________
//        boolean isValidALL = false;
//        boolean isValid_id = Validation.checkCode(idNew); //<!-- $$$$$$$$$$$$ -->
//        boolean isValid_a = Validation.checkName(a); //<!-- $$$$$$$$$$$$ -->
//        boolean isValid_b = Validation.checkBirthday(b); //<!-- $$$$$$$$$$$$ -->
//        boolean isValid_d = Validation.checkIdCard(d); //<!-- $$$$$$$$$$$$ -->
//        boolean isValid_e = Validation.checkPhoneNumber(e); //<!-- $$$$$$$$$$$$ -->
//        boolean isValid_f = Validation.checkEmail(f); //<!-- $$$$$$$$$$$$ -->
//
//        //*******************************************************
//        if (!isValid_id) {
//            request.setAttribute("msg_invalid_id", ID_INVALID);
//        }
//        if (!isValid_a) {
//            request.setAttribute("msg_invalid_a", NAME_INVALID);
//        }
//        if (!isValid_b) {
//            request.setAttribute("msg_invalid_b", BIRTHDAY_INVALID);
//        }
//        if (!isValid_d) {
//            request.setAttribute("msg_invalid_d", CARD_ID_INVALID);
//        }
//        if (!isValid_e) {
//            request.setAttribute("msg_invalid_e", PHONE_INVALID);
//        }
//        if (!isValid_f) {
//            request.setAttribute("msg_invalid_f", EMAIL_INVALID);
//        }
//        //*********************************************************
//
//        isValidALL = isValid_id && isValid_a && isValid_b && isValid_d && isValid_e && isValid_f;
//        if (isValidALL) {
//            Customer el = new Customer(idNew,  a,b,c,d,e,f,g,h); //<!-- $$$$$$$$$$$$ -->
//            this.customerBO.update(id, el);
//            request.setAttribute("el", el);
//            request.setAttribute("msg_edit", msg_edit);
//        } else {
//            Customer el = customerBO.findById(id);
//            request.setAttribute("el", el);
//            request.setAttribute("msg_edit", "Input not valid!");
//            request.setAttribute("idNew", idNew);
//        }
//
//        forwardJSP(request, response, editJSP);
//        // Validate ends here....._____________________________________________________________________________________
    }
    /* ---------------------- end ------------------------ */

    // 5. delete
    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String id = request.getParameter("id");
        this.customerBO.delete(id);
        redirectTo(response, originalLink);
    }
    /* ---------------------- end ------------------------ */


    // GET (B) ----------------------------------------------
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        initSetAttribute(request);

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "view":
                showViewForm(request, response);
                break;
            case "sort-by-name":
                sortCustomerByName(request, response); //$$$$$$$$$$$
                break;

//            // Task 3.10 - CLEAR ON SCREEN -->
//            case "clear":
//                clearOnScreen(request, response);
//                break;
            default:
                showCustomerList(request, response); //$$$$$$$$$$$
                break;
        }
    }
    // ..................................... GET end .................................


    // 1.1. SHOW LIST ____________________________________________________________________
    private void showCustomerList(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> eList = this.customerBO.findAll();
        int count = eList.size();
        request.setAttribute("eList", eList);
        request.setAttribute("count", count);
        forwardJSP(request, response, listJSP);
    }
    /* ---------------------- end ------------------------ */

    // 1.2. SORT BY NAME ___________________________________________________________________
    private void sortCustomerByName(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> eList = this.customerBO.findAll();
        eList.sort(new CustomerSortByNameBO());
        int count = eList.size();
        request.setAttribute("eList", eList);
        request.setAttribute("count", count);
        forwardJSP(request, response, listJSP);
    }
    /* ---------------------- end ------------------------ */

    // 2. SEARCH NAME __________________________________________________________________
    private void searchCustomer(HttpServletRequest request, HttpServletResponse response) {
        String str = request.getParameter("keywords");
        List<Customer> eList = this.customerBO.findByName(str);
        eList.sort(new CustomerSortByNameBO());
        int count = eList.size();
        request.setAttribute("eList", eList);
        request.setAttribute("count", count);
        forwardJSP(request, response, listJSP);
    }
    /* ---------------------- end ------------------------ */

    // 3. CREATE NEW (REGISTER) ________________________________________________________
    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        forwardJSP(request, response, createJSP);
    }
    /* ---------------------- end ------------------------ */

    // 4. EDIT _______________________________________________________________________
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Customer el = this.customerBO.findById(id);
        request.setAttribute("el", el);
        forwardJSP(request, response, editJSP);
    }
    /* ---------------------- end ------------------------ */

    // 5. DELETE _______________________________________________________________________
    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Customer el = this.customerBO.findById(id);
        request.setAttribute("el", el);
        request.setAttribute("msg_delete", msg_delete);
        forwardJSP(request, response, deleteJSP);
    }
    /* ---------------------- end ------------------------ */

    // 6. VIEW _______________________________________________________________________
    private void showViewForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Customer el = this.customerBO.findById(id);
        request.setAttribute("el", el);
        forwardJSP(request, response, viewJSP);
    }
    /* ---------------------- end ------------------------ */

}
