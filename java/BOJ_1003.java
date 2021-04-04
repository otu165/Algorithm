package baekjoon.silver;

import java.io.*;

public class BOJ_1003 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        int[][] arr = new int[41][2]; // 입력 데이터 : 0 ~ 39

        // n = 0
        arr[0][0] = 1;
        arr[0][1] = 0;

        // n = 1
        arr[1][0] = 0;
        arr[1][1] = 1;

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            // n = 5
            for (int j = 2; j <= N; j++) {
                arr[j][0] = arr[j-2][0] + arr[j-1][0];
                arr[j][1] = arr[j-2][1] + arr[j-1][1];
            }

            bw.write(arr[N][0] + " " + arr[N][1] + "\n");
        }

        bw.flush();
        bw.close();
    }
}
