package product_management.controller;

import product_management.bo.ProductBO;
import product_management.bo.ProductBOImplement;
import product_management.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = {"", "/products"} )
public class ProductServlet extends HttpServlet {

    private ProductBO productBO = new ProductBOImplement();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "edit":
                updateProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            case "search":
                findProduct(request, response);
                break;
            default:
                break;
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) {
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
                showDeleteForm(request,response);
                break;
            case "view":
                viewProduct(request, response);
                break;
            default:
                listProducts(request, response);
                break;
        }
    }

    private void viewProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productBO.findById(id);
        request.setAttribute("product", product);

        //Get dispatcher for forwarding to jsp page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/view.jsp");

        //forward content to jsp page
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productBO.findById(id);
        request.setAttribute("product", product);

        //Get dispatcher for forwarding to jsp page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/delete.jsp");

        //forward content to jsp page
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productBO.findById(id);


        //delete element from element list
        this.productBO.remove(id);

        //redirect to home page
        try {
            response.sendRedirect("/products");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productBO.findById(id);
        request.setAttribute("product", product);

        //Get dispatcher for forwarding to jsp page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/edit.jsp");

        //forward content to jsp page
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
        //Get attributes of the Element class
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        String c = request.getParameter("c");
        String d = request.getParameter("d");
        int id = Integer.parseInt(request.getParameter("id"));

        //Setter for updating
        Product product = this.productBO.findById(id);
        product.setName(a);
        product.setPrice(b);
        product.setDesc(c);
        product.setProducer(d);
        this.productBO.update(id, product);
        request.setAttribute("product", product);

        //Get dispatcher for forwarding to jsp page
        //RequestDispatcher dispatcher = request.getRequestDispatcher("/element/edit.jsp");

        //forward content to jsp page
        try {
            //dispatcher.forward(request, response);
            response.sendRedirect("/products");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        //Get dispatcher for forwarding to jsp page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/create.jsp");

        //forward content to jsp page
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        //Get attributes of the Element class
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        String c = request.getParameter("c");
        String d = request.getParameter("d");
        int id = productBO.getNextId();

        //create new element
        Product product = new Product(id, a,b,c,d);
        this.productBO.save(product);

        //Get dispatcher
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/create.jsp");

        //forward to jsp page
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response){
        List<Product> products = this.productBO.findAll();
        request.setAttribute("products", products);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/product/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void findProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<Product> products = this.productBO.findByName(name);
        request.setAttribute("products", products);
        request.setAttribute("found_name", name);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/product/list.jsp");
        try {
            requestDispatcher.forward(request,response);
            //response.sendRedirect("/products");
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

}
