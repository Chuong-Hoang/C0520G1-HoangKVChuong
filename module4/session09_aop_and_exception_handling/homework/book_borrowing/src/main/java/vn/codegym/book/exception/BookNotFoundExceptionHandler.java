package vn.codegym.book.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class BookNotFoundExceptionHandler {

    // if exception of this class happens, this method will handle
    @ExceptionHandler(BookNotFoundException.class)
    public ModelAndView showNotRemainedPage(){
        System.err.println("There is no book of this kind remained here...");
        return  new ModelAndView("book/not_remained");
    }
}
