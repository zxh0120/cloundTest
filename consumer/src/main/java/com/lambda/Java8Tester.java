package com.lambda;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description lambda 表达式的重要特征 ：
 * 1.可选类声明：不需要声明参数类型，编译器可以统一识别参数值。
 * 2.可选的参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号。
 * 3.可选的大括号：如果主体包含一个语句，就不需要使用大括号。
 * 4.可选的返回关键字：如果主体只有一个表达式返回值则编译器会自动返回值，大括号需要指明表达式返回一个数值。
 * @since 2021/4/21
 **/
public class Java8Tester {
    public static void main(String[] args) {
        Java8Tester tester = new Java8Tester();
        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;
        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;
        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> {
            return a * b;
        };
        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;


        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        // 不用括号
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        // 用括号
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        greetService1.sayMessage("Runoob");
        greetService2.sayMessage("Google");
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
}
