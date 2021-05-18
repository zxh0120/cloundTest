package com.drools.util;

import org.kie.api.runtime.KieSession;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description
 * @since 2021/4/15
 **/
public class DroolsScoreExampleTest {
    public static void main(String[] args) {

        // 通过工具类去获取KieSession
//        KieSession ksession = DroolsUtil.getKieSessionByName("simpleRuleKSession");
//
//        List<Person> orderList = getInitData();
//        try {
//            for (int i = 0; i < orderList.size(); i++) {
//                Person person = orderList.get(i);
//                ksession.insert(person);
//                ksession.fireAllRules();
//                // 执行完规则后, 执行相关的逻辑
//                // addScore(person);
//            }
//            int count = ksession.fireAllRules();
//            System.out.println("总执行了" + count + "条规则------------------------------");
//        } catch (Exception e) {
//
//        } finally {
//            ksession.destroy();
//        }

    }

//    private static List<Person> getInitData() {
//
//        Person p1 = new Person("白展堂", 68);
//        Person p2 = new Person("李大嘴", 32);
//        Person p3 = new Person("佟湘玉", 18);
//        Person p4 = new Person("郭芙蓉", 8);
//        Person p5 = new Person("祝无双", 66);
//        List<Person> list = new ArrayList<>();
//        list.add(p1);
//        list.add(p2);
//        return list;
//    }
}
