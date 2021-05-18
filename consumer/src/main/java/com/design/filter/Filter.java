package com.design.filter;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 过滤器模式
 * 过滤器（Filter） - 过滤器在请求处理程序执行请求之前或之后，执行某些任务
 * @since 2021/3/30
 **/
public interface Filter {
    void execute(String request);
}
