package com.thoughtworks;

public class FailResult implements Result {
    private String answer;
    private String input;
    private int aCount;
    private int bCount;

    public FailResult(String answer, String input, int aCount, int bCount) {
        this.answer = answer;
        this.input = input;
        this.aCount = aCount;
        this.bCount = bCount;
    }

    @Override
    public void printResult() {
        System.out.format("%s %dA%dB\n", this.input, this.aCount, this.bCount);
        System.out.format("Unfortunately, you have no chance, the answer is %s!\n", this.answer);
    }
}
