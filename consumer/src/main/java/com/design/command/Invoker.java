package com.design.command;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 命令模式
 * 请求者角色类
 * @since 2021/4/7
 **/
public class Invoker {

    /**
     * 持有命令对象
     */
    private Command command = null;

    public Invoker(Command command) {
        this.command = command;
    }

    /**
     * 行动方法
     */
    public void action() {
        command.execute();
    }
}
