package org.example.spring_ex.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class Logging {
  @Before("execution(* org.example.spring_ex.controller.PostWebController.*(..))")
  public void leaveLog(JoinPoint jp) {
    String methodName = jp.getSignature().getName();
    String className = jp.getTarget().getClass().getName();
    log.info(" {} : {} 의 실행 전 로그 ", className, methodName);
  }
}
