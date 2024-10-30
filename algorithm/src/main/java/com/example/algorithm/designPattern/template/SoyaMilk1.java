package com.example.algorithm.designPattern.template;

/**
 * 使用钩子方法customerWantCondiment()决定是否需要添加配料
 */
public abstract class SoyaMilk1 {
    //模板方法可做成final,不让子类去覆盖
    final void make()
    {
        select();
        if (customerWantCondiment())
        {
            addCondiments();
        }
        soak();
        beat();
    }

    void select()
    {
        System.out.println("1.选择好的黄豆");
    }
    abstract void addCondiments();
    void soak()
    {
        System.out.println("3.浸泡");
    }
    void beat()
    {
        System.out.println("4.打碎");
    }
    //钩子方法决定是否要添加配料
    boolean customerWantCondiment() {
        return true;
    };
}
