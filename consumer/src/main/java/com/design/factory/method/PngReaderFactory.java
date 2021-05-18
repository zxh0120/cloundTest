package com.design.factory.method;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 工厂方法模式
 *              Png加载器工厂
 * @since 2021/3/17
 **/
public class PngReaderFactory implements ReaderFactory {
    @Override
    public Reader reader() {
        return new PngReader();
    }
}
