package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2741 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //입력
        int n = Integer.parseInt(br.readLine());

        //풀이
        for (int i = 1; i <= n; i++) {
            //출력
            System.out.println(i);
        }
    }
}
