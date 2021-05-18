package com.design.adapter;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 适配器模式
 * 创建源类（原有的插头）
 * @since 2021/3/26
 **/
@Slf4j
public class PowerPort220V {
    //原有插头只能输出220V
    public void Output_220v() {
      log.info("220V");
    }
}
