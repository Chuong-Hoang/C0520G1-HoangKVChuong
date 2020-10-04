package vn.codegym.picture.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandle {
    @ExceptionHandler(BadWordsException.class)
    public ModelAndView showErrorPage(){
        System.err.println("You have used bad words on social media...");
        return  new ModelAndView("picture/error");
    }
}
