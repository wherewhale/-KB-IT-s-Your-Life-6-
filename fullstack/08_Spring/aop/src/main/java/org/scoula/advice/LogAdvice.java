package org.scoula.advice;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect //Aspect임을 명시
@Log4j2
@Component // Bean 등록
public class LogAdvice {
    // Pointcut : SampleService의 모든 메소드를 대상으로 하겠다.
    // 모든 메서드가 JoinPoint가 된거임
    @Before("execution(* org.scoula.sample.service.SampleService*.*(..))")
    public void logBefore() {
        log.info("==================================");
    }

    //&&를 통해서 args에서 매개변수를 어떻게 받을지에 대해 정의한 거임
    @Before("execution(* org.scoula.sample.service.SampleService*.doAdd(String, String)) && args(str1, str2)")
    public void logBeforeWithParam(String str1, String str2) {
        log.info("str1:" + str1);
        log.info("str2:" + str2);
    }

    // 예외 매개변수 (throwing="exception")를 통해서 어떤 예외인지 확인할 수 있도록 처리
    @AfterThrowing(pointcut = "execution(* org.scoula.sample.service.SampleService*.*(..))", throwing="exception")
    public void logException(Exception exception) {
        log.info("Exception...!!!!");
        log.info("exception: " + exception);
    }

    @Around("execution(* org.scoula.sample.service.SampleService*.*(..))")
    public Object logTime(ProceedingJoinPoint pjp) {
        long start = System.currentTimeMillis();
        log.info("Target: " + pjp.getTarget());
        log.info("Param: " + Arrays.toString(pjp.getArgs()));
        Object result = null;
        try {
            result = pjp.proceed(); // 실제 메서드 호출
        } catch(Throwable e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        log.info("TIME: " + (end - start));
        return result;
    }
}
