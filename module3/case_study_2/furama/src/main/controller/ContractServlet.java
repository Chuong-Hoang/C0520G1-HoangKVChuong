package main.controller;

import main.bo.contract_bo.ContractBO;
import main.bo.contract_bo.ContractBOImplement;
import main.bo.contract_bo.SortContractByDateBO;
import main.common.Validation;
import main.model.contract_model.Contract;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet(name = "ContractServlet", urlPatterns = "/contracts")
public class ContractServlet extends HttpServlet {
    ContractBO contractBO = new ContractBOImplement();

    // Attributes
    String element_name = "contract";

    // Object's properties
    String title_id = "ID";//id
    String title_a = "Start Date";//a
    String title_b = "End Date";//b
    String title_c = "Deposit";//c
    String title_d = "Total Money";//d
    String title_e = "Employee Id";//e
    String title_f = "Customer Id";//f
    String title_g = "Service Id";//g
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
                    createContract(request, response); //$$$$$$$$$$$
                    break;
                case "edit":
                    editContract(request, response); //$$$$$$$$$$$
                    break;
                case "delete":
                    deleteContract(request, response); //$$$$$$$$$$$
                    break;
                case "search":
                    searchContract(request, response); //$$$$$$$$$$$
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
    private void createContract(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String id = request.getParameter("id");
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        String c = request.getParameter("c");
        String d = request.getParameter("d");
        String e = request.getParameter("e");
        String f = request.getParameter("f");
        String g = request.getParameter("g");

        // Validate input
        boolean isValidALL = false;

        boolean isValid_c = Validation.checkDouble(c);
        boolean isValid_d = Validation.checkDouble(d);

        if (!isValid_c) {
            String msgInvalid_c = "The name not valid";
            request.setAttribute("msg_invalid_c", msgInvalid_c);
        }
        if (!isValid_d) {
            String msgInvalid_d = "The ID card number is not valid";
            request.setAttribute("msg_invalid_d", msgInvalid_d);
        }

        isValidALL = isValid_c && isValid_d;
        if (isValidALL) {
            Contract el = new Contract(id, a, b, c, d, e, f, g);
            this.contractBO.create(el);
            //request.setAttribute("el", el);
            request.setAttribute("msg_create", msg_create);
        } else {
            request.setAttribute("msg_create", "Input not valid!");
        }
        forwardJSP(request, response, createJSP);
    }
    /* ---------------------- end ------------------------ */

    // 4. edit
    private void editContract(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String idNew = request.getParameter("idNew");
        String id = request.getParameter("id");
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        String c = request.getParameter("c");
        String d = request.getParameter("d");
        String e = request.getParameter("e");
        String f = request.getParameter("f");
        String g = request.getParameter("g");

        // Validate input
        boolean isValidALL = false;

        boolean isValid_c = Validation.checkDouble(c);
        boolean isValid_d = Validation.checkDouble(d);

        if (!isValid_c) {
            String msgInvalid_c = "The name not valid";
            request.setAttribute("msg_invalid_c", msgInvalid_c);
        }
        if (!isValid_d) {
            String msgInvalid_d = "The ID card number is not valid";
            request.setAttribute("msg_invalid_d", msgInvalid_d);
        }

        isValidALL = isValid_c && isValid_d;
        if (isValidALL) {
            Contract el = new Contract(idNew,  a,b,c,d,e,f,g);
            this.contractBO.update(id, el);
            request.setAttribute("el", el);
            request.setAttribute("msg_edit", msg_edit);
        } else {
            request.setAttribute("msg_edit", "Input not valid!");
        }
        forwardJSP(request, response, editJSP);
    }
    /* ---------------------- end ------------------------ */

    // 5. delete
    private void deleteContract(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String id = request.getParameter("id");
        this.contractBO.delete(id);
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
                sortContractByDate(request, response); //$$$$$$$$$$$
                break;
            default:
                showContractList(request, response); //$$$$$$$$$$$
                break;
        }
        // ..................................... GET end .................................
    }

    // 1.1. SHOW LIST ____________________________________________________________________
    private void showContractList(HttpServletRequest request, HttpServletResponse response) {
        List<Contract> eList = this.contractBO.findAll();
        int count = eList.size();
        request.setAttribute("eList", eList);
        request.setAttribute("count", count);
        forwardJSP(request, response, listJSP);
    }
    /* ---------------------- end ------------------------ */

    // 1.2. SORT BY (START) DATE ___________________________________________________________________
    private void sortContractByDate(HttpServletRequest request, HttpServletResponse response) {
        List<Contract> eList = this.contractBO.findAll();
        eList.sort(new SortContractByDateBO());
        int count = eList.size();
        request.setAttribute("eList", eList);
        request.setAttribute("count", count);
        forwardJSP(request, response, listJSP);
    }
    /* ---------------------- end ------------------------ */

    // 2. SEARCH DATE __________________________________________________________________
    private void searchContract(HttpServletRequest request, HttpServletResponse response) {
        String str = request.getParameter("keywords");
        List<Contract> eList = this.contractBO.findByDate(str);
        eList.sort(new SortContractByDateBO());
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
        Contract el = this.contractBO.findById(id);
        request.setAttribute("el", el);
        forwardJSP(request, response, editJSP);
    }
    /* ---------------------- end ------------------------ */

    // 5. DELETE _______________________________________________________________________
    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Contract el = this.contractBO.findById(id);
        request.setAttribute("el", el);
        request.setAttribute("msg_delete", msg_delete);
        forwardJSP(request, response, deleteJSP);
    }
    /* ---------------------- end ------------------------ */

    // 6. VIEW _______________________________________________________________________
    private void showViewForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Contract el = this.contractBO.findById(id);
        request.setAttribute("el", el);
        forwardJSP(request, response, viewJSP);
    }
    /* ---------------------- end ------------------------ */
}
