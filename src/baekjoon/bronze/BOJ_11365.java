package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 문제 : !밀비 급일
public class BOJ_11365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String line = br.readLine();

            // 종료 조건
            if(line.equals("END"))
                break;

            for (int i = line.length() - 1; i >= 0; i--) {
                sb.append(line.charAt(i));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
