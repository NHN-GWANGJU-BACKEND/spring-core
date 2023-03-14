package com.nhnacademy.edu.springframework.messagesender.logging;

import com.nhnacademy.edu.springframework.messagesender.annotation.Logging;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
@EnableAspectJAutoProxy
public class SenderAspect {
    @Around("@annotation(logging) && args(name)")
    public Object doAccess(ProceedingJoinPoint pjp , Logging logging, String name) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        try {
            stopWatch.start();
            Object retVal = pjp.proceed();
            System.out.println("===============================================");
            System.out.println("signature name : " + pjp.getSignature().getName());
            System.out.println("annotation value : " + logging.value());
            System.out.println("aop args : " + name);
            System.out.println("===============================================");
            return retVal;
        }finally {
            stopWatch.stop();
            System.out.println(stopWatch.prettyPrint());
        }
    }

}
