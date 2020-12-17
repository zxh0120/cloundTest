package com.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Slf4j
public class Interceptor implements HandlerInterceptor {
    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     * 方法返回值如果设置为false时，被请求时，拦截器执行到此处将不会继续操作
     * 如果设置为true时，请求将会继续执行后面的操作
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        log.info("preHandle-----------ok");
        boolean flag = true;
        if (handler instanceof ResourceHttpRequestHandler) {
            log.info("---------ResourceHttpRequestHandler-------" + handler.toString() + "------------");
        } else if (handler instanceof HandlerMethod) {
            log.info("--------HandlerMethod--------" + handler.toString() + "------------");
            String ip = request.getRemoteAddr();
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            //类名
            String controllerName = handlerMethod.getBeanType().getSimpleName().replace("Contorller", "");
//            log.info("class:{}", controllerName);
            Method method = handlerMethod.getMethod();
//            log.info("Request URL:{} ", request.getRequestURL());
//            log.info("用户:" + ip + ",访问目标类:" + method.getDeclaringClass().getName() + ",方法" + method.getName());
        }

        return flag;
    }

    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           @Nullable ModelAndView modelAndView) throws Exception {
//        log.info("postHandle-----------------ok");
    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) throws Exception {
//        log.info("afterCompletion---------------------ok");
    }

}
