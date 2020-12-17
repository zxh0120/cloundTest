package com;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 参考 https://blog.csdn.net/DreamsArchitects/article/details/108513742?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.add_param_isCf&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.add_param_isCf
 */
@Component
@ConfigurationProperties(value = "iosetting")
@Data
public class IoSetting {

    private String filePath;
    private int bufferSize;
    private int charSize;
}
