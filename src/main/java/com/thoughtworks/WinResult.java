package com.thoughtworks;

public class WinResult implements Result {

    @Override
    public String printResult() {
        return "Congratulations, you win!\n";
    }
}
