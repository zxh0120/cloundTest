package com.design.singleton;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 单例模式的懒汉式 （线程不安全）
 * 懒汉模式申明了一个静态对象，在用户第一次调用时初始化，虽然节约了资源，但第一次加载时需要实例化，反映稍慢一些，而且在多线程不能正常工作。
 * @since 2021/3/24
 **/
public class Idler {
    private static Idler idler;

    private Idler() {
    }

    public static Idler getIdler() {
        if (idler == null) {
            idler = new Idler();
        }
        return idler;
    }
}
