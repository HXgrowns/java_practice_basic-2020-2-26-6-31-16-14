package com.thoughtworks;

public class ErrorInputResult extends RuntimeException {
    public String printException(String input) {
        return String.format("%s Wrong input\n", input);
    }
}
