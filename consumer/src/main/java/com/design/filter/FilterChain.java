package com.design.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 过滤器模式
 * 过滤器链（Filter Chain） - 过滤器链带有多个过滤器
 * @since 2021/3/30
 **/
public class FilterChain {

    private List<Filter> filters = new ArrayList<>();

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    public void execute(String request) {
        for (Filter filter : filters) {
            filter.execute(request);
        }
    }
}
