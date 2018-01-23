package com.pengkey.security.compent;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
@Configuration
public class WebLogAspect {
    private Logger logger= LoggerFactory.getLogger(WebLogAspect.class);


    @Pointcut("execution(public * com.pengkey.security..*.*(..))")
    public void webLog(){

    }

    @Before("webLog()")
    public void doBofore(JoinPoint joinPoint){
       //获取request
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        logger.info("URL: "+request.getRequestURI().toString());
        logger.info("HTTP_METHOD "+request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));


    }

    @AfterReturning(returning = "ret",pointcut = "webLog()")
    public void doAffterReturn(Object ret) throws Exception{
        logger.info("RESPONSE: "+ret);
    }



}
