package vn.codegym.book.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
@Aspect
public class BookAspect {
    @Pointcut("execution(* vn.codegym.book.controller.BookController.*(..))")
    public void bookControllerMethod() {}

    @Before("bookControllerMethod()")
    public void beforeCallMethod(JoinPoint joinPoint) {
        System.err.println("Start method name: "
                + joinPoint.getSignature().getName()
                + " Time: " + LocalDateTime.now()
        );
    }

    @After("bookControllerMethod()")
    public void afterCallMethod(JoinPoint joinPoint) {
        System.err.println("End method name: "
                + joinPoint.getSignature().getName()
                + " Time: " + LocalDateTime.now()
        );
    }

    @Pointcut("execution(* vn.codegym.book.controller.BookController.getBorrowedBook(..))")
    public void getBorrowedBookMethod() {}
    @Before("getBorrowedBookMethod()")
    public void beforeCallBorrowedBookMethod(JoinPoint joinPoint) {
        System.err.println("Start method name: "
                + joinPoint.getSignature().getName()
                + " Time: " + LocalDateTime.now()
        );
    }

    @AfterThrowing("getBorrowedBookMethod()")
    public void afterThrowExceptionBorrowedBookMethod(JoinPoint joinPoint) {
        System.err.println("After throwing exception of method name: "
                + joinPoint.getSignature().getName()
                + " Time: " + LocalDateTime.now()
        );
    }


    @Pointcut("execution(* vn.codegym.book.controller.BookController.getReturnedBook(..))")
    public void getReturnedBookMethod() {}
    @Before("getReturnedBookMethod()")
    public void beforeCallReturnedBookMethod(JoinPoint joinPoint) {
        System.err.println("Start method name: "
                + joinPoint.getSignature().getName()
                + " Time: " + LocalDateTime.now()
        );
    }

    @AfterReturning("getReturnedBookMethod()")
    public void afterCallReturnedBookMethod(JoinPoint joinPoint) {
        System.err.println("Finish method name: "
                + joinPoint.getSignature().getName()
                + " Time: " + LocalDateTime.now()
        );
    }
}