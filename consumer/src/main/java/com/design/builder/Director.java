package com.design.builder;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 建造者模式
 * 声明一个导演类「指挥者，这里可以装电脑的老板」，用来指挥组装过程，也就是组装电脑的流程
 * @since 2021/3/25
 **/
public class Director {
    private Builder builder;
    // 使用多态，装机工非常多，我管你小美，小兰，小猪，我统统收了
    public Director(Builder builder) {
        this.builder = builder;
    }
    // 老板最后只想看到装成的成品---要交到客户手中
    public Computer createComputer(String cpu, String hardDisk, String mainBoard, String memory) {
        // 具体的工作是装机工去做
        this.builder.createMainBoard(mainBoard);
        this.builder.createCpu(cpu);
        this.builder.createMemory(memory);
        this.builder.createhardDisk(hardDisk);
        return this.builder.createComputer();
    }
}
