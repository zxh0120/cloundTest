package com.design.strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 策略模式
 * 具体策略类
 * @since 2021/4/13
 **/
@Slf4j
public class ConcreteStrategyA implements Strategy {
    @Override
    public void algorithmLogic() {
        // 具体的算法逻辑（输了比赛）
        log.info("第一场：上等马vs上等马  第二场：中等马vs中等马  第三场：下等马vs下等马  赛果：输！");
    }
}
