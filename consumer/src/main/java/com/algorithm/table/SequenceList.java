package com.algorithm.table;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 顺序表
 * @since 2021/5/28
 **/
public class SequenceList<T> {
    //存储元素的数组
    private T[] eles;
    //记录当前顺序表中的元素
    private int N;

    //构造方法
    public SequenceList(int capacity) {
        eles = (T[]) new Object[capacity];
        N = 0;
    }

    //将一个线性表置为空表
    public void clear() {
        N = 0;
    }

    //判断当前线性表是否为空表
    public boolean isEmpty() {
        return N == 0;
    }

    //获取线性表的长度
    public int length() {
        return N;
    }

    //获取指定位置的元素
    public T get(int i) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("当前元素不存在！ ");
        }
        return eles[i];
    }

    //向线型表中添加元素t
    public void insert(T t) {
        if (N == eles.length) {
            throw new RuntimeException("当前表已满");
        }
        eles[N++] = t;
    }

    //在i元素处插入元素t
    public void insert(int i, T t) {
        if (i == eles.length) {
            throw new RuntimeException("当前表已满");
        }
        if (i < 0 || i >= N) {
            throw new RuntimeException("插入的位置不合法");
        }
        //把i位置空出来，i位置及其后面的元素依次向后移动一位
        for (int index = N; index > i; index--) {
            eles[index] = eles[index - 1];
        }
        //把t放到i位置处
        eles[i] = t;
        //元素数量+1
        N++;
    }

    //删除指定位置i处的元素，并返回该元素
    public T remove(int i) {
        if (i < 0 || i > N - 1) {
            throw new RuntimeException("当前要删除的元素不存在");
        }
        //记录i位置处的元素
        T result = eles[i];
        //把i位置后面的元素都向前移动一位
        for (int index = i; index < N - 1; index++) {
            eles[index] = eles[index + 1];
        }
        //当前元素数量-1
        N--;
        return result;
    }

    //查找t元素第一次出现的位置
    public int index(T t) {
        if (t == null) {
            throw new RuntimeException("查找的元素不合法");
        }
        for (int i = 0; i < N; i++) {
            if (eles[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }


}
