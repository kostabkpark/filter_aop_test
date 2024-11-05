package org.example.filter_test.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
//@Slf4j
//public class MeasurePerformance {
//
//    @Around("execution(* org.example.filter_test..*(..))")
//    public void measurePerformance(ProceedingJoinPoint pjp) throws Throwable {
//        long start = System.nanoTime();;
//        pjp.proceed();
//        long end = System.nanoTime();
//        log.info("Aspect measurePerformance : {} ms", end - start);
//    }
//}
