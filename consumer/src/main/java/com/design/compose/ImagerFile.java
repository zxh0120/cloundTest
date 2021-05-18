package com.design.compose;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 组合模式
 * @since 2021/3/31
 **/
@Slf4j
public class ImagerFile extends CustomizeFile {
    public ImagerFile(String name) {
        super(name);
    }

    @Override
    public void display() {
        log.info("这是图像文件，文件名：{}",super.getName());
    }
}
