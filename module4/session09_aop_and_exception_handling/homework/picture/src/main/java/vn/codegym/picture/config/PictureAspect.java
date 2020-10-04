package vn.codegym.picture.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import vn.codegym.picture.model.NasaPicture;

import java.time.LocalDateTime;
import java.util.Arrays;

@Component
@Aspect
public class PictureAspect {
    @Pointcut("execution(* vn.codegym.picture.controller.NasaPictureController.getCreateDone(..))")
    public void pictureControllerMethod(){}

    @Before("pictureControllerMethod()")
    public void beforeCallMethod(JoinPoint joinPoint){
        System.err.println("Start method name: "
                + joinPoint.getSignature().getName()
                + " Time: " + LocalDateTime.now()
        );
    }

    @After("pictureControllerMethod()")
    public void afterCallMethod(JoinPoint joinPoint){
        System.err.println("Arguments Passed=" + Arrays.toString(joinPoint.getArgs()));
        System.err.println("Start method name: "
                        + joinPoint.getSignature().getName()
                        + " Time: " + LocalDateTime.now()
        );
    }
}
