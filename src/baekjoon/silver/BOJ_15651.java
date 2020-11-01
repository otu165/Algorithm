package baekjoon.silver;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_15651 {
    public static StringBuilder sb = new StringBuilder();
    public static int[] result;
    public static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[M];

        dfs(0);

        // 숫자 중복 가능, 사전순 출력
        System.out.println(sb);
    }

    public static void dfs(int depth) {
        if(depth == M) {
            for(int i : result) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            result[depth] = i + 1;
            dfs(depth + 1);
        }
    }
}
