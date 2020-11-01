package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2581 {
    public static int sum = 0, min = 10001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //입력
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        //풀이
        for (int i = m; i <= n; i++) {
            //예외 처리(1, 2)
            if(i == 1) {
                continue;
            }
            else if(i == 2) {
                sum = 2;
                min = 2;
                continue;
            }

            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                sum += i;
                if (i < min) {
                    min = i;
                }
            }
        }

       //출력(소수의 합 및 최솟값)
        if(sum == 0) {
            System.out.println(-1);
        }
        else {
            System.out.printf("%d\n%d", sum, min);
        }
    }
}
