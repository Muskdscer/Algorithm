package com.example.algorithm.designPattern.bridge;

public class PaperLevel1 implements PaperLevel{
    @Override
    public void getRules() {
        System.out.println("paperlevel1 1星难度占20%了，2星难度40%，3星难度40%");
    }
}
