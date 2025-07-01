package com.example.algorithm.designPattern.bridge;

public class ProgramPaper extends Paper{
    public ProgramPaper(PaperLevel paperLevel) {
        super(paperLevel);
    }
    public void create() {
        System.out.println("Program,30个选择题，5个判断，5个问答");
        super.create();
    }
}
