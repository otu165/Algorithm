package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15652 {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[M];

        dfs(0, 1);

        System.out.println(sb);
    }

    public static void dfs(int depth, int start) {
        if(depth == M) {
            for(int num : result)
                sb.append(num + " ");
            sb.append("\n");

            return;
        }

        // 반복 + 재귀
        for (int i = start; i <= N; i++) {
            result[depth] = i;
            dfs(depth + 1, i);
        }
    }
}
