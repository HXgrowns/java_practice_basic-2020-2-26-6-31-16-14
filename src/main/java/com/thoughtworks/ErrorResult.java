package com.thoughtworks;

public class ErrorResult implements Result {
    private String input;
    private int aCount;
    private int bCount;

    public ErrorResult(String input, int aCount, int bCount) {
        this.input = input;
        this.aCount = aCount;
        this.bCount = bCount;
    }

    @Override
    public void printResult() {
        System.out.format("%s %dA%dB\n", this.input, this.aCount, this.bCount);
    }

}
