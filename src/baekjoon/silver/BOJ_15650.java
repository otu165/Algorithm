package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15650 {
    static StringBuilder sb = new StringBuilder();
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        array = new int[M];

        dfs(N, M, 0,1);

        System.out.println(sb);
    }

    public static void dfs(int N, int M, int depth, int start) {
        if(depth == M) {
            for(int num : array)
                sb.append(num + " ");
            sb.append("\n");

            return;
        }

        // 반복 + 재귀
        for (int i = start; i <= N; i++) {
            array[depth] = i;
            dfs(N, M, depth + 1, i + 1);
        }
    }
}