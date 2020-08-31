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
import java.util.List;

/* ................................................................ */
@WebServlet(name = "UserServlet", urlPatterns = {"", "/users"})
public class UserServlet extends HttpServlet {
    UserBO userBO = new UserBOImplement();

    //Attributes of Element Class
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
    String linkToHome = "/users";

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
            case "create": createElement(request, response); break;
            case "edit": editElement(request, response); break;
            case "delete": deleteElement(request, response); break;
            case "search": searchElement(request, response); break;
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
            case "edit": showEditForm(request, response); break;
            case "delete": showDeleteForm(request, response); break;
            case "view": showViewForm(request, response); break;
            default: showElementList(request, response); break;
        }
    }

    /* ............................................. CONTROLLER ....................................... */
    // View element
    private void showViewForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = this.userBO.findById(id);
        request.setAttribute("user", user);

        forwardJSP(request, response, viewJSP);
    }

    // Delete element ....................................................................
    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = this.userBO.findById(id);
        request.setAttribute("user", user);

        forwardJSP(request, response, deleteJSP);
    }

    private void deleteElement(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = this.userBO.findById(id);

        this.userBO.remove(id);
        request.setAttribute("user", user);

        redirectTo(response, linkToHome); //******************
    }

    // Edit element ....................................................................
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = this.userBO.findById(id);
        request.setAttribute("user", user);

        forwardJSP(request, response, editJSP);
    }

    private void editElement(HttpServletRequest request, HttpServletResponse response) {
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        String c = request.getParameter("c");
        int id = Integer.parseInt(request.getParameter("id"));

        User user = this.userBO.findById(id);
        user.setName(a);
        user.setEmail(b);
        user.setCountry(c);

        this.userBO.update(id, user);
        request.setAttribute("user", user);
        request.setAttribute("msg", "Element has been updated.");

        forwardJSP(request, response, editJSP);

        //redirectTo(response, linkToHome); //******************
    }

    // Create element ....................................................................
    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        forwardJSP(request, response, createJSP);
    }

    private void createElement(HttpServletRequest request, HttpServletResponse response) {
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        String c = request.getParameter("c");
        int id = this.userBO.getNextId();

        User user = new User(id, a,b,c);
        this.userBO.save(user);
        request.setAttribute("user", user);
        request.setAttribute("msg", "New element has been successfully created.");

        forwardJSP(request, response, createJSP);
    }

    //Show list ..........................................................................
    private void showElementList(HttpServletRequest request, HttpServletResponse response) {
        List<User> users = this.userBO.findAll();
        request.setAttribute("users", users);

        forwardJSP(request, response, listJSP);
    }

    //find by name .......................................................................
    private void searchElement(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<User> users = this.userBO.findByName(name);
        request.setAttribute("users", users);
        if(users.size() > 0) {
            request.setAttribute("msg", "Result found as below");
        } else {
            request.setAttribute("msg", "No element found");
        }

        forwardJSP(request, response, listJSP);
    }
}
