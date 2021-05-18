package com.design.builder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 建造者模式
 * 对象电脑
 * @since 2021/3/25
 **/
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Computer {
    // cpu
    private String cpu;
    //硬盘
    private String hardDisk;
    // 主板
    private String mainBoard;
    // 内存
    private String memory;
}
