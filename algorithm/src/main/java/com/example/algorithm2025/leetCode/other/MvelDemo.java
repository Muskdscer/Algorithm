package com.example.algorithm2025.leetCode.other;
import org.mvel2.MVEL;
import org.mvel2.ParserContext;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.integration.impl.MapVariableResolverFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MvelDemo {
    public static void main(String[] args) throws IOException {
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

//        String expression = "def addTwo(num1, num2) { num1 + num2; } val = addTwo(a, b);";
//
//        Map<String, Object> paramMap = new HashMap();
//        paramMap.put("a", 2);
//        paramMap.put("b", 4);
//
//        Object object = MVEL.eval(expression, paramMap);
//        System.out.println(object); // 6


        //mvel表达式，功能：变量大于10，a加1，小于10则减1
//        String expression = "int a = 10;" +
//                "if(case1 < 10){System.out.println('less 10');a += 1;}" +
//                "else{System.out.println('more then 10'); a -= 1;} return a;";
//        //在这个map中放入使用到的变量
//        Map vars = new HashMap();
//        vars.put("case1", new Integer(12));
//        //运行表达式
//        Integer result = (Integer) MVEL.eval(expression, vars);
//        System.out.println("result: " + result);

        String expression = buildMvelExp1();

        ParserContext ctx = new ParserContext();

        VariableResolverFactory resolverFactory = new MapVariableResolverFactory();
        // 这里使用的是springboot的文件路径
        Resource resource1 = new ClassPathResource("mvel/mvel-function1.mvel");
        File scriptFile1 = resource1.getFile();
        MVEL.evalFile(scriptFile1, ctx, resolverFactory);

        Resource resource2 = new ClassPathResource("mvel/mvel-function2.mvel");
        File scriptFile2 = resource2.getFile();
        MVEL.evalFile(scriptFile2, ctx, resolverFactory);
        // 添加使用到的变量
        Map vars = new HashMap();
        vars.put("payIntv", new Integer(15));
        vars.put("nowTime", new Date());
        String result = (String)MVEL.eval(expression, vars, resolverFactory);

        System.out.println("result: " + result);
    }

    private static String buildMvelExp(){
        StringBuilder exp = new StringBuilder();
        exp.append("int result = 0;");
        // 使用表达式文件中的方法
        exp.append("if(chgpaymode205(payIntv) < 10){");
        exp.append("result = 10;");
        exp.append("}else{");
        exp.append("result = 20;");
        exp.append("}");
        exp.append("return result;");
        return exp.toString();
    }

    private static String buildMvelExp1(){
        StringBuilder exp = new StringBuilder();
        // 引入使用的java文件
        exp.append("import java.text.SimpleDateFormat;");
        exp.append("import java.util.*;");
        exp.append("result = '';");
        // 使用表达式文件中的方法
        exp.append("if(chgpaymode205(payIntv) < 10){");
        exp.append("result = new SimpleDateFormat('yyyy-MM-dd').format(nowTime);");
        exp.append("}else{");
        exp.append("result = new SimpleDateFormat('yyyy-MM-dd').format(nowTime);");
        exp.append("}");
        exp.append("return result;");
        return exp.toString();
    }
}
