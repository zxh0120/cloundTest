package com.design.filter;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 过滤器模式
 * @since 2021/3/30
 **/
public class Client {
    public static void main(String[] args) {
        FilterManager filterManager = new FilterManager();
        filterManager.setFilter(new AuthenticationFilter());
        filterManager.setFilter(new DebugFilter());
        filterManager.filterRequest("Home");
    }
}
