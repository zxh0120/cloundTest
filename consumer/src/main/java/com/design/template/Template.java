package com.design.template;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 模板模式
 * @since 2021/4/13
 **/
public class Template {
    public static void main(String[] args) {
        Abstract baoCai=new ConcreteClass_BaoCai();
        baoCai.cookProcess();
        Abstract caiXin =new ConcreteClass_CaiXin();
        caiXin.cookProcess();
    }
}
