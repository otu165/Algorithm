package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int result = 0;

        for (int i = 1; i < N; i++) {
            int sum = i;

            String n = String.valueOf(i);
            for (int j = 0; j < n.length(); j++) {
                sum += Integer.parseInt(String.valueOf(n.charAt(j)));
            }

            if(sum == N) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }
}
