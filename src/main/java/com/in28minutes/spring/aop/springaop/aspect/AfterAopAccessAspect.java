package com.in28minutes.spring.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AfterAopAccessAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //AfterReturning is called when a method executes successfully
    @AfterReturning(
            value = "execution(* com.in28minutes.spring.aop.springaop.business.*.*(..))",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, Object result){
        logger.info("{} returned with value {}", joinPoint, result);
    }

    //AfterReturning is called when a method throws an exception
    @AfterThrowing(
            value = "execution(* com.in28minutes.spring.aop.springaop.business.*.*(..))", throwing = "exception"
    )
    public void afterThrowing(JoinPoint joinPoint, Exception exception){
        logger.info("{} returned with value {}", joinPoint, exception);
    }

    //After is called in both scenarios (exception or success)
    @After(value = "execution(* com.in28minutes.spring.aop.springaop.business.*.*(..))")
    public void after(JoinPoint joinPoint){
        logger.info("after execution of {}", joinPoint);
    }
}
