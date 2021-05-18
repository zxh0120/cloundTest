package com.design.filter;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 过滤器模式
 * 过滤管理器（Filter Manager） - 过滤管理器管理过滤器和过滤器链
 * @since 2021/3/30
 **/
public class FilterManager {
    FilterChain filterChain;

    public FilterManager() {
        filterChain = new FilterChain();
    }

    public void setFilter(Filter filter) {
        filterChain.addFilter(filter);
    }

    public void filterRequest(String request) {
        filterChain.execute(request);
    }

}
