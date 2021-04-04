package baekjoon.silver;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_15651 {
    static StringBuilder sb = new StringBuilder();
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        result = new int[M];

        dfs(N, M, 0);

        // 중복 X + 사전순
        System.out.println(sb);
    }

    public static void dfs(int N, int M, int depth) {
        if(depth == M) {
            for(int num : result)
                sb.append(num + " ");
            sb.append("\n");

            return;
        }

        // 반복 + 재귀
        for (int i = 0; i < N; i++) {
            result[depth] = i + 1;
            dfs(N, M, depth + 1);
        }

    }
}