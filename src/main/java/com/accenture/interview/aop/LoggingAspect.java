package com.accenture.interview.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.accenture.interview.service.*.*(..))")
    public void serviceMethods() {
    }

    @Around("serviceMethods()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        LOG.info("Invoked method: {}", joinPoint.getSignature());
        Object result = joinPoint.proceed();
        LOG.info("Response from {} is {}", joinPoint.getSignature().getName(), result);
        return result;
    }

}

