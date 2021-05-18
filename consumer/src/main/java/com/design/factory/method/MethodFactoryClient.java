package com.design.factory.method;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 工厂方法模式
 *           分别读取了不同格式的图片，不同之处在于针对不同的图片格式声明了不同的工厂，进而创建了相应的图片加载器
 * @since 2021/3/17
 **/
public class MethodFactoryClient {
    public static void main(String[] args) {
        //读取Jpg
        ReaderFactory readerFactory = new JpgReaderFactory();
        Reader reader = readerFactory.reader();
        reader.read();
        //读取Png
        ReaderFactory readerFactory1 = new PngReaderFactory();
        Reader reader1 = readerFactory1.reader();
        reader1.read();
        //读取Gif
        ReaderFactory readerFactory2 = new GifReaderFactory();
        Reader reader2 = readerFactory2.reader();
        reader2.read();
    }
}
