package com.example.algorithm.designPattern.strategy;

public class StrategyPattern {
    public static void main(String[] args) {
        Context context = new Context();
        Strategy s  = new ConcreteStrategyA();
        context.setStrategy(s);
        context.strategyMethod();
        System.out.println("-----------------------");
        s  = new ConcreteStrategyB();
        context.setStrategy(s);
        context.strategyMethod();
    }
}
