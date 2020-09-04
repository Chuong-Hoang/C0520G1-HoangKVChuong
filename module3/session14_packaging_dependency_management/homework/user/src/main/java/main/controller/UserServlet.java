package main.controller;

import main.bo.UserBO;
import main.bo.UserBOImplement;
import main.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/* ................................................................ */
@WebServlet(name = "UserServlet", urlPatterns = {"", "/users"})
public class UserServlet extends HttpServlet {
    UserBO userBO = new UserBOImplement();

    //Set Attributes
    String element_name = "user";
    String name_list =  element_name + " List";
    String create_element = "Create new " + element_name;
    String delete_element = "Delete " + element_name;
    String edit_element = "Edit " + element_name;
    String view_element = "View " + element_name;

    String title_a = "Name";
    String title_b = "Email";
    String title_c = "Country";

    String title_d = "...";
    String title_e = "...";
    String title_f = "...";

    //Link JSP
    String listJSP = element_name + "/list.jsp";
    String createJSP = element_name + "/create.jsp";
    String editJSP = element_name + "/edit.jsp";
    String deleteJSP = element_name + "/delete.jsp";
    String viewJSP = element_name + "/view.jsp";
    String linkToHome = "/" + element_name + "s";

    //Forward to JSP
    protected void forwardJSP(HttpServletRequest request, HttpServletResponse response, String linkJSP) {
        RequestDispatcher dispatcher = request.getRequestDispatcher(linkJSP);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException ex) {
            ex.printStackTrace();
        }
    }

    // redirect to JSP (Home)
    protected void redirectTo(HttpServletResponse response, String linkToJSP) {
        try {
            response.sendRedirect(linkToJSP);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /* .............................................. POST .......................................... */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("element_name", element_name);
        request.setAttribute("name_list", name_list);
        request.setAttribute("create_element", create_element);
        request.setAttribute("delete_element", delete_element);
        request.setAttribute("edit_element", edit_element);
        request.setAttribute("view_element", view_element);

        request.setAttribute("title_a", title_a);
        request.setAttribute("title_b", title_b);
        request.setAttribute("title_c", title_c);

        //--Extra
        request.setAttribute("title_d", title_d);
        request.setAttribute("title_e", title_e);
        request.setAttribute("title_f", title_f);

        String action = request.getParameter("action");
        if(action == null) {
            action = "";
        }
        switch (action) {
            case "create": createUser(request, response); break;
            case "edit": editUser(request, response); break;
            case "delete": deleteUser(request, response); break;
            case "search":
                try {
                    searchUser(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default: break;
        }
    }

    /* .............................................. GET .......................................... */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("element_name", element_name);
        request.setAttribute("name_list", name_list);
        request.setAttribute("create_element", create_element);
        request.setAttribute("delete_element", delete_element);
        request.setAttribute("edit_element", edit_element);
        request.setAttribute("view_element", view_element);

        request.setAttribute("title_a", title_a);
        request.setAttribute("title_b", title_b);
        request.setAttribute("title_c", title_c);

        //--Extra
        request.setAttribute("title_d", title_d);
        request.setAttribute("title_e", title_e);
        request.setAttribute("title_f", title_f);

        String action = request.getParameter("action");
        if(action == null) {
            action = "";
        }
        switch (action) {
            case "create": showCreateForm(request, response); break;
            case "edit":
                try {
                    showEditForm(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "delete": showDeleteForm(request, response); break;
            case "view": showViewForm(request, response); break;
            default:
                try {
                    showUserList(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    /* ............................................. CONTROLLER ....................................... */
    // View element
    private void showViewForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = this.userBO.selectUser(id);
        request.setAttribute(element_name, user);

        forwardJSP(request, response, viewJSP);
    }

    // Delete element ....................................................................
    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = this.userBO.selectUser(id);
        request.setAttribute(element_name, user);

        forwardJSP(request, response, deleteJSP);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = this.userBO.selectUser(id);

        try {
            this.userBO.deleteUser(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute(element_name, user);

        redirectTo(response, linkToHome); //******************
    }

    // Edit element ....................................................................
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = this.userBO.selectUser(id);
        request.setAttribute(element_name, user);

        forwardJSP(request, response, editJSP);
    }

    private void editUser(HttpServletRequest request, HttpServletResponse response) {
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        String c = request.getParameter("c");
        int id = Integer.parseInt(request.getParameter("id"));

        User user = this.userBO.selectUser(id);
        user.setName(a);
        user.setEmail(b);
        user.setCountry(c);

        try {
            this.userBO.updateUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute(element_name, user);
        request.setAttribute("msg", "User has been updated."); //User

        forwardJSP(request, response, editJSP);

        //redirectTo(response, linkToHome); //******************
    }

    // Create element ....................................................................
    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        forwardJSP(request, response, createJSP);
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response) {
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        String c = request.getParameter("c");
        //int id = this.userBO.getNextId();

        User user = new User(a,b,c);
        try {
            this.userBO.insertUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute(element_name, user);
        request.setAttribute("msg", "New element has been successfully created.");

        forwardJSP(request, response, createJSP);
    }

    //Show list ..........................................................................
    private void showUserList(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<User> users = this.userBO.selectAllUsers();
        request.setAttribute(element_name.concat("s"), users);

        forwardJSP(request, response, listJSP);
    }

    // Find by name .......................................................................
    private void searchUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
        String name = request.getParameter("keywords");
        List<User> users = this.userBO.findByName(name);
        request.setAttribute(element_name.concat("s"), users);
        forwardJSP(request, response, listJSP);
    }
}
