package com.design.builder;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 建造者模式
 * 具体的建造者，这里是商场的一个装机人员
 * @since 2021/3/25
 **/
public class AssemblerBuilder implements Builder {
    private Computer computer = new Computer();
    @Override
    public void createMainBoard(String mainBoard) {
        computer.setMainBoard(mainBoard);
    }
    @Override
    public void createCpu(String cpu) {
        computer.setCpu(cpu);
    }
    @Override
    public void createhardDisk(String hardDisk) {
        computer.setHardDisk(hardDisk);
    }
    @Override
    public void createMemory(String memory) {
        computer.setMemory(memory);
    }
    @Override
    public Computer createComputer() {
        return computer;
    }
}
