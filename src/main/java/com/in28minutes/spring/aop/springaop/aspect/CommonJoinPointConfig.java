package com.in28minutes.spring.aop.springaop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {

    @Pointcut("execution(* com.in28minutes.spring.aop.springaop.data.*.*(..))")
    public void dataLayerExecution(){};

    @Pointcut("execution(* com.in28minutes.spring.aop.springaop.business.*.*(..))")
    public void businessLayerExecution(){};

    @Pointcut("com.in28minutes.spring.aop.springaop.aspect.CommonJoinPointConfig.dataLayerExecution() && com.in28minutes.spring.aop.springaop.aspect.CommonJoinPointConfig.businessLayerExecution()")
    public void allLayerExecution(){}

    //would intercept any bean containing dao
    @Pointcut("bean(*dau*)")
    public void beanContainingDao(){}

    @Pointcut("within(*com.in28minutes.spring.aop.springaop.data..*)")
    public void dataLayerExecutionWithWithin(){}

    @Pointcut("@annotation(com.in28minutes.spring.aop.springaop.aspect.TrackTime)")
    public void trackTimeAnnotation(){}

}
