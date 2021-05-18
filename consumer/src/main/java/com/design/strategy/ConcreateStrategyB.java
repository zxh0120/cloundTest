package com.design.strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description
 * @since 2021/4/13
 **/
@Slf4j
public class ConcreateStrategyB implements Strategy {
    @Override
    public void algorithmLogic() {
        // 赢
        log.info("第一场：下等马vs上等马  第二场：上等马vs中等马  第三场：中等马vs下等马  赛果：赢！");
    }
}
