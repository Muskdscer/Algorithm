package com.example.algorithm.designPattern.bridge;

public class PaperLevel2 implements PaperLevel{
    @Override
    public void getRules() {
        System.out.println("paperlevel2 1星难度占20%了，2星难度50%，3星难度30%");
    }
}
