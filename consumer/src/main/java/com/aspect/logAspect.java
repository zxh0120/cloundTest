package com.aspect;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 切面配置类
 *
 * @Aspect注解是表示该类为切面类，@Component注解是将切面类加入到Ioc容器中。
 * @Pointcut定义切入点为整个controller包下的所有函数。 joinPoint.getArgs()获取目标方法的参数信息。
 * joinPoint.getSignature()获取通知的签名，
 * 并且通过joinPoint.getSignature().getDeclaringTypeName()获取代理类的名字，
 * joinPoint.getSignature().getName()获取代理方法的名字。
 * 参考链接
 * https://juejin.cn/post/6844904121883951117
 */
@Aspect
@Component
@Slf4j
public class logAspect {

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    /**
     * 定义切入点，以controller下所有包的请求为切入点
     */
    @Pointcut("execution(public * com.controller..*.*(..))*")
    public void weblog() {

    }

    /**
     * 前置通知：在切入点之前执行的通知
     *
     * @param joinPoint
     * @throws Throwable
     */
    @Before("weblog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        startTime.set(System.currentTimeMillis());
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.
                getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        //打印请求相关参数
        log.info("========================================== Start ==========================================");
        log.info("URL：" + request.getRequestURL().toString());
        log.info("HTTP_METHOD：" + request.getMethod());


        //header第一种格式展示
        Enumeration<String> enumeration = request.getHeaderNames();
        Map<String, String> headerMap = new HashMap<>();
        while (enumeration.hasMoreElements()) {
            String headerName = enumeration.nextElement();
            headerMap.put(headerName, request.getHeader(headerName));
        }
        String headerJsonStr = JSON.toJSONString(headerMap);
        if (headerJsonStr.length() > 0) {
            log.info("HTTP_HEADERS INFO IS: {}", headerJsonStr);
        }

        //header第二种格式展示
        log.info("HTTP_HEADERS: ");
        Enumeration<?> enumeration1 = request.getHeaderNames();
        while (enumeration1.hasMoreElements()) {
            String key = (String) enumeration1.nextElement();
                 String value = request.getHeader(key);
            log.info("     {}: {}", key, value);
        }

        log.info("IP：" + request.getRemoteAddr());

        log.info("CLASS_METHOD：" + joinPoint.getSignature().getDeclaringTypeName() + "." +
                joinPoint.getSignature().getName());
        try {
            log.info("REQUEST BODY : [{}]", JSON.toJSONString(joinPoint.getArgs()[0]));
//            log.info("ARGS：{}", Arrays.toString(joinPoint.getArgs()));
        } catch (Exception e) {
            log.error("REQUEST BODY PARSE ERROR!");
        }

        HttpSession session = (HttpSession) servletRequestAttributes.resolveReference(
                RequestAttributes.REFERENCE_SESSION);
        log.info("SESSION ID：" + session.getId());


    }


//    /**
//     * 后置通知
//     * @param ret
//     * @throws Throwable
//     */
//    @AfterReturning(returning = "ret", pointcut = "weblog()")
//    public void doAfterReturning(Object ret) throws Throwable {
//        // 处理完请求，返回内容
//        log.info("RESPONSE : " + ret);
//        log.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
//
//    }

    /**
     * 后置最终通知
     * @throws Throwable
     */
    @After("weblog()")
    public void doAfter() throws Throwable {
        log.info("=========================================== End ===========================================");
        // 每个请求之间空一行
        log.info("");
    }
    /**
     * 环绕通知
     * 环绕通知第一个参数必须是org.aspectj.lang.ProceedingJoinPoint类型
     *
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("weblog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        String resultStr = JSON.toJSONString(result);
        // 打印出参
        log.info("RESPONSE ARGS  : {}", resultStr);
        // 执行耗时
        log.info("TIME-CONSUMING : {} ms", System.currentTimeMillis() - startTime);
        return result;
    }

}



