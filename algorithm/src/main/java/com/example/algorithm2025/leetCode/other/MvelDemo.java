package com.example.algorithm2025.leetCode.other;
import org.mvel2.MVEL;

import java.util.HashMap;
import java.util.Map;

public class MvelDemo {
    public static void main(String[] args) {
/*        // java 语法
        int result = 1 + 2;
        System.out.println(result); // 结果：3

        // mvel 语法
        Object res = MVEL.eval("1 + 2");
        System.out.println(res); // 结果：3*/
//        String rule = "item.price > 1000 ? item.price * 0.9 : item.price";
//        Item item = new Item(1200);
//        Map<String,Object> vars = new HashMap<String,Object>();
//        vars.put("item", item);
//        Object discountedPrice = MVEL.eval(rule, vars);
//        System.out.println(discountedPrice);

        // 提供一个上下文对象
//        Flight flight = new Flight();
//        flight.setSeat("101");
//        flight.setFlightIndicator("D");
//        flight.setAirlineCode("CA");
//
//        // 准备我们的表达式
//        String expression = "['101','102','103','104','105','106','106L','106R','108L','108R','110','111','111L','111R','113','114','115','116','117','118','119','120','121','122','123','1234','124','125','126','127','128'].contains(seat) && flightIndicator == 'D' && airlineCode!='MU'";
//
//        // 使用 MVEL 评估 expression
//        Boolean result = MVEL.evalToBoolean(expression, flight);
//
//        // 输出结果
//        System.out.println("Result: " + result);

//        String expression = "a == empty && b == empty";
//
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("a", "");
//        paramMap.put("b", null);
//
//        Object object = MVEL.eval(expression, paramMap);
//        System.out.println(object); // true

//        String expression = "if (param > 0) {return \"Greater than zero!\"; } " +
//                "else if (param == -1) { return \"Minus one!\"; } " +
//                "else { return \"Something else!\"; }";
//
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("param", 2);
//
//        Object object = MVEL.eval(expression, paramMap);
//        System.out.println(object); // Greater than zero!

        String expression = "def addTwo(num1, num2) { num1 + num2; } val = addTwo(a, b);";

        Map<String, Object> paramMap = new HashMap();
        paramMap.put("a", 2);
        paramMap.put("b", 4);

        Object object = MVEL.eval(expression, paramMap);
        System.out.println(object); // 6
    }
}
