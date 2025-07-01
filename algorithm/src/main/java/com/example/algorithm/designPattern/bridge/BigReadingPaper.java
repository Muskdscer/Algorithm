package com.example.algorithm.designPattern.bridge;

public class BigReadingPaper extends Paper{
    public BigReadingPaper(PaperLevel paperLevel) {
        super(paperLevel);
    }
    public void create() {
        System.out.println("BigReadingPaper，15个选择题，15个判断题，5个问答题");
        super.create();
    }
}
