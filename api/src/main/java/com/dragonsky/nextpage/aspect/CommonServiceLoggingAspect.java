package com.dragonsky.nextpage.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class CommonServiceLoggingAspect {

    @Around("execution(* com.dragonsky.nextpage.*.domain.service..*(..))")
    public Object logServiceExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().toShortString();

        long start = System.currentTimeMillis();
        log.info("Service Method Start: {}", methodName);

        Object result = joinPoint.proceed();

        long duration = System.currentTimeMillis() - start;
        log.info("Service Method End: {} duration={}ms", methodName, duration);

        return result;
    }
}
