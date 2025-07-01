package com.example.algorithm.designPattern.bridge;

public class Paper {
    protected PaperLevel paperLevel;
    public  Paper(PaperLevel paperLevel) {
        this.paperLevel = paperLevel;
    }
    public void create() {
        paperLevel.getRules();
        System.out.println("按照学科和level生成试卷");
    }
}
