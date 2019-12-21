package com.gjh.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class LogAspect {
    private  final  static Logger logger= LoggerFactory.getLogger(LogAspect.class);
@Pointcut("execution(* com.gjh.controller.*.*(..))")
	public void log()
{


}

@Before("log()")
	public void logbefore(JoinPoint joinPoint)
{
    ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    HttpServletRequest request=attributes.getRequest();
    logger.info("url={}",request.getRequestURI());
    logger.error("url={}","error"+request.getRequestURI());
    logger.debug("url={}","debug"+request.getRequestURI());
    logger.info("method={}",request.getMethod());
    logger.info("ip={}",request.getRemoteAddr());
    logger.info("classmethod={}",joinPoint.getSignature().getDeclaringTypeName()+"_"+joinPoint.getSignature().getName());
    logger.info("args={}",joinPoint.getArgs());
}

@AfterReturning(pointcut="log()",returning="object")
	public void logAfterReturn(Object object)
{
    logger.info("response={}",object);

}
            }

