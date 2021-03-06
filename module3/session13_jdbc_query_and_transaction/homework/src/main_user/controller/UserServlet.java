package main_user.controller;

import main_user.bo.SortingUserName;
import main_user.bo.UserBO;
import main_user.bo.UserBOImplement;
import main_user.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = {"", "/users"})
public class UserServlet extends HttpServlet {
    UserBO userBO = new UserBOImplement();

    // Attributes
    String element_name = "user";

    String name_list = element_name + " List";
    String create_element = "Create new " + element_name;
    String delete_element = "Delete " + element_name;
    String edit_element = "Edit " + element_name;
    String view_element = "View " + element_name;
    String msg_create = "New " + element_name + " has been successfully created.";
    String msg_edit = "This " + element_name + " has been successfully updated.";

    // Object's properties
    String title_a = "Name";
    String title_b = "Email";
    String title_c = "Country";
    /* ......... Extra ......... */

    // Link JSP
    String listJSP = element_name + "/list.jsp";
    String createJSP = element_name + "/create.jsp";
    String editJSP = element_name + "/edit.jsp";
    String deleteJSP = element_name + "/delete.jsp";
    String viewJSP = element_name + "/view.jsp";
    String linkToHome = "/users";

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

        try {
            switch (action) {
                case "create":
                    createUser(request, response);
                    break;
                case "edit":
                    editUser(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                    break;
                case "search":
                    searchUser(request, response);
                    break;

                // Homework2: add user transaction
                case "add-user-transaction":
                    createUserTransaction(request, response);
                    break;
                default:
                    break;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    // GET (2) -----------------------------------------------------------------------
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        initSetAttribute(request);

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
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

                // Test using Transaction: conn.commit() and conn.rollback()
                case "permission":
                    addUserPermission(request, response);
                    break;

                // Test not using Transaction
                case "test-without-tran":
                    testWithoutTransaction(request, response);
                    break;

                // Test Using Transaction
                case "test-use-tran":
                    testUseTransaction(request, response);
                    break;
                default:
                    showUserList(request, response);
                    break;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    // . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . .


    // Homework2: add user transaction
    private void createUserTransaction(HttpServletRequest request, HttpServletResponse response) {
        this.userBO.addUserTransaction();
        redirectTo(response, linkToHome);
    }
    /* ---------------------- end ------------------------ */


    // Test Use Transaction:
    private void testUseTransaction(HttpServletRequest request, HttpServletResponse response) {
        this.userBO.insertUpdateTransaction();
        redirectTo(response, "user/transaction.jsp");
    }
    /* ---------------------- end ------------------------ */


    // Test Not Use Transaction:
    private void testWithoutTransaction(HttpServletRequest request, HttpServletResponse response) {
        this.userBO.insertUpdateWithoutTransaction();
        redirectTo(response, "user/transaction.jsp");
    }
    /* ---------------------- end ------------------------ */


    // Test Transaction: conn.commit() and conn.rollback()
    private void addUserPermission(HttpServletRequest request, HttpServletResponse response) {
        User user = new User("Loan", "loan.tran@gmail.com", "Germany");
        int[] permissions = {3,5,6};
        userBO.addUserTransactionPractice(user, permissions);
        redirectTo(response, linkToHome);
    }
    /* ---------------------- end ------------------------ */


    // Search by name or country
    private void searchUser(HttpServletRequest request, HttpServletResponse response) {
        String str = request.getParameter("name");
        List<User> users = this.userBO.findByName(str);
        request.setAttribute("users", users);
        forwardJSP(request, response, listJSP);
    }
    /* ---------------------- end ------------------------ */


    // Delete ......................................................................
    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = this.userBO.findById(id);
        request.setAttribute("user", user);
        forwardJSP(request, response, deleteJSP);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        this.userBO.delete(id);
        redirectTo(response, linkToHome); // Back to Home
    }
    /* ---------------------- end ------------------------ */



    // Edit ......................................................................
    private void editUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        String c = request.getParameter("c");

        User user = new User(id, a,b,c);
//        User user = new User(a,b,c);
        //System.out.println("After: " + a + "--" + b + "--" + c); // Test

        this.userBO.update(user);
        request.setAttribute("user", user);
        request.setAttribute("msg_edit", msg_edit);
        forwardJSP(request, response, editJSP);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = this.userBO.findById(id);
        //System.out.println("Before: " + user.getName() + "--" + user.getEmail() + "--" + user.getCountry()); // Test
        request.setAttribute("user", user);
        forwardJSP(request, response, editJSP);
    }
    /* ---------------------- end ------------------------ */


    // View ............................................................................
    private void showViewForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = this.userBO.findById(id);
        request.setAttribute("user", user);
        forwardJSP(request, response, viewJSP);
    }
    /* ---------------------- end ------------------------ */


    // Create new .......................................................................
    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        forwardJSP(request, response, createJSP);
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        String c = request.getParameter("c");
        User user = new User(a, b, c);

        this.userBO.create(user);
        request.setAttribute("user", user);
        request.setAttribute("msg_create", msg_create);
        forwardJSP(request, response, createJSP);
    }
    /* ---------------------- end ------------------------ */


    // Show list .....................................................................
    private void showUserList(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<User> users = this.userBO.findAll();

        // Sort by name
        users.sort(new SortingUserName());

        request.setAttribute("users", users);
        forwardJSP(request, response, listJSP);
    }
    /* ---------------------- end ------------------------ */

}
