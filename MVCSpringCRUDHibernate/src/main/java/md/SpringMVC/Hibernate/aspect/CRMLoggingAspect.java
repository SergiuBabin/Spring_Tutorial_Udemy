package md.SpringMVC.Hibernate.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;
import java.util.List;
/**
 * @author Babin Sergiu
 */

@Aspect
@Component
public class CRMLoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* md.SpringMVC.Hibernate.controller.*.*(..))")
    private void forControllerPackage() {

    }

    @Pointcut("execution(* md.SpringMVC.Hibernate.service.*.*(..))")
    private void forServicePackage() {

    }

    @Pointcut("execution(* md.SpringMVC.Hibernate.dao.*.*(..))")
    private void forDAOPackage() {

    }

    @Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
    private void forAppFlow() {

    }


    @Before("forAppFlow()")
    private void before(JoinPoint theJoinPoint) {

        String theMethod = theJoinPoint.getSignature().toShortString();
        logger.info("=========>>>>> in @Before : calling method: " + theMethod);


        Object[] obj = theJoinPoint.getArgs();

        for (Object o : obj) {
            System.out.println("======>> argument = " + o);
        }
    }

    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "result")
    private void afterReturning(JoinPoint theJoinPoint, Object result) {

        String theMethod = theJoinPoint.getSignature().toShortString();
        logger.info("=========>>>>> in @AfterReturning : calling method: " + theMethod);

        logger.info("=========>>>>>  result : " + result);
    }
}
