package vn.codegym.book.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CodeNotFoundExceptionHandler {

    // if exception of this class happens, this method will handle
    @ExceptionHandler(CodeNotFoundException.class)
    ModelAndView showCodeNotFoundPage(){
        System.err.println("No code in the database matched...");
        return  new ModelAndView("book/not_matched");
    }
}
