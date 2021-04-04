package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11721 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //입력
        String input = br.readLine();
        int inputLength = input.length();

        //정답
        int lines = (inputLength % 10 == 0) ? inputLength / 10 : inputLength / 10 + 1;
        String array[] = new String[lines];

        int index = 0;
        for (int i = 0; i < lines; i++) {
            if (input.length() < 10) {
                array[i] = input;
            }
            else {
                array[i] = input.substring(0, 10);
                input = input.substring(10);
            }
        }

        //출력
        for (int i = 0; i < lines; i++) {
            System.out.println(array[i]);
        }
    }
}