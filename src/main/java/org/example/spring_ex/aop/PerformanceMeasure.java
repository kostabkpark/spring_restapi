package org.example.spring_ex.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class PerformanceMeasure {

  @Around("execution(* org.example.spring_ex.service.Post*.*(..))")
  public Object measure(ProceedingJoinPoint pjp) throws Throwable {
    long start = System.currentTimeMillis();
    Object result = pjp.proceed();
    long end = System.currentTimeMillis();
    log.info("Aspect performance measure: {} : {} - {} ms 가 소요됨 " ,
            pjp.getTarget().getClass().getName(),
            pjp.getSignature().getName(),
            (end - start));
    return result;
  }
}
