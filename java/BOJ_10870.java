package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //입력
        int n = Integer.parseInt(br.readLine());

        //출력
        if(n == 0 || n == 1) {
            System.out.println(n);
        }
        else {
            System.out.println(fibo(n-1) + fibo(n-2));
        }
    }

    public static int fibo(int n) {
        if (n <= 1) {
            return n;
        }
        else {
            return fibo(n - 1) + fibo(n - 2);
        }
    }
}
