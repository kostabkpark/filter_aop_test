package org.example.filter_test.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class Logging {

    @Before("execution(* org.example.filter_test.controller.LoginController.*(..))")
    //@Before("execution(* *(..))")  url pattern 이 맞지 않아 오류 발생
    public void leavingLog(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        String className = jp.getTarget().getClass().getSimpleName();
        log.info("{} : {} 가 실행되기 전 ", className, methodName);
    }
}
