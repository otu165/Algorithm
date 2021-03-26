package baekjoon.silver;

import java.io.*;

// 문제 : https://www.acmicpc.net/problem/1904
public class BOJ_1904 {
    static long[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        count = new long[N + 1];

        bw.write(dp(N) + "");

        bw.flush();
        bw.close();
    }

    private static long dp(int N) {
        if(N == 1)
            return 1;
        else { // 1, 2, 3, 5, 8 ...
            count[1] = 1;
            count[2] = 2;

            for (int i = 3; i <= N; i++) {
                count[i] = (count[i - 1] + count[i - 2]) % 15746;
            }

            return count[N];
        }
    }
}
