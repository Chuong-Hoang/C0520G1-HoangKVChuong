package vn.codegym.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.book.exception.BookNotFoundException;
import vn.codegym.book.exception.CodeNotFoundException;
import vn.codegym.book.model.Book;
import vn.codegym.book.service.BookService;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    // Constants
    private final String EL_NAME = "book";
    private final String LIST_PAGE = EL_NAME + "/list";
    private final String CREATE_PAGE = EL_NAME + "/create";
    private final String EDIT_PAGE = EL_NAME + "/edit";
    private final String DELETE_PAGE = EL_NAME + "/delete";
    private final String VIEW_PAGE = EL_NAME + "/view";
    private final String REDIRECT_TO_LIST = "redirect:/" + EL_NAME;

    private final String LIST_MSG = "Total of " + EL_NAME + ": ";
    private final String CREATE_MSG = "Create new " + EL_NAME + " successfully.";
    private final String EDIT_MSG = "Update the " + EL_NAME + " successfully.";
    private final String DELETE_MSG = "Delete the " + EL_NAME + " successfully.";
    private final String DELETE_MANY_MSG = "Delete the selected " + EL_NAME + "(s) successfully.";

    @Autowired
    BookService bookService;

    @GetMapping
    public ModelAndView getListPage(){
        ModelAndView modelAndView = new ModelAndView(LIST_PAGE);
        modelAndView.addObject("eList", bookService.findAll());
        modelAndView.addObject("COUNT_MSG", LIST_MSG + bookService.count());
        modelAndView.addObject("ids", new int[]{}); // only for delete many
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView getCreatePage(){
        ModelAndView modelAndView = new ModelAndView(CREATE_PAGE);
        modelAndView.addObject("book", new Book());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView getCreated(@ModelAttribute Book book, RedirectAttributes redirect){
        ModelAndView modelAndView = new ModelAndView(REDIRECT_TO_LIST);
        bookService.save(book);
        redirect.addFlashAttribute("msg", CREATE_MSG);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView getEditPage(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView(EDIT_PAGE);
        modelAndView.addObject("book", bookService.findById(id));
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView getEditPage(@ModelAttribute Book book, RedirectAttributes redirect){
        ModelAndView modelAndView = new ModelAndView(REDIRECT_TO_LIST);
        bookService.save(book);
        redirect.addFlashAttribute("msg", EDIT_MSG);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView getDeletePage(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView(DELETE_PAGE);
        modelAndView.addObject("book", bookService.findById(id));
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView getDeleted(@ModelAttribute Book book, RedirectAttributes redirect){
        ModelAndView modelAndView = new ModelAndView(REDIRECT_TO_LIST);
        bookService.delete(book.getId());
        redirect.addFlashAttribute("msg", DELETE_MSG);
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView getViewPage(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView(VIEW_PAGE);
        modelAndView.addObject("book", bookService.findById(id));
        modelAndView.addObject("borrowedMsg", "");
        return modelAndView;
    }

    @GetMapping("/borrow/{id}")
    public ModelAndView getBorrowedBook(@PathVariable int id) throws BookNotFoundException {
        ModelAndView modelAndView = new ModelAndView(VIEW_PAGE);
        Book book = bookService.findById(id);
        if(book.getQuantity() < 1) {
            throw new BookNotFoundException();
        }
        book.setQuantity(book.getQuantity() - 1);
        long code = (long)(Math.random()*99999);
        StringBuilder codeList = book.getCodeList();
        codeList.append(code);
        codeList.append(", ");
        book.setCodeList(codeList);
        bookService.save(book);
        modelAndView.addObject("book", book);
        modelAndView.addObject("borrowedMsg", "The borrowed code is: " + code);
        return modelAndView;
    }

    @GetMapping("/return")
    public ModelAndView getReturnPage(){
        return new ModelAndView("book/return");
    }

    @PostMapping("/return-book")
    public ModelAndView getReturnedBook(@RequestParam("code") String code) throws CodeNotFoundException {
        ModelAndView modelAndView = new ModelAndView(LIST_PAGE);
        List<Book> bookList = bookService.findAll();
        String msg = "";
        for(Book book : bookList){
            StringBuilder codeList = book.getCodeList();
            System.err.println("Before return: " + codeList);
            int codeIndex = codeList.indexOf(code);
            if (codeIndex > -1){
                codeList.delete(codeIndex, codeIndex + code.length() + 1); // 1 is to delete comma (",")
                book.setQuantity(book.getQuantity() + 1);
                book.setCodeList(codeList);
                System.err.println("After return: " + codeList);
                bookService.save(book);
                msg = "You have returned a book code: " + code;
                modelAndView.addObject("eList", bookService.findAll());
                modelAndView.addObject("msg", msg);
                return modelAndView;
            }
        }
        throw new CodeNotFoundException();
    }
}
