package com.thoughtworks;

public class Answer {
    private String answer;
    private int maxTimes;
    private int currentTimes;
    private boolean gameOver;

    public Answer(String answer, int maxTimes) {
        this.answer = answer;
        this.maxTimes = maxTimes;
        this.gameOver = false;
        this.currentTimes = 1;
    }

    public Result checkAnswer(String input) {
        this.currentTimes++;
        int aCount = 0;
        int totalCount = 0;
        for (int i = 0; i < input.length(); i++) {
            if (this.answer.charAt(i) == input.charAt(i)) {
                aCount++;
            }
            for (int j = 0; j < this.answer.length(); j++) {
                if (this.answer.charAt(j) == input.charAt(i)) {
                    totalCount++;
                }
            }
        }

        if (aCount == this.answer.length()) {
            this.gameOver = true;
            return new WinResult();
        }
        if (this.currentTimes > maxTimes) {
            this.gameOver = true;
            return new FailResult(this.answer, input, aCount, totalCount - aCount);
        }
        return new ErrorResult(input, aCount, totalCount - aCount);
    }

    public boolean isGameOver() {
        return gameOver;
    }
}
