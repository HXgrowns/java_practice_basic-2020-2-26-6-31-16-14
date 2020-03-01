package com.thoughtworks;

public class ErrorInputResult extends RuntimeException implements Result {
    private String input;

    public ErrorInputResult(String input) {
        this.input = input;
    }

    @Override
    public void printResult() {
        System.out.format("%s Wrong input\n", this.input);
    }
}
