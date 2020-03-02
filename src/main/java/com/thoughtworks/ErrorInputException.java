package com.thoughtworks;

public class ErrorInputException extends RuntimeException {
    private String input;

    public ErrorInputException(String input) {
        super(String.format("%s Wrong input\n", input));
        this.input = input;
    }

    public Result getErrorResult() {
        return new ErrorInputResult(this.input);
    }
}
