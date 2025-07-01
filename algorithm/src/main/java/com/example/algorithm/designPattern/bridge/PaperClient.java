package com.example.algorithm.designPattern.bridge;

public class PaperClient {
    public static void main(String[] args) {
        PaperLevel2 paperLevel2 = new PaperLevel2();
        ProgramPaper paper = new ProgramPaper(paperLevel2);
        paper.create();
    }
}
