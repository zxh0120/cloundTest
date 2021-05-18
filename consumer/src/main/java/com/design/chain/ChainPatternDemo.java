package com.design.chain;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description 责任链模式
 * 实现：我们创建抽象类 AbstractLogger，带有详细的日志记录级别。然后我们创建三种类型的记录器，
 * 都扩展了 AbstractLogger。每个记录器消息的级别是否属于自己的级别，
 * 如果是则相应地打印出来，否则将不打印并把消息传给下一个记录器。
 * <p>
 * 创建不同类型的记录器。赋予它们不同的错误级别，并在每个记录器中设置下一个记录器。
 * 每个记录器中的下一个记录器代表的是链的一部分。
 * @since 2021/4/6
 **/
public class ChainPatternDemo {
    public static void main(String[] args) {
        AbstractLogger loggerChina = getChainOfLogger();
//        loggerChina.logMessage(AbstractLogger.INFO, "This is an information.");

//       loggerChina.logMessage(AbstractLogger.DEDUG, " This is an debug information");
        loggerChina.logMessage(AbstractLogger.ERROR, "This is an error information");
    }

    private static AbstractLogger getChainOfLogger() {
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);
        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);
        return errorLogger;
    }
}
