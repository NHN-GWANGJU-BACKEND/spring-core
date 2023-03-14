package com.nhnacademy.edu.project.aspect;

import com.nhnacademy.edu.project.service.log.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.util.StopWatch;


@Configuration
@Aspect
public class Logging {


    LogService logService = new LogService();

    @Around("bean(*)")  //execution(* com.nhnacademy.edu.project.*.*.*(..))
    public Object doLogging(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        try {
            stopWatch.start();
            Object retVal = pjp.proceed();
            return retVal;
        } finally {
            stopWatch.stop();
            logService.info("[" + pjp.getTarget().getClass() + "].["
                    + pjp.getSignature().getName() + "] " +
                    "[" + stopWatch.getTotalTimeMillis() + "ms]\n");
        }
    }

}
