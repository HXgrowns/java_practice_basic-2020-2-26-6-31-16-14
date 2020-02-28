package com.thoughtworks;

public class FailResult implements Result {
    private String answer;

    public FailResult(String answer) {
        this.answer = answer;
    }

    @Override
    public String printResult() {
        return String.format("Unfortunately, you have no chance, the answer is %s!\n", this.answer);
    }
}
