package com.design.command;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 命令模式
 * 客户端角色类
 * @since 2021/4/7
 **/
public class Client {
    public static void main(String[] args) {
        //创建接收者
        Receiver receiver = new Receiver();
        //创建命令对象，设定其接收者
        Command command = new ConcreteCommand(receiver);
        //创建请求者，把命令对象设置进去
        Invoker invoker = new Invoker(command);
        //执行方法
        invoker.action();
    }
}
