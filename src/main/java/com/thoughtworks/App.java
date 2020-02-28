package com.thoughtworks;

import java.io.IOException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws IOException {
        String answer = AnswerUtils.getAnswer();
        Scanner scanner = new Scanner(System.in);

        int count = 0;
        String result = "";
        while (count <= 5) {

            String input = scanner.nextLine();
            if (!AnswerUtils.checkDataFormat(input)) {
                result += new ErrorInputResult().printException(input);
                count--;
            } else {
                GuessResult guessResult = new GuessResult(answer, input);
                if (guessResult.calculateAB().get(0) == answer.length()) {
                    result += guessResult.printResult();
                    result += new WinResult().printResult();
                    System.out.println(result);
                    break;
                } else {
                    if (count < 5) {
                        result += guessResult.printResult();
                    } else {
                        result += new FailResult(answer).printResult();
                    }
                }
            }
            System.out.println(result);
            count++;
        }

    }
}
