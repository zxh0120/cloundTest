package com.design.command;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 命令模式
 * 具体命令角色类
 * @since 2021/4/7
 **/
public class ConcreteCommand implements Command {
    /**
     * 持有相应的接收者对象
     */
    private Receiver receiver = null;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        //通常会转调接收者的映射方法，让接收者来真正执行功能
        receiver.action();
    }
}
