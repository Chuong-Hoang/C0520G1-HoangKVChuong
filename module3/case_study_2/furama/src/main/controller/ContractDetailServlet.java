package main.controller;

import main.bo.contract_detail_bo.ContractDetailBO;
import main.bo.contract_detail_bo.ContractDetailBOImplement;
import main.bo.contract_detail_bo.SortContractDetailByContractIdBO;
import main.model.contract_detail_model.ContractDetail;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ContractDetailServlet", urlPatterns = "/contract-details")
public class ContractDetailServlet extends HttpServlet {
    ContractDetailBO contractDetailBO = new ContractDetailBOImplement();

    // Attributes
    String element_name = "contract-detail";

    // Object's properties
    String title_id = "Contract-Detail ID";//id
    String title_a = "Contract ID";//a
    String title_b = "Attach Service ID";//b
    String title_c = "Quantity";//c
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
                    createContractDetail(request, response); //$$$$$$$$$$$
                    break;
                case "edit":
                    editContractDetail(request, response); //$$$$$$$$$$$
                    break;
                case "delete":
                    deleteContractDetail(request, response); //$$$$$$$$$$$
                    break;
                case "search":
                    searchContractDetail(request, response); //$$$$$$$$$$$
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
    private void createContractDetail(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String id = request.getParameter("id");
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        String c = request.getParameter("c");

        ContractDetail el = new ContractDetail(id,  a, b, c);

        this.contractDetailBO.create(el);
        //request.setAttribute("el", el);
        request.setAttribute("msg_create", msg_create);
        forwardJSP(request, response, createJSP);
    }
    /* ---------------------- end ------------------------ */

    // 4. edit
    private void editContractDetail(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String idNew = request.getParameter("idNew");
        String id = request.getParameter("id");
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        String c = request.getParameter("c");

        ContractDetail el = new ContractDetail(idNew,  a,b,c);

        this.contractDetailBO.update(id, el);
        request.setAttribute("el", el);
        request.setAttribute("msg_edit", msg_edit);
        forwardJSP(request, response, editJSP);
    }
    /* ---------------------- end ------------------------ */

    // 5. delete
    private void deleteContractDetail(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String id = request.getParameter("id");
        this.contractDetailBO.delete(id);
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
                sortContractDetailByContractId(request, response); //$$$$$$$$$$$
                break;
            default:
                showContractDetailList(request, response); //$$$$$$$$$$$
                break;
        }
        // ..................................... GET end .................................
    }

    // 1.1. SHOW LIST ____________________________________________________________________
    private void showContractDetailList(HttpServletRequest request, HttpServletResponse response) {
        List<ContractDetail> eList = this.contractDetailBO.findAll();
        int count = eList.size();
        request.setAttribute("eList", eList);
        request.setAttribute("count", count);
        forwardJSP(request, response, listJSP);
    }
    /* ---------------------- end ------------------------ */

    // 1.2. SORT BY NAME ___________________________________________________________________
    private void sortContractDetailByContractId(HttpServletRequest request, HttpServletResponse response) {
        List<ContractDetail> eList = this.contractDetailBO.findAll();
        eList.sort(new SortContractDetailByContractIdBO());
        int count = eList.size();
        request.setAttribute("eList", eList);
        request.setAttribute("count", count);
        forwardJSP(request, response, listJSP);
    }
    /* ---------------------- end ------------------------ */

    // 2. SEARCH CONTRACT ID _______________________________________________________________
    private void searchContractDetail(HttpServletRequest request, HttpServletResponse response) {
        String str = request.getParameter("keywords");
        List<ContractDetail> eList = this.contractDetailBO.findByContractId(str);
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
        ContractDetail el = this.contractDetailBO.findById(id);
        request.setAttribute("el", el);
        forwardJSP(request, response, editJSP);
    }
    /* ---------------------- end ------------------------ */

    // 5. DELETE _______________________________________________________________________
    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        ContractDetail el = this.contractDetailBO.findById(id);
        request.setAttribute("el", el);
        request.setAttribute("msg_delete", msg_delete);
        forwardJSP(request, response, deleteJSP);
    }
    /* ---------------------- end ------------------------ */

    // 6. VIEW _______________________________________________________________________
    private void showViewForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        ContractDetail el = this.contractDetailBO.findById(id);
        request.setAttribute("el", el);
        forwardJSP(request, response, viewJSP);
    }
    /* ---------------------- end ------------------------ */
}
