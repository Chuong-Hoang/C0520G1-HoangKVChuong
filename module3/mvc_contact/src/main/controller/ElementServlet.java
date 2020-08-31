package main.controller;

import main.bo.ElementBO;
import main.bo.ElementBOImplement;
import main.model.Element;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/* ................................................................ */
@WebServlet(name = "ElementServlet", urlPatterns = {"", "/elements"})
public class ElementServlet extends HttpServlet {
    ElementBO elementBO = new ElementBOImplement();

    //Attributes of Element Class
    String title_a = "Name";
    String title_b = "Number";
    String title_c = "Group";

    String title_d = "...";
    String title_e = "...";
    String title_f = "...";

    //Link JSP
    String listJSP = "element/list.jsp";
    String createJSP = "element/create.jsp";
    String editJSP = "element/edit.jsp";
    String deleteJSP = "element/delete.jsp";
    String viewJSP = "element/view.jsp";
    String linkToHome = "/elements";

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
        Element element = this.elementBO.findById(id);
        request.setAttribute("element", element);

        forwardJSP(request, response, viewJSP);
    }

    // Delete element ....................................................................
    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Element element = this.elementBO.findById(id);
        request.setAttribute("element", element);

        forwardJSP(request, response, deleteJSP);
    }

    private void deleteElement(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Element element = this.elementBO.findById(id);

        this.elementBO.remove(id);
        request.setAttribute("element", element);

        redirectTo(response, linkToHome); //******************
    }

    // Edit element ....................................................................
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Element element = this.elementBO.findById(id);
        request.setAttribute("element", element);

        forwardJSP(request, response, editJSP);
    }

    private void editElement(HttpServletRequest request, HttpServletResponse response) {
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        String c = request.getParameter("c");
        int id = Integer.parseInt(request.getParameter("id"));

        Element element = this.elementBO.findById(id);
        element.setProp_A(a);
        element.setProp_B(b);
        element.setProp_C(c);

        this.elementBO.update(id, element);
        request.setAttribute("element", element);
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
        int id = this.elementBO.getNextId();

        Element element = new Element(id, a,b,c);
        this.elementBO.save(element);
        request.setAttribute("element", element);
        request.setAttribute("msg", "New element has been successfully created.");

        forwardJSP(request, response, createJSP);
    }

    //Show list ..........................................................................
    private void showElementList(HttpServletRequest request, HttpServletResponse response) {
        List<Element> elements = this.elementBO.findAll();
        request.setAttribute("elements", elements);

        forwardJSP(request, response, listJSP);
    }

    //find by name .......................................................................
    private void searchElement(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<Element> elements = this.elementBO.findByName(name);
        request.setAttribute("elements", elements);
        if(elements.size() > 0) {
            request.setAttribute("msg", "Result found as below");
        } else {
            request.setAttribute("msg", "No element found");
        }

        forwardJSP(request, response, listJSP);
    }
}
