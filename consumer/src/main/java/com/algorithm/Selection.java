package com.algorithm;

import java.util.Arrays;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 选择排序
 * 1.每次遍历的过程中，都假定第一索引处的元素是最小值，和其他索引处的值依次进行比较，如果当前索引处的值大于
 * 其他某个索引处的值，则假定其他某个索引处的值为最小值，最后可以找到最小值所在的索引。
 * 2.交换第一个索引处和最小值所在的索引处的值。
 * @since 2021/5/28
 **/
public class Selection {
    /**
     * 对数组a中的元素进行排序
     *
     * @param a
     */
    public static void sort(Comparable[] a) {
        for (int i = 0; i <= a.length - 2; i++) {
            //假定本次遍历，最小值所在的索引是i
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (greater(a[minIndex], a[j])) {
                    //跟换最小值所在的索引
                    minIndex = j;
                }
            }
            //交换i索引处和minIndex索引处的值
            exch(a, i, minIndex);
        }
    }

    /**
     * 比较v元素是否大于w元素
     *
     * @param v
     * @param w
     * @return
     */
    private static boolean greater(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }

    /**
     * 数组元素i和j交换位置
     *
     * @param a
     * @param i
     * @param j
     */
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        Integer[] a = {4, 6, 8, 7, 9, 2, 10, 1};
        Selection.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
