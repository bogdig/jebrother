package com.ergou.jebrother.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

import ch.qos.logback.classic.Logger;

/**
 * @Author: 孙二狗
 * @Date: Created in 7:31 PM 2018/12/11
 */

@Aspect
@Component
@Configuration
public class AopAspect {

    @Pointcut(value = "execution(public * com.ergou.jebrother.web.SoldController.*(..))")
    public void soldExecution(){}

    private static final Logger logger = (Logger) LoggerFactory.getLogger(AopAspect.class);

    private long startTime;
    private long endTime;

    @Before(value = "soldExecution()")
    public void before(JoinPoint joinPoint) {
        logger.info("前置切面...");
        startTime = System.currentTimeMillis();
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest servletRequest = requestAttributes.getRequest();
        String sessionId = requestAttributes.getSessionId();
        String requestUrl = servletRequest.getRequestURI();
        String remoteAddr = servletRequest.getRemoteAddr();
        String requestMethod = servletRequest.getMethod();
        String declaringTypeName = joinPoint.getSignature().getDeclaringTypeName();
        Object[] args = joinPoint.getArgs();
        String methodName = joinPoint.getSignature().getName();
        logger.info(
                "请求url=" + requestUrl +
                        ",客户端ip=" + remoteAddr +
                        ",请求方式=" + requestMethod +
                        ",请求的类名=" + declaringTypeName +
                        ",方法名=" + methodName +
                        ",入参=" + args +
                        ",startTime=" + startTime);

    }

    @After(value = "soldExecution()")
    public void after() {
        endTime = System.currentTimeMillis() - startTime;
        logger.info("后置切面...endTime = " + endTime);
    }

}
