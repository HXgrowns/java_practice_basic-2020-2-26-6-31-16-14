package com.thoughtworks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Answer answer = AnswerUtils.getAnswer();
        Scanner scanner = new Scanner(System.in);

        List<Result> results = new ArrayList<>();
        while (!answer.isGameOver()) {
            System.out.format("请输入第%d次猜测结果\n", answer.getCurrentTimes());
            String input = scanner.nextLine();
            try {
                AnswerUtils.checkDataFormat(input);
                results.add(answer.checkAnswer(input));
            } catch (ErrorInputException errorInputException) {
                results.add(errorInputException.getErrorResult());
            }

            for (Result result : results) {
                result.printResult();
            }
        }
    }
}
