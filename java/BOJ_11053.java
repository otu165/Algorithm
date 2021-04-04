package baekjoon.silver;

import java.io.*;
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

        // DP 이용
        count[0] = 1;

        for (int i = 1; i < N; i++) {
            count[i] = 1;

            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i] && count[i] <= count[j]) {
                    count[i] = count[j] + 1;
                }
            }
        }

        // 최댓값 찾기
        int max = 0;
        for(int n : count)
            max = Math.max(max, n);

        bw.write(max + "");

        bw.flush();
        bw.close();

    }
}
