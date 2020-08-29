package product_management.controller;

import product_management.bo.ElementBO;
import product_management.bo.ElementBOImplement;
import product_management.model.Element;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ElementServlet", urlPatterns = {"", "/elements"} )
public class ElementServlet extends HttpServlet {

    private ElementBO elementBO = new ElementBOImplement();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createElement(request, response);
                break;
            case "edit":
                updateElement(request, response);
                break;
            case "delete":
                deleteElement(request, response);
                break;
            case "search":
                findElement(request, response);
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
                viewElement(request, response);
                break;
            default:
                listElements(request, response);
                break;
        }
    }

    private void viewElement(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Element element = this.elementBO.findById(id);
        request.setAttribute("element", element);

        //Get dispatcher for forwarding to jsp page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/element/view.jsp");

        //forward content to jsp page
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Element element = this.elementBO.findById(id);
        request.setAttribute("element", element);

        //Get dispatcher for forwarding to jsp page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/element/delete.jsp");

        //forward content to jsp page
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteElement(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Element element = this.elementBO.findById(id);


        //delete element from element list
        this.elementBO.remove(id);

        //redirect to home page
        try {
            response.sendRedirect("/elements");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Element element = elementBO.findById(id);
        request.setAttribute("element", element);

        //Get dispatcher for forwarding to jsp page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/element/edit.jsp");

        //forward content to jsp page
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void updateElement(HttpServletRequest request, HttpServletResponse response) {
        //Get attributes of the Element class
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        String c = request.getParameter("c");
        String d = request.getParameter("d");
        int id = Integer.parseInt(request.getParameter("id"));

        //Setter for updating
        Element element = this.elementBO.findById(id);
        element.setName(a);
        element.setPrice(b);
        element.setDesc(c);
        element.setProducer(d);
        this.elementBO.update(id, element);
        request.setAttribute("element", element);

        //Get dispatcher for forwarding to jsp page
        //RequestDispatcher dispatcher = request.getRequestDispatcher("/element/edit.jsp");

        //forward content to jsp page
        try {
            //dispatcher.forward(request, response);
            response.sendRedirect("/elements");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        //Get dispatcher for forwarding to jsp page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/element/create.jsp");

        //forward content to jsp page
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createElement(HttpServletRequest request, HttpServletResponse response) {
        //Get attributes of the Element class
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        String c = request.getParameter("c");
        String d = request.getParameter("d");
        int id = elementBO.getNextId();

        //create new element
        Element element = new Element(id, a,b,c,d);
        this.elementBO.save(element);

        //Get dispatcher
        RequestDispatcher dispatcher = request.getRequestDispatcher("/element/create.jsp");

        //forward to jsp page
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listElements(HttpServletRequest request, HttpServletResponse response){
        List<Element> elements = this.elementBO.findAll();
        request.setAttribute("elements", elements);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/element/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void findElement(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<Element> elements = this.elementBO.findByName(name);
        request.setAttribute("elements", elements);
        request.setAttribute("found_name", name);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/element/list.jsp");
        try {
            requestDispatcher.forward(request,response);
            //response.sendRedirect("/elements");
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

}
