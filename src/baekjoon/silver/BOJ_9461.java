package baekjoon.silver;

import java.io.*;

public class BOJ_9461 {
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        arr = new long[101];

        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        arr[4] = 2;
        arr[5] = 2;

        // 반복
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            if (6 <= N) {
                for (int j = 6; j <= N; j++) {
                    arr[j] = arr[j - 1] + arr[j - 5];
                }
            }

            bw.write(arr[N] + "\n");
        }

        bw.flush();
        bw.close();
    }
}
