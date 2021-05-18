package com.design.adapter;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 适配器模式
 * 创建适配器类（Adapter）
 * @since 2021/3/26
 **/
public class Adapter220V extends PowerPort220V implements Target {
    /**
     * 期待的插头要求调用Convert_110v()，但原有插头没有
     * 因此适配器补充上这个方法名
     * 但实际上Convert_110v()只是调用原有插头的Output_220v()方法的内容
     * 所以适配器只是将Output_220v()作了一层封装，封装成Target可以调用的Convert_110v()而已
     */
    @Override
    public void Convert_110v() {
        this.Output_220v();
    }

}
