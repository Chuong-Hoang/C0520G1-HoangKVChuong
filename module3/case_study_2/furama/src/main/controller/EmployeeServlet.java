package main.controller;

import main.bo.employee_bo.EmployeeBO;
import main.bo.employee_bo.EmployeeBOImplement;
import main.bo.employee_bo.EmployeeSortByNameBO;
import main.common.Validation;
import main.model.customer_model.Customer;
import main.model.employee_model.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employees")
public class EmployeeServlet extends HttpServlet {
    EmployeeBO employeeBO = new EmployeeBOImplement();

    // Attributes
    String element_name = "employee";

    // Object's properties
    String title_id = "ID";//id
    String title_a = "Name";//a
    String title_b = "Birthday";//b
    String title_c = "Id-Card";//c
    String title_d = "Salary";//d
    String title_e = "Phone";//e
    String title_f = "Email";//f
    String title_g = "Address";//g
    String title_h = "Position-Id";//h
    String title_i = "Eduction-Degree-Id";//i
    String title_j = "Division-Id";//j
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
        request.setAttribute("title_i", title_i);
        request.setAttribute("title_j", title_j);
        // extra....

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
    //________________________________________________________________________________


    // POST (A) ----------------------------------------------------------------------
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        initSetAttribute(request);

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    createEmployee(request, response); //$$$$$$$$$$$
                    break;
                case "edit":
                    editEmployee(request, response); //$$$$$$$$$$$
                    break;
                case "delete":
                    deleteEmployee(request, response); //$$$$$$$$$$$
                    break;
                case "search":
                    searchEmployee(request, response); //$$$$$$$$$$$
                    break;
                default:
                    break;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        //.................................. POST end ........................................
    }


    // 3. create
    private void createEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String id = request.getParameter("id");
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        String c = request.getParameter("c");
        String d = request.getParameter("d");
        String e = request.getParameter("e");
        String f = request.getParameter("f");
        String g = request.getParameter("g");
        String h = request.getParameter("h");
        String i = request.getParameter("i");
        String j = request.getParameter("j");

        // Validate input
        boolean isValidALL = false;

        boolean isValid_a = Validation.checkName(a);
        boolean isValid_b = Validation.checkBirthday(b);
        boolean isValid_c = Validation.checkIdCard(c);
        boolean isValid_d = Validation.checkDouble(d);
        boolean isValid_e = Validation.checkPhoneNumber(e);
        boolean isValid_f = Validation.checkEmail(f);

        if (!isValid_a) {
            String msgInvalid_a = "The name not valid";
            request.setAttribute("msg_invalid_a", msgInvalid_a);
        }
        if (!isValid_b) {
            String msgInvalid_b = "The birthday must made the age not less than 18";
            request.setAttribute("msg_invalid_b", msgInvalid_b);
        }
        if (!isValid_c) {
            String msgInvalid_c = "The ID card number is not valid";
            request.setAttribute("msg_invalid_c", msgInvalid_c);
        }
        if (!isValid_d) {
            String msgInvalid_d = "The salary is not valid";
            request.setAttribute("msg_invalid_d", msgInvalid_d);
        }
        if (!isValid_e) {
            String msgInvalid_e = "The phone number must have 9 or 10 digits";
            request.setAttribute("msg_invalid_e", msgInvalid_e);
        }
        if (!isValid_f) {
            String msgInvalid_f = "The email is not valid";
            request.setAttribute("msg_invalid_f", msgInvalid_f);
        }

        isValidALL = isValid_a && isValid_b && isValid_c && isValid_d && isValid_e && isValid_f;
        if (isValidALL) {
            Employee el = new Employee(id,  a,b,c,d,e,f,g,h,i,j);
            this.employeeBO.create(el);
            //request.setAttribute("el", el);
            request.setAttribute("msg_create", msg_create);
        } else {
            request.setAttribute("msg_create", "Input not valid!");
        }
        forwardJSP(request, response, createJSP);
    }
    /* ---------------------- end ------------------------ */

    // 4. edit
    private void editEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException {
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
        String i = request.getParameter("i");
        String j = request.getParameter("j");

        // Validate input
        boolean isValidALL = false;

        boolean isValid_a = Validation.checkName(a);
        boolean isValid_b = Validation.checkBirthday(b);
        boolean isValid_c= Validation.checkIdCard(c);
        boolean isValid_d= Validation.checkDouble(d);
        boolean isValid_e = Validation.checkPhoneNumber(e);
        boolean isValid_f = Validation.checkEmail(f);

        if (!isValid_a) {
            String msgInvalid_a = "The name not valid";
            request.setAttribute("msg_invalid_a", msgInvalid_a);
        }
        if (!isValid_b) {
            String msgInvalid_b = "The birthday must made the age not less than 18";
            request.setAttribute("msg_invalid_b", msgInvalid_b);
        }
        if (!isValid_c) {
            String msgInvalid_c = "The ID card number is not valid";
            request.setAttribute("msg_invalid_c", msgInvalid_c);
        }
        if (!isValid_d) {
            String msgInvalid_d = "The salary is not valid";
            request.setAttribute("msg_invalid_d", msgInvalid_d);
        }
        if (!isValid_e) {
            String msgInvalid_e = "The phone number must have 10 or 11 digits";
            request.setAttribute("msg_invalid_e", msgInvalid_e);
        }
        if (!isValid_f) {
            String msgInvalid_f = "The email is not valid";
            request.setAttribute("msg_invalid_f", msgInvalid_f);
        }

        isValidALL = isValid_a && isValid_b && isValid_c && isValid_d && isValid_e && isValid_f;
        if (isValidALL) {
            Employee el = new Employee(id,  a,b,c,d,e,f,g,h,i,j);
            this.employeeBO.update(id, el);
            request.setAttribute("el", el);
            request.setAttribute("msg_edit", msg_edit);
        } else {
            request.setAttribute("msg_edit", "Input not valid!");
        }
        forwardJSP(request, response, editJSP);
    }
    /* ---------------------- end ------------------------ */

    // 5. delete
    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String id = request.getParameter("id");
        this.employeeBO.delete(id);
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
                sortEmployeeByName(request, response); //$$$$$$$$$$$
                break;
            default:
                showEmployeeList(request, response);  //$$$$$$$$$$$
                break;
        }
        // ..................................... GET end ................................
    }

    // 1.1. SHOW LIST ___________________________________________________________________
    private void showEmployeeList(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> eList = this.employeeBO.findAll();
        int count = eList.size();
        request.setAttribute("eList", eList);
        request.setAttribute("count", count);
        forwardJSP(request, response, listJSP);
    }
    /* ---------------------- end ------------------------ */

    // 1.2. SORT BY NAME ___________________________________________________________________
    private void sortEmployeeByName(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> eList = this.employeeBO.findAll();
        eList.sort(new EmployeeSortByNameBO());
        int count = eList.size();
        request.setAttribute("eList", eList);
        request.setAttribute("count", count);
        forwardJSP(request, response, listJSP);
    }
    /* ---------------------- end ------------------------ */

    // 2. SEARCH NAME __________________________________________________________________
    private void searchEmployee(HttpServletRequest request, HttpServletResponse response) {
        String str = request.getParameter("keywords");
        List<Employee> eList = this.employeeBO.findByName(str);
        eList.sort(new EmployeeSortByNameBO());
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
        Employee el = this.employeeBO.findById(id);
        request.setAttribute("el", el);
        forwardJSP(request, response, editJSP);
    }
    /* ---------------------- end ------------------------ */

    // 5. DELETE _______________________________________________________________________
    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Employee el = this.employeeBO.findById(id);
        request.setAttribute("el", el);
        request.setAttribute("msg_delete", msg_delete);
        forwardJSP(request, response, deleteJSP);
    }
    /* ---------------------- end ------------------------ */

    // 6. VIEW _______________________________________________________________________
    private void showViewForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Employee el = this.employeeBO.findById(id);
        request.setAttribute("el", el);
        forwardJSP(request, response, viewJSP);
    }
    /* ---------------------- end ------------------------ */

}
