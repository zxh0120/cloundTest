package com.algorithm;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 需求：
 * 1.定义一个学生类Student，具有年龄age和姓名name两个属性，并通过Comparable接口提供比较规则；
 * 2.比较两个学生年龄大小，Comparable getMax(Comparable c1,Comparable c2)完成测试
 * @since 2021/5/28
 **/
@Data
@Builder
@Slf4j
public class Student implements Comparable<Student> {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    //定义比较规则
    @Override
    public int compareTo(Student o) {
        return this.age - o.age;
    }

    public static void main(String[] args) {
        Student stu1 = Student.builder().name("zhangsan").age(11).build();
        log.info(String.valueOf(stu1));
        Student stu2 = Student.builder().name("lisi").age(12).build();
        log.info(String.valueOf(stu2));
        Comparable max = getMax(stu1, stu2);
        System.out.println(max);
    }

    //测试方法，获取两个元素中的较大值
    public static Comparable getMax(Comparable c1, Comparable c2) {
        int cmp = c1.compareTo(c2);
        if (cmp >= 0) {
            return c1;
        } else {
            return c2;
        }
    }
}



