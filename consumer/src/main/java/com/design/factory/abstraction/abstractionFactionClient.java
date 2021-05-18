package com.design.factory.abstraction;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 抽象工厂
 *              针对不同平台只通过创建不同的工厂对象就完成了操作和UI控制器的创建
 *        需求：现在需要做一款跨平台的游戏，需要兼容Android，Ios，Wp三个移动操作系统，
 *              该游戏针对每个系统都设计了一套操作控制器（OperationController）和界面控制器（UIController）
 * @since 2021/3/18
 **/
public class abstractionFactionClient {
    public static void main(String[] args) {
        SystemFactory systemFactory = null;
        UIController uiController = null;
        OperationController operationController = null;
        //Android工厂
//        systemFactory = new AndroidFactory();
        //Ios工厂
        systemFactory = new IosFactory();
        //Wp工厂
        //   systemFactory = new WpFactory();

        uiController = systemFactory.createUIController();
        uiController.display();

        operationController = systemFactory.createOperationController();
        operationController.control();
    }
}
