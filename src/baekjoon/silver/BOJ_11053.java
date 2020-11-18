package baekjoon.silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 수열 A의 크기
        int[] arr = new int[N];
        int[] count = new int[N]; // 부분 수열 길이

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int total = 1;
            int max = arr[i];

            for (int j = i + 1; j < N; j++) {
                if(max < arr[j]) {
                    max = arr[j];
                    total++;
                }
            }

            count[i] = total;
        }

        bw.write(Arrays.stream(count).max().getAsInt() + "");

        bw.flush();
        bw.close();

    }
}
