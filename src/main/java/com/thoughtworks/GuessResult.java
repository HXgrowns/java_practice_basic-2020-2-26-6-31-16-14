package com.thoughtworks;

import java.util.ArrayList;
import java.util.List;

public class GuessResult implements Result {
    private String answer;
    private String input;

    public GuessResult(String answer, String input) {
        this.answer = answer;
        this.input = input;
    }

    @Override
    public String printResult() {
        List<Integer> countAB = calculateAB();
        return String.format("%s %dA%dB\n", this.input, countAB.get(0), countAB.get(1));
    }

    public List<Integer> calculateAB() {
        List<Integer> countAB = new ArrayList<>();
        String copyAnswer = this.answer;
        String copyInput = this.input;

        int aCount = 0;
        int bCount = 0;
        for (int index = 0; index < copyAnswer.length(); index++) {
            if (copyAnswer.charAt(index) == copyInput.charAt(index)) {
                aCount++;
            }
        }

        for (int i = 0; i < copyInput.length(); i++) {
            for (int j = 0; j < copyAnswer.length(); j++) {
                if (copyAnswer.charAt(j) == copyInput.charAt(i)) {
                    bCount++;
                }
            }
        }
        countAB.add(aCount);
        countAB.add(bCount - aCount);
        return countAB;
    }

}
