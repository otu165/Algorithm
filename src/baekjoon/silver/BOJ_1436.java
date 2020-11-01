package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int N = Integer.parseInt(br.readLine());

        int result = 665;
        while (N > 0) {
            result++;

            String s = String.valueOf(result);
            if(s.contains("666")) {
                N--;
            }
        }
        System.out.println(result);
    }
}
