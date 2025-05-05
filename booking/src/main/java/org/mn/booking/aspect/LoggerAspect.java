package org.mn.booking.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAspect {


    // Before, After, AfterReturning, AfterThrowing, Around

//    @Before(value = "@annotation(org.springframework.transaction.annotation.Transactional)",
//            argNames = "joinPoint")

//    @Before(value = "execution(* org.mn.booking.service.*.*(*))",
//            argNames = "joinPoint")
//    public void logBefore(JoinPoint joinPoint) {
//        System.out.println("Before Method name: " + joinPoint.getSignature().getName());
//
//        CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();
//        String[] sigParamNames = codeSignature.getParameterNames();
//        Object[] args = joinPoint.getArgs();
//
//        for(int i = 0; i < sigParamNames.length; i++) {
//            System.out.println("Parameter Name: " + sigParamNames[i]);
//            System.out.println("Parameter Type: " + args[i].getClass());
//            System.out.println("Parameter Value: " + args[i]);
//        }
//    }
//
//    @After(value = "execution(* org.mn.booking.service.*.*(..))", argNames = "joinPoint")
//    public void logAfter(JoinPoint joinPoint) {
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//
//        System.out.println("After Method response type: " + methodSignature.getReturnType());
//    }


//    @AfterReturning(value = "execution(* org.mn.booking.service.*.*(*))",
//            argNames = "joinPoint, object", returning = "object")
//    public void logAfterReturning(JoinPoint joinPoint, Object object) {
//
//        Class<?> aClass = object.getClass();
//
//        System.out.println("AfterReturning Method response type: " + aClass);
//        System.out.println("AfterReturning Method response value: " + object);
//    }
//
//    @AfterThrowing(value = "execution(* org.mn.booking.service.*.*(..))",
//            argNames = "joinPoint, exception",  throwing = "exception")
//    public void logAfterReturning(JoinPoint joinPoint, Exception exception) {
//        System.out.println("AfterThrowing Method exception type: " + exception.getClass());
//        System.out.println("AfterThrowing Method exception message: " + exception.getMessage());
//    }


//    @Around(value = "execution(* org.mn.booking.service.*.*(..))",
//            argNames = "joinPoint")
//    public void logAround(JoinPoint joinPoint) {
//        System.err.println("Around Method name: " + joinPoint.getSignature().getName());
//
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//
//        String[] sigParamNames = methodSignature.getParameterNames();
//        Object[] args = joinPoint.getArgs();
//
//        for(int i = 0; i < sigParamNames.length; i++) {
//            System.err.println("Parameter Name: " + sigParamNames[i]);
//            System.err.println("Parameter Type: " + args[i].getClass());
//            System.err.println("Parameter Value: " + args[i]);
//        }
//
//        System.err.println("Around Method response type: " + methodSignature.getReturnType());
//    }


}
