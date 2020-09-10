package main.controller;

import com.sun.deploy.net.HttpRequest;
import main.bo.product_bo.ProductBO;
import main.bo.product_bo.ProductBOImplement;
import main.bo.product_bo.ProductSortByNameBO;
import main.common.Validation;
import main.model.product_model.ExProduct;
import main.model.product_model.ImProduct;
import main.model.product_model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.server.ExportException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = {"/products"})
public class ProductServlet extends HttpServlet {
    ProductBO productBO = new ProductBOImplement();

    // Set invalid message
    private static final String ID_INVALID = "The ID must be as format 'KH-XXXX'";
    private static final String NAME_INVALID = "The name not valid";
    private static final String CODE_INVALID = "The code not valid";
    private static final String BIRTHDAY_INVALID = "The birthday must made the age not less than 18";
    private static final String CARD_ID_INVALID = "The ID card number is not valid";
    private static final String EMAIL_INVALID = "The email is not valid";
    private static final String PHONE_INVALID = "The phone number must have 10 or 11 digits";
    private static final String INTEGER_INVALID = "The number is not valid";
    private static final String DOUBLE_INVALID = "The number is not valid";

    // Attributes
    String element_name = "product";

    // Object's properties
    String title_id = "Product ID";//id
    String title_a = "Product Code";//a
    String title_b = "Product Name";//b
    String title_c = "Product Price";//c
    String title_d = "Product Quantity";//d
    String title_e = "Product Producer";//e

    String title_f = "Imported Price";//f
    String title_g = "Import Province";//g
    String title_h = "Import Tax";//h

    String title_i = "Exported Price";//i (only ex)
    String title_j = "Buying Country";//j (only ex)
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
                    createProduct(request, response); //$$$$$$$$$$$
                    break;
                case "edit":
                    editProduct(request, response); //$$$$$$$$$$$
                    break;
                case "delete":
                    deleteProduct(request, response); //$$$$$$$$$$$
                    break;
                case "search":
                    searchProduct(request, response); //$$$$$$$$$$$
                    break;
                default:
                    break;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        //.................................. POST end ........................................
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) {
        String str = request.getParameter("keywords");
        List<Product> eList = this.productBO.findByName(str);
        eList.sort(new ProductSortByNameBO());
        int count = eList.size();
        request.setAttribute("eList", eList);
        request.setAttribute("count", count);
        forwardJSP(request, response, listJSP);
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String id = request.getParameter("id");
        this.productBO.delete(id);
        redirectTo(response, originalLink);
    }


    // 3. create
    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String id = request.getParameter("id");
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        String c = request.getParameter("c");
        String d = request.getParameter("d");
        String e = request.getParameter("e");


        // Validate input
        boolean isValidALL = false;

        boolean isValid_id = Validation.checkInteger(id);
        boolean isValid_a = Validation.checkCode(a);
        boolean isValid_b = Validation.checkDouble(b);
        boolean isValid_c = Validation.checkDouble(c);
        boolean isValid_d = Validation.checkInteger(d);

        if (!isValid_id) {
            request.setAttribute("msg_invalid_id", INTEGER_INVALID);
        }
        if (!isValid_a) {

            request.setAttribute("msg_invalid_a", CODE_INVALID);
        }
        if (!isValid_b) {
            request.setAttribute("msg_invalid_b", NAME_INVALID);
        }
        if (!isValid_c) {
            request.setAttribute("msg_invalid_c", DOUBLE_INVALID);
        }
        if (!isValid_d) {
            request.setAttribute("msg_invalid_d", INTEGER_INVALID);
        }

        isValidALL = isValid_id && isValid_a && isValid_b && isValid_c && isValid_d;

        String option = request.getParameter("option");
        Product el = null;

        if (option.compareTo("Import") == 0) {
            String f = request.getParameter("f");
            String g = request.getParameter("g");
            String h = request.getParameter("h");

            boolean isValid_f = Validation.checkDouble(f);
            boolean isValid_g = Validation.checkName(g);
            boolean isValid_h = Validation.checkDouble(h);

            if (!isValid_f) {
                request.setAttribute("msg_invalid_f", DOUBLE_INVALID);
            }
            if (!isValid_g) {
                request.setAttribute("msg_invalid_g", NAME_INVALID);
            }
            if (!isValid_h) {
                request.setAttribute("msg_invalid_h", DOUBLE_INVALID);
            }

            isValidALL = isValidALL && isValid_f && isValid_g && isValid_h;
            if (isValidALL) {
                el = new ImProduct(id, a, b, c, d, e, f, g, h);
                this.productBO.create(el);
                request.setAttribute("el", el);
                request.setAttribute("msg_create", msg_create);
            } else {
                request.setAttribute("msg_create", "Input not valid!");
                request.setAttribute("id", id);
                request.setAttribute("a", a);
                request.setAttribute("b", b);
                request.setAttribute("c", c);
                request.setAttribute("d", d);
                request.setAttribute("e", e);
                request.setAttribute("f", f);
                request.setAttribute("g", g);
                request.setAttribute("g", g);
            }

        } else if (option.compareTo("Export") == 0) {
            String i = request.getParameter("i");
            String j = request.getParameter("j");

            boolean isValid_i = Validation.checkDouble(i);
            boolean isValid_j = Validation.checkName(j);

            if (!isValid_i) {
                request.setAttribute("msg_invalid_i", DOUBLE_INVALID);
            }
            if (!isValid_j) {
                request.setAttribute("msg_invalid_j", NAME_INVALID);
            }

            isValidALL = isValidALL && isValid_j;
            if (isValidALL) {
                el = new ExProduct(id, a, b, c, d, e, i, j);
                this.productBO.create(el);
                request.setAttribute("el", el);
                request.setAttribute("msg_create", msg_create);
            } else {
                request.setAttribute("msg_create", "Input not valid!");
                request.setAttribute("id", id);
                request.setAttribute("a", a);
                request.setAttribute("b", b);
                request.setAttribute("c", c);
                request.setAttribute("d", d);
                request.setAttribute("e", e);
                request.setAttribute("i", i);
                request.setAttribute("j", j);
            }
        }
        forwardJSP(request, response, createJSP);
    }
    /* ---------------------- end ------------------------ */

    // 4. edit
    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String id = request.getParameter("id");

        String idNew = request.getParameter("idNew");
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        String c = request.getParameter("c");
        String d = request.getParameter("d");
        String e = request.getParameter("e");

        // this line must have to check ...instanceof...
        Product el = this.productBO.findById(id);

        // Validate input
        boolean isValidALL = false;

        boolean isValid_id = Validation.checkInteger(id);
        boolean isValid_a = Validation.checkCode(a);
        boolean isValid_b = Validation.checkDouble(b);
        boolean isValid_c = Validation.checkDouble(c);
        boolean isValid_d = Validation.checkInteger(d);

        if (!isValid_id) {
            request.setAttribute("msg_invalid_id", INTEGER_INVALID);
        }
        if (!isValid_a) {

            request.setAttribute("msg_invalid_a", CODE_INVALID);
        }
        if (!isValid_b) {
            request.setAttribute("msg_invalid_b", NAME_INVALID);
        }
        if (!isValid_c) {
            request.setAttribute("msg_invalid_c", DOUBLE_INVALID);
        }
        if (!isValid_d) {
            request.setAttribute("msg_invalid_d", INTEGER_INVALID);
        }

        isValidALL = isValid_id && isValid_a && isValid_b && isValid_c && isValid_d;

        // not the same as method createProduct
        if (el instanceof ImProduct) {
            String f = request.getParameter("f");
            String g = request.getParameter("g");
            String h = request.getParameter("h");

            boolean isValid_f = Validation.checkDouble(f);
            boolean isValid_g = Validation.checkName(g);
            boolean isValid_h = Validation.checkDouble(h);

            if (!isValid_f) {
                request.setAttribute("msg_invalid_f", DOUBLE_INVALID);
            }
            if (!isValid_g) {
                request.setAttribute("msg_invalid_g", NAME_INVALID);
            }
            if (!isValid_h) {
                request.setAttribute("msg_invalid_h", DOUBLE_INVALID);
            }

            isValidALL = isValidALL && isValid_f && isValid_g && isValid_h;
            if (isValidALL) {
                el = new ImProduct(idNew, a, b, c, d, e, f, g, h); // --> idNew
                this.productBO.update(id, el);
                request.setAttribute("el", el);
                request.setAttribute("msg_edit", msg_edit);
            } else {
                request.setAttribute("el", el);
                request.setAttribute("msg_edit", "Input not valid!");
            }

        } else if (el instanceof ExProduct) {
            String i = request.getParameter("i");
            String j = request.getParameter("j");

            boolean isValid_i = Validation.checkDouble(i);
            boolean isValid_j = Validation.checkName(j);

            if (!isValid_i) {
                request.setAttribute("msg_invalid_i", DOUBLE_INVALID);
            }
            if (!isValid_j) {
                request.setAttribute("msg_invalid_j", NAME_INVALID);
            }

            isValidALL = isValidALL && isValid_i && isValid_j;
            if (isValidALL) {
                el = new ExProduct(idNew, a, b, c, d, e, i, j); // --> idNew
                this.productBO.update(id, el);
                request.setAttribute("el", el);
                request.setAttribute("msg_edit", msg_edit);
            } else {
                request.setAttribute("el", el);
                request.setAttribute("msg_edit", "Input not valid!");
            }
        }
        forwardJSP(request, response, editJSP);
    }



        // GET (B) -----------------------------------------------------------------------
        protected void doGet (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {
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
//            case "sort-by-name":
//                sortProductByName(request, response); //$$$$$$$$$$$
//                break;
                default:
                    showProductList(request, response); //$$$$$$$$$$$
                    break;
            }
            // ..................................... GET end ................................
        }




    private void showProductList(HttpServletRequest request, HttpServletResponse response) {
        List<Product> eList = this.productBO.findAll();
        int count = eList.size();
        request.setAttribute("eList", eList);
        request.setAttribute("count", count);
        forwardJSP(request, response, listJSP);
    }

    private void sortProductByName(HttpServletRequest request, HttpServletResponse response) {
        List<Product> eList = this.productBO.findAll();
        //eList.sort(new ProductSortByNameBO());
        int count = eList.size();
        request.setAttribute("eList", eList);
        request.setAttribute("count", count);
        forwardJSP(request, response, listJSP);
    }

    private void showViewForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Product el = this.productBO.findById(id);
        request.setAttribute("el", el);
        forwardJSP(request, response, viewJSP);
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Product el = this.productBO.findById(id);
        request.setAttribute("el", el);
        request.setAttribute("msg_delete", msg_delete);
        forwardJSP(request, response, deleteJSP);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Product el = this.productBO.findById(id);
        request.setAttribute("el", el);
        forwardJSP(request, response, editJSP);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        forwardJSP(request, response, createJSP);
    }
}
