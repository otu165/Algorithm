package baekjoon.bronze;

import java.io.*;

public class BOJ_2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int seq = 0; // 외곽 순서
        int n = 0; // 등차
        int total = 0; // 외곽의 끝 번호

        while(total < N) {
            total = 1 + 6 * n;

            n += ++seq;
        }

        bw.write(seq + "\n");

        bw.flush();
        bw.close();
    }
}
