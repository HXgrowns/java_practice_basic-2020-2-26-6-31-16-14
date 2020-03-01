package com.thoughtworks;

public class WinResult implements Result {

    @Override
    public void printResult() {
        System.out.format("Congratulations, you win!\n");
    }
}
