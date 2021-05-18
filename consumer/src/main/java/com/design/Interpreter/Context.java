package com.design.Interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 解释器模式
 * 环境类
 * @since 2021/4/8
 **/
public class Context {
    private Map<Variable, Boolean> map = new HashMap<>();

    public void assign(Variable var, boolean value) {
        map.put(var, new Boolean(value));
    }

    public boolean lookup(Variable var) throws IllegalArgumentException {
        Boolean value = map.get(var);
        if (value == null) {
            throw new IllegalArgumentException();
        }
        return value.booleanValue();
    }
}
