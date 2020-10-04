package vn.codegym.user.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class UserAspect {
    @Pointcut("execution(* vn.codegym.user.controller.UserController.*(..))")
    public void userControllerMethod(){}

    @Before("userControllerMethod()")
    public void beforeCallMethod(JoinPoint joinPoint){
        System.err.println("Start method name: "+joinPoint.getSignature().getName() + " Time: "+ LocalDateTime.now());
    }

    @After("userControllerMethod()")
    public void afterCallMethod(JoinPoint joinPoint){
        System.err.println("End method name: "+joinPoint.getSignature().getName() + " Time: "+ LocalDateTime.now());
    }
}
