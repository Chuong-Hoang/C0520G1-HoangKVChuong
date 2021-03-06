package main.controller;

import main.bo.service_bo.ServiceBO;
import main.bo.service_bo.ServiceBOImplement;
import main.bo.service_bo.ServiceSortByNameBO;
import main.common.Validation;
import main.model.service_model.House;
import main.model.service_model.Room;
import main.model.service_model.Service;
import main.model.service_model.Villa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = {"/services"})
public class ServiceServlet extends HttpServlet {
    ServiceBO serviceBO = new ServiceBOImplement();

    // Attributes
    String element_name = "service";

    // Object's properties
    String title_id = "Service-ID";//id
    String title_a = "Service-Name";//a
    String title_b = "Service-Area";//b
    String title_c = "Service-Cost";//c
    String title_d = "Service-Max-People";//d
    String title_e = "Rent-Type-Id";//e
    String title_f = "Service-Type-Id";//f

    String title_g = "Standard-Room";//g
    String title_h = "Description-Other-Convenience";//h
    String title_i = "Pool-Area";//i (only Villa)
    String title_j = "Number-Of-Floors";//j
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
                    createService(request, response); //$$$$$$$$$$$
                    break;
                case "edit":
                    editService(request, response); //$$$$$$$$$$$
                    break;
                case "delete":
                    deleteService(request, response); //$$$$$$$$$$$
                    break;
                case "search":
                    searchService(request, response); //$$$$$$$$$$$
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
    private void createService(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String id = request.getParameter("id");
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        String c = request.getParameter("c");
        String d = request.getParameter("d");
        String e = request.getParameter("e");
        String f = request.getParameter("f");

        // Validate input
        boolean isValidALL = false;

        boolean isValid_id = Validation.checkCode(id);
        boolean isValid_a = Validation.checkName(a);
        boolean isValid_b = Validation.checkDouble(b);
        boolean isValid_c = Validation.checkDouble(c);
        boolean isValid_d = Validation.checkInteger(d);

        if (!isValid_id) {
            String msgInvalid_id = "The ID must as format 'DV-xxxx' ";
            request.setAttribute("msg_invalid_id", msgInvalid_id);
        }
        if (!isValid_a) {
            String msgInvalid_a = "The name not valid";
            request.setAttribute("msg_invalid_a", msgInvalid_a);
        }
        if (!isValid_b) {
            String msgInvalid_b = "The number is not valid";
            request.setAttribute("msg_invalid_b", msgInvalid_b);
        }
        if (!isValid_c) {
            String msgInvalid_c = "The number is not valid";
            request.setAttribute("msg_invalid_c", msgInvalid_c);
        }
        if (!isValid_d) {
            String msgInvalid_d = "The number is not valid";
            request.setAttribute("msg_invalid_d", msgInvalid_d);
        }

        isValidALL = isValid_id && isValid_a && isValid_c && isValid_d;

        String option = request.getParameter("option");
        Service el = null;

        if (option.compareTo("Villa") == 0) {
            String g = request.getParameter("g");
            String h = request.getParameter("h");
            String i = request.getParameter("i");
            String j = request.getParameter("j");

            boolean isValid_i = Validation.checkDouble(i);
            boolean isValid_j = Validation.checkInteger(j);

            if (!isValid_i) {
                String msgInvalid_i = "The number is not valid";
                request.setAttribute("msg_invalid_i", msgInvalid_i);
            }
            if (!isValid_j) {
                String msgInvalid_j = "The number is not valid";
                request.setAttribute("msg_invalid_j", msgInvalid_j);
            }

            isValidALL = isValidALL && isValid_i && isValid_j;
            if (isValidALL) {
                el = new Villa(id, a, b, c, d, e, f, g, h, i, j);
                this.serviceBO.create(el);
                request.setAttribute("el", el);
                request.setAttribute("msg_create", msg_create);
            } else {
                request.setAttribute("msg_create", "Input not valid!");
            }

        } else if (option.compareTo("House") == 0) {
            String g = request.getParameter("g");
            String h = request.getParameter("h");
            String j = request.getParameter("j");


            boolean isValid_j = Validation.checkInteger(j);
            if (!isValid_j) {
                String msgInvalid_j = "The number is not valid";
                request.setAttribute("msg_invalid_j", msgInvalid_j);
            }

            isValidALL = isValidALL && isValid_j;
            if (isValidALL) {
                el = new House (id, a, b, c, d, e, f, g, h, j);
                this.serviceBO.create(el);
                request.setAttribute("el", el);
                request.setAttribute("msg_create", msg_create);
            } else {
                request.setAttribute("msg_create", "Input not valid!");
            }
        } else {
            if(isValidALL) {
                el = new Room(id, a, b, c, d, e, f);
                this.serviceBO.create(el);
                request.setAttribute("el", el);
                request.setAttribute("msg_create", msg_create);
            } else {
                request.setAttribute("msg_create", "Input not valid!");
            }
        }

        forwardJSP(request, response, createJSP);
    }
    /* ---------------------- end ------------------------ */

    // 4. edit
    private void editService(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String id = request.getParameter("id");

        String idNew = request.getParameter("idNew");
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        String c = request.getParameter("c");
        String d = request.getParameter("d");
        String e = request.getParameter("e");
        String f = request.getParameter("f");

        // this line must have to check ...instanceof...
        Service el = this.serviceBO.findById(id);

        // Validate input
        boolean isValidALL = false;

        boolean isValid_id = Validation.checkCode(id);
        boolean isValid_a = Validation.checkName(a);
        boolean isValid_b = Validation.checkDouble(b);
        boolean isValid_c = Validation.checkDouble(c);
        boolean isValid_d = Validation.checkInteger(d);

        if (!isValid_id) {
            String msgInvalid_id = "The ID must as format 'DV-xxxx' ";
            request.setAttribute("msg_invalid_id", msgInvalid_id);
        }
        if (!isValid_a) {
            String msgInvalid_a = "The name not valid";
            request.setAttribute("msg_invalid_a", msgInvalid_a);
        }
        if (!isValid_b) {
            String msgInvalid_b = "The number is not valid";
            request.setAttribute("msg_invalid_b", msgInvalid_b);
        }
        if (!isValid_c) {
            String msgInvalid_c = "The number is not valid";
            request.setAttribute("msg_invalid_c", msgInvalid_c);
        }
        if (!isValid_d) {
            String msgInvalid_d = "The number is not valid";
            request.setAttribute("msg_invalid_d", msgInvalid_d);
        }

        isValidALL = isValid_id && isValid_a && isValid_c && isValid_d;

        // not the same as method createService
        if (el instanceof Villa) {
            String g = request.getParameter("g");
            String h = request.getParameter("h");
            String i = request.getParameter("i");
            String j = request.getParameter("j");

            boolean isValid_i = Validation.checkDouble(i);
            boolean isValid_j = Validation.checkInteger(j);

            if (!isValid_i) {
                String msgInvalid_i = "The number is not valid";
                request.setAttribute("msg_invalid_i", msgInvalid_i);
            }
            if (!isValid_j) {
                String msgInvalid_j = "The number is not valid";
                request.setAttribute("msg_invalid_j", msgInvalid_j);
            }

            isValidALL = isValidALL && isValid_i && isValid_j;
            if (isValidALL) {
                el = new Villa(id, a, b, c, d, e, f, g, h, i, j);
                this.serviceBO.update(id, el);
                request.setAttribute("el", el);
                request.setAttribute("msg_edit", msg_edit);
            } else {
                request.setAttribute("msg_edit", "Input not valid!");
            }

        } else if (el instanceof House) {
            String g = request.getParameter("g");
            String h = request.getParameter("h");
            String j = request.getParameter("j");


            boolean isValid_j = Validation.checkInteger(j);
            if (!isValid_j) {
                String msgInvalid_j = "The number is not valid";
                request.setAttribute("msg_invalid_j", msgInvalid_j);
            }

            isValidALL = isValidALL && isValid_j;
            if (isValidALL) {
                el = new House (id, a, b, c, d, e, f, g, h, j);
                this.serviceBO.update(id, el);
                request.setAttribute("el", el);
                request.setAttribute("msg_edit", msg_edit);
            } else {
                request.setAttribute("msg_edit", "Input not valid!");
            }
        } else {
            if(isValidALL) {
                el = new Room(id, a, b, c, d, e, f);
                this.serviceBO.update(id, el);
                request.setAttribute("el", el);
                request.setAttribute("msg_edit", msg_edit);
            } else {
                request.setAttribute("msg_edit", "Input not valid!");
            }
        }

        forwardJSP(request, response, editJSP);

    }
    /* ---------------------- end ------------------------ */

    // 5. delete
    private void deleteService(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String id = request.getParameter("id");
        this.serviceBO.delete(id);
        redirectTo(response, originalLink);
    }
    /* ---------------------- end ------------------------ */


    // GET (B) -----------------------------------------------------------------------
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
                sortServiceByName(request, response); //$$$$$$$$$$$
                break;
            default:
                showServiceList(request, response); //$$$$$$$$$$$
                break;
        }
        // ..................................... GET end ................................
    }

    // 1.1. SHOW LIST ___________________________________________________________________
    private void showServiceList(HttpServletRequest request, HttpServletResponse response) {
        List<Service> eList = this.serviceBO.findAll();
        int count = eList.size();
        request.setAttribute("eList", eList);
        request.setAttribute("count", count);
        forwardJSP(request, response, listJSP);
    }
    /* ---------------------- end ------------------------ */

    // 1.2. SORT BY NAME __________________________________________________________________
    private void sortServiceByName(HttpServletRequest request, HttpServletResponse response) {
        List<Service> eList = this.serviceBO.findAll();
        eList.sort(new ServiceSortByNameBO());
        int count = eList.size();
        request.setAttribute("eList", eList);
        request.setAttribute("count", count);
        forwardJSP(request, response, listJSP);
    }
    /* ---------------------- end ------------------------ */

    // 2. SEARCH NAME _________________________________________________________________
    private void searchService(HttpServletRequest request, HttpServletResponse response) {
        String str = request.getParameter("keywords");
        List<Service> eList = this.serviceBO.findByName(str);
        eList.sort(new ServiceSortByNameBO());
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
        Service el = this.serviceBO.findById(id);
        request.setAttribute("el", el);
        forwardJSP(request, response, editJSP);
    }
    /* ---------------------- end ------------------------ */

    // 5. DELETE _______________________________________________________________________
    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Service el = this.serviceBO.findById(id);
        request.setAttribute("el", el);
        request.setAttribute("msg_delete", msg_delete);
        forwardJSP(request, response, deleteJSP);
    }
    /* ---------------------- end ------------------------ */

    // 6. VIEW _______________________________________________________________________
    private void showViewForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Service el = this.serviceBO.findById(id);
        request.setAttribute("el", el);
        forwardJSP(request, response, viewJSP);
    }
    /* ---------------------- end ------------------------ */

}
