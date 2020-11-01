package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    등차는 음수일 수 있다
 */

public class BOJ_1065 {
    public static int count = 99;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //입력
        int n = Integer.parseInt(br.readLine());

        //풀이
        if (n < 100) {
            count = n;
        }
        else {
            for (int i = 100; i <= n; i++) {
                if (i == 1000) {
                    break;
                }

                //세 자리 수
                int first = i / 100;
                int second = i % 100 / 10;
                int third = i % 10;

                if (second - first == third - second) {
                    count++;
                }
            }
        }

        //출력
        System.out.println(count);
    }
}
