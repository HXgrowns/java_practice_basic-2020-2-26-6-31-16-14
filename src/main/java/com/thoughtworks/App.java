package com.thoughtworks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Answer answer = AnswerUtils.getAnswer();
        Scanner scanner = new Scanner(System.in);

        List<Result> results = new ArrayList<>();
        while (!answer.isGameOver()) {
            String input = scanner.nextLine();
            try {
                AnswerUtils.checkDataFormat(input);
                results.add(answer.checkAnswer(input));
            } catch (ErrorInputResult errorInputResult) {
                results.add(errorInputResult);
            }

            for (Result result : results) {
                result.printResult();
            }
        }
    }
}
