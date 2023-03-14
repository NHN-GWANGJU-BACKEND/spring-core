package com.nhnacademy.edu.springframework.project.aop;

import com.nhnacademy.edu.springframework.project.annotation.Logging;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.util.StopWatch;

@EnableAspectJAutoProxy(proxyTargetClass = true)
@Configuration
@Aspect
public class TimeLogging {

    @Around("@annotation(logging)")
    public Object doLogging(ProceedingJoinPoint pjp, Logging logging) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        try {
            stopWatch.start();
            Object retVal = pjp.proceed();
            return retVal;
        } finally {
            stopWatch.stop();
            System.out.println("=========================================================");
            System.out.println();
            System.out.println("[" + pjp.getTarget().getClass().toString().split("\\.")[6] + "].["
                    + pjp.getSignature().getName() + "] " +
                    "[" + stopWatch.getTotalTimeMillis() + "ms]");
            System.out.println();
            System.out.println("=========================================================");
        }
    }

}
