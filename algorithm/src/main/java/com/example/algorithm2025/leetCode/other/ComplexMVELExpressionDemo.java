package com.example.algorithm2025.leetCode.other;

import org.mvel2.MVEL;

import java.math.BigDecimal;
import java.util.Map;

public class ComplexMVELExpressionDemo {
    public static void main(String[] args) {
        // 创建一个映射来保存我们的函数和变量
        Map<String, Object> vars = new java.util.HashMap<>();

        // 创建 Helper 类的实例
        Helper helper = new Helper();

        // 将 Helper 实例添加到变量映射中
        vars.put("helper", helper);

        // 创建示例数据：inputMap 和 flavorMap，使用 Object 类型以支持多种数值类型
        Map<String, Object> inputMap = new java.util.HashMap<>();
        inputMap.put("vCPU", 8); // 示例 vCPU 值，int 类型
        inputMap.put("内存", 16.0); // 示例 内存值，double 类型

        Map<String, Object> flavorMap = new java.util.HashMap<>();
        flavorMap.put("CPU数量", 4); // 示例 CPU 数量，int 类型
        flavorMap.put("CPU型号", new BigDecimal("3.5")); // 示例 CPU 型号，BigDecimal 类型
        flavorMap.put("内存数量", 2); // 示例 内存 数量，int 类型
        flavorMap.put("内存型号", new BigDecimal("2.66")); // 示例 内存 型号，BigDecimal 类型

        // 将示例数据也添加到变量映射中
        vars.put("input", inputMap);
        vars.put("flavor", flavorMap);

        // 复杂表达式字符串
        String complexExpression =
                "helper.avg(input['vCPU'] / (3 * flavor['CPU数量'] * flavor['CPU型号']), " +
                        "input['内存'] / (flavor['内存数量'] * flavor['内存型号']))";

        // 使用 eval 直接执行表达式并传入变量映射
        try {
            // 由于我们返回的是 BigDecimal，所以这里直接强转
            BigDecimal result = (BigDecimal) MVEL.eval(complexExpression, vars);

            // 输出结果
            System.out.println("Average Result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 测试其他方法
        String sumExpression = "helper.sum(input['vCPU'], flavor['CPU数量'])";
        String maxExpression = "helper.max(input['vCPU'], flavor['CPU数量'])";
        String minExpression = "helper.min(input['vCPU'], flavor['CPU数量'])";

        try {
            BigDecimal sumResult = (BigDecimal) MVEL.eval(sumExpression, vars);
            BigDecimal maxResult = (BigDecimal) MVEL.eval(maxExpression, vars);
            BigDecimal minResult = (BigDecimal) MVEL.eval(minExpression, vars);

            // 输出结果
            System.out.println("Sum Result: " + sumResult);
            System.out.println("Max Result: " + maxResult);
            System.out.println("Min Result: " + minResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
