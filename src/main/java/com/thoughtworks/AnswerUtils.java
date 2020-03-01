package com.thoughtworks;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AnswerUtils {
    private static final int MAX_TIMES = 6;

    public static Answer getAnswer() {
        String answer = "";

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("src/main/resources/answer.txt");
            Scanner scanner = new Scanner(fileInputStream);
            if (scanner.hasNext()) {
                String answerString = scanner.nextLine();
                checkDataFormat(answerString);
                answer = answerString;
            }
        } catch (Exception e) {
            answer = randomAnswer();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new Answer(answer, MAX_TIMES);
    }

    public static String randomAnswer() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);
        numbers = numbers.subList(0, 4);

        String answer = "";
        for (Integer number : numbers) {
            answer += number;
        }
        return answer;
    }

    public static void checkDataFormat(String data) throws ErrorInputResult {
        if (data == null || data.length() != 4) {
            throw new ErrorInputResult(data);
        }

        int[] counts = calculateCounts(data);
        if (counts == null) {
            throw new ErrorInputResult(data);
        }

        for (int count : counts) {
            if (count > 1) {
                throw new ErrorInputResult(data);
            }
        }
    }

    public static int[] calculateCounts(String data) {
        int[] counts = new int[10];
        for (int i = 0; i < data.length(); i++) {
            char charAt = data.charAt(i);
            if (charAt < '0' || charAt > '9') {
                return null;
            }
            counts[charAt - '0']++;
        }
        return counts;
    }
}
