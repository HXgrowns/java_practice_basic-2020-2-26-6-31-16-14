package com.thoughtworks;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AnswerUtils {

    public static String getAnswer() {
        String answer = "";

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("src/main/resources/answer.txt");
            Scanner scanner = new Scanner(fileInputStream);
            if (scanner.hasNext()) {
                String answerString = scanner.nextLine();
                if (checkDataFormat(answerString)) {
                    answer = answerString;
                } else {
                    answer = randomAnswer();
                }
            }

        } catch (FileNotFoundException e) {
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
        return answer;
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

    public static boolean checkDataFormat(String data) {
        if (data == null || data.length() != 4) {
            return false;
        }
        int[] counts = new int[10];
        for (int i = 0; i < data.length(); i++) {
            char charAt = data.charAt(i);
            if (charAt < '0' || charAt > '9') {
                return false;
            }
            counts[charAt - '0']++;
        }
        for (int i : counts) {
            if (i > 1) {
                return false;
            }
        }
        return true;
    }
}
