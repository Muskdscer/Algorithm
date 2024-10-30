package com.example.algorithm.designPattern.template;

/**
 * 抽象类 表示豆浆
 */
public abstract class SoyaMilk {
    //模板方法：可做成final 不让子类去覆盖
    final void make(){
        select();
        addCondiments();
        soak();
        beat();
    }

    //选材料
    void select(){
        System.out.println("第一步选择新鲜豆子");
    }
    //添加配料
    abstract void addCondiments();
    //浸泡
    void soak(){
        System.out.println("第三步：浸泡");
    }
    //打碎
    void beat(){
        System.out.println("第四步：打碎");
    }

}
