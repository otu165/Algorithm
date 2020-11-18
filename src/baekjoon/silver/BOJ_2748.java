package baekjoon.silver;

import java.io.*;

// 문제 : https://www.acmicpc.net/problem/2748
public class BOJ_2748 {
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr = new long[n + 1];

        bw.write(fibo(n) + "");

        bw.flush();
        bw.close();
    }

    private static long fibo(int n) {
        if(n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else {
            arr[0] = 0;
            arr[1] = 1;

            for (int i = 2; i <= n; i++) {
                arr[i] = arr[i - 1] + arr[i - 2];
            }

            return arr[n];
        }
    }
}
